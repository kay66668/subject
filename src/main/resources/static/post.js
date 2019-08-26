layui.use('table', function(){
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.$;
    //第一个实例
    table.render({
        elem: '#demo'
        ,url: '/getList2'
        ,page: true
        ,limit:5
        ,limits:[1,2,3,5,10,20,30,50]
        ,toolbar:"#addDemo"
        ,title:"学员信息汇总"
        ,loading:true
        ,cols: [[

            {field: 'no',type:'checkbox', width:"5%",fixed: 'left',align:"center"}
            ,{field: 'id', title: '编号', width:"35%", sort: true, fixed: 'left',align:"center"}
            ,{field: 'postname', title: '岗位名', width:"40%",align:"center"}
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
                    content: '/forward/post_tail',
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
                $.post("/delPost",{"id":data.id},function () {
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
                title: "修改岗位",
                content: '/forward/post_update',
                zIndex: layer.zIndex, //重点1
                success: function (layero) {
                    layer.setTop(layero); //重点2

                    var body = layui.layer.getChildFrame("body");

                    body.find("[name='id']").val(data.id);
                    body.find("[name='postname']").val(data.postname);
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
        var myname = $("#postname").val();
        table.reload('demo',{
            where : {
               postname:myname
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