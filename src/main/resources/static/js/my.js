layui.use(['table','layer','jquery'], function(){
    var table = layui.table;
    var layer=layui.layer;
    var $=layui.$;
    //第一个实例


    //监听头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id)
            ,data = checkStatus.data; //获取选中的数据
        switch(obj.event){
            case 'add':
                layer.open({
                    type: 2,
                    shade: true, //遮罩
                    area: ['500px','400px'],
                    maxmin: false, //关闭最大化最小化按钮
                    anim:1, //从上掉落
                    title:'添加用户',
                    content: '/forward/post1',
                    zIndex: layer.zIndex, //重点1
                    success: function(layero){
                        layer.setTop(layero); //重点2
                    }
                });
        };
    });

    //监听工具条
    table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象

        if(layEvent === 'detail'){ //查看
            //do somehing
            layer.open({
                type: 2,
                shade: true, //遮罩
                area: ['500px','400px'],
                maxmin: false, //关闭最大化最小化按钮
                anim:1, //从上掉落
                title:'用户详情',
                content: '/forward/detail',
                zIndex: layer.zIndex, //重点1
                success: function(layero){
                    layer.setTop(layero); //重点2

                    /*********弹出新窗体后,给新窗中的控件赋值***********/
                    //获得弹出层的body部分
                    var body=layui.layer.getChildFrame("body");
                    body.find("[name='name']").val(data.name);
                    body.find("[name='score']").val(data.score);
                    body.find("[name='clazz']").val(data.clazz);
                    body.find("[value='"+data.gender+"']").attr("checked",true);//选中指定性别的单选按钮
                    body.find("[name='bir']").val(format(data.bir,"yyyy-MM-dd"));

                }
            });
        } else if(layEvent === 'del'){ //删除
         /*   layer.confirm('真的删除行么', function(index){
                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                layer.close(index);
                //向服务端发送删除指令
            });*/
            layer.confirm('真的删除行吗?',function (index) {

                $.post("/del",{"id":data.id},function () {
                    table.reload('demo', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                    });
                    layer.close(index);
                });


            });
        } else if(layEvent === 'edit'){ //编辑
            layer.open({
                type: 2,
                shade: true, //遮罩
                area: ['500px','400px'],
                maxmin: false, //关闭最大化最小化按钮
                anim:1, //从上掉落
                title:'用户修改',
                content: '/forward/update',
                zIndex: layer.zIndex, //重点1
                success: function(layero){
                    layer.setTop(layero); //重点2

                    /*********弹出新窗体后,给新窗中的控件赋值***********/
                        //获得弹出层的body部分
                    var body=layui.layer.getChildFrame("body");
                    body.find("[name='id']").val(data.id);
                    body.find("[name='name']").val(data.name);
                    body.find("[name='score']").val(data.score);
                    body.find("[name='clazz']").val(data.clazz);
                    body.find("[value='"+data.gender+"']").attr("checked",true);//选中指定性别的单选按钮
                    body.find("[name='bir']").val(format(data.bir,"yyyy-MM-dd"));

                }
            });
        }
    });

    /***********指定日期格式**************/
    //指定日期转换格式
   /* var format = function (time, format) {
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
    }*/

    /**********个搜索按钮绑定事件*************/
   /* $("#search").click(function () {
        var myname=$("#name").val();
        var myclazz=$("#clazz").val();

        table.reload('demo', {
            where: { //设定异步数据接口的额外参数，任意设
                name: myname
                ,clazz: myclazz
                //…
            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        });

    });

    /!******给重置按钮绑定事件*******!/
    $("#reset").click(function () {
        $("input").val("");
    });*/

});