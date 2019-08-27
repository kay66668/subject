layui.use('table', function(){
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.$;
    //第一个实例
    table.render({
        elem: '#demo'
        ,url: '/show'
        ,page: true
        ,limit:5
        ,limits:[1,2,3,5,10,20,30,50]
        ,toolbar:"#addDemo"
        ,loading:true
        ,cols: [[

            {field: 'no',type:'checkbox', width:"10%",fixed: 'left',align:"center"}
            ,{field: 'id', title: '编号', width:"10%", sort: true, fixed: 'left',align:"center"}
            ,{field: 'showname', title: '姓名', width:"15%",align:"center"}
            ,{field: 'name', title: '部门', width:"15%", sort: true,align:"center"}
            ,{field: 'postname', title: '岗位', width:"20%",align:"center"}
            ,{field: 'tel', title: '联系方式', width: "30%",align:"center",sort:true}

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
                    content: '/forward/addUser',
                    zIndex: layer.zIndex, //重点1
                    success: function (layero) {
                        layer.setTop(layero); //重点2
                    }
                });
                break;
        }
        ;
    });






    $("#search").click(function () {
        var myname = $("#name").val();


        table.reload('demo',{
            where : {
                showname: myname,

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