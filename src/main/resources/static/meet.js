layui.use('table', function(){
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.$;
    //第一个实例
    table.render({
        elem: '#demo'
        ,url: '/getMeetList'
        ,page: true
        ,limit:5
        ,limits:[1,2,3,5,10,20,30,50]
        ,toolbar:"#addTitle"
        ,loading:true
        ,cols: [[

            {field: 'no',type:'checkbox', width:"5%",fixed: 'left',align:"center"}
            ,{field: 'id', title: '编号', width:"5%",align:"center"}
            ,{field: 'createBy', title: '会议负责人', width:"10%",align:"center"}
            ,{field: 'title', title: '会议主题', width:"10%", sort: true,align:"center"}
            ,{field: 'descr', title: '会议描述', width: "12.5%",align:"center",sort:true}
            ,{field: 'startTime', title: '会议时间', width: "12.5%",align:"center",templet:'<div>{{ layui.util.toDateString(d.startTime, "yyyy-MM-dd") }}</div>'}
            ,{field: 'createTime', title: '创建时间', width:"12.5%", sort: true,align:"center",templet:'<div>{{ layui.util.toDateString(d.createTime, "yyyy-MM-dd") }}</div>'}
            ,{field: 'status', title: '状态', width:"12.5%",align:"center"}
            ,{field: 'clazz', title: '操作', width:"20%",align:"center",toolbar:"#barDemo"}

        ]]
    });

    //监听头工具栏事件
    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id)
            , data = checkStatus.data; //获取选中的数据
        switch (obj.event) {
            case 'add':
                layer.open({
                    type: 2,
                    shade: true,
                    area: ['500px', '400px'],
                    maxmin: false,
                    anim: 1,
                    title: "添加会议",
                    content: '/forward/addMeet',
                    zIndex: layer.zIndex, //重点1
                    success: function (layero) {
                        layer.setTop(layero); //重点2
                    }
                });
                break;
        }
        ;
    });


    //监听工具条
    table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象

        if(layEvent === 'del'){ //删除
            layer.confirm('真的删除行么', function(index){
                $.post("/delMeet",{"id":data.id},function () {
                    table.reload('demo',{
                        page:{
                            curr:1
                        }
                    });
                    layer.close(index);
                })
            });
        } else if(layEvent === 'edit') { //编辑
            layer.open({
                type: 2,
                shade: true,
                area: ['500px', '400px'],
                maxmin: false,
                anim: 1,
                title: "用户详情",
                content: '/forward/user_update',
                zIndex: layer.zIndex, //重点1
                success: function (layero) {
                    layer.setTop(layero); //重点2

                    var body = layui.layer.getChildFrame("body");

                    body.find("[name='userid']").val(data.userid);
                    body.find("[name='age']").val(data.age);
                    body.find("[name='"+data.gender+"']").attr("checked",true);
                    body.find("[name='postbox']").val(data.postbox);
                    body.find("[name='address']").val(data.address);
                    body.find("[name='ed']").val(format(data.ed,'yyyy-MM-dd'));
                    body.find("[name='bir']").val(format(data.bir,'yyyy-MM-dd'));
                }
            });
        }
    });
//指定日期转换格式
    var format = function (time, format) {
        var t = new Date(time);
        var tf = function (i) {
            return (i < 10 ? '0' : '') + i
        };
        return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function (a) {
            switch (a) {
                case 'yyyy':
                    return tf(t.getFullYear());
                    break;
                case 'MM':
                    return tf(t.getMonth() + 1);
                    break;
                case 'mm':
                    return tf(t.getMinutes());
                    break;
                case 'dd':
                    return tf(t.getDate());
                    break;
                case 'HH':
                    return tf(t.getHours());
                    break;
                case 'ss':
                    return tf(t.getSeconds());
                    break;
            }
        })

    }

    $("#search").click(function () {
        var mycreateBy = $("#createBy").val();
        var mytitle=$("#title").val();

        table.reload('demo',{
            where : {
                createBy: mycreateBy,
                title: mytitle
            },
            page:{
                curr:1
            }
        });
    });

    $("#reset").click(function () {
        $("input").val("");
    })
});