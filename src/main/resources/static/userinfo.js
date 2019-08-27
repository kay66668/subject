layui.use('table', function(){
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.$;
    //第一个实例
    table.render({
        elem: '#demo'
        ,url: '/getList'
        ,page: true
        ,limit:5
        ,limits:[1,2,3,5,10,20,30,50]
        ,toolbar:"#addDemo"
        ,title:"学员信息汇总"
        ,loading:true
        ,cols: [[

            {field: 'no',type:'checkbox', width:"5%",fixed: 'left',align:"center"}
            ,{field: 'showname', title: '真实姓名', width:"10%",align:"center"}
            ,{field: 'age', title: '年龄', width:"5%",align:"center"}
            ,{field: 'gender', title: '性别', width:"5%", sort: true,align:"center"}
            ,{field: 'postbox', title: '邮箱', width: "15%",align:"center",sort:true}
            ,{field: 'address', title: '地址', width: "15%",align:"center",templet:'#resutlTemplet'}
            ,{field: 'bir', title: '出生日期', width:"12.5%", sort: true,align:"center",templet:'<div>{{ layui.util.toDateString(d.bir, "yyyy-MM-dd") }}</div>'}
            ,{field: 'ed', title: '入职日期', width:"12.5%",align:"center",templet:'<div>{{ layui.util.toDateString(d.bir, "yyyy-MM-dd") }}</div>'}
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
                    title: "添加用户",
                    content: '/forward/user_tail',
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
               $.post("/delUserinfo",{"userid":data.userid},function () {
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
        var mypostbox = $("#postbox").val();

        table.reload('demo',{
            where : {
                postbox: mypostbox
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