<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/echarts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
<body>
<div id="chartmain" style="width: 600px; height: 400px;"></div>
</body>
<script type="text/javascript">
    //初始化echarts
    function chushihua(myChart){
        var option = {
            title:{
                text:'ECharts 数据统计'
            },
            legend:{
                data:['访问量','用户量']
            },
            xAxis:{
                data:["Android","IOS","PC","Other"]
            },
            yAxis:{},
            series:[
                {
                    name:'访问量',
                    type:'bar',
                    data:[180,420,333,83]
                },
                {
                    name:'用户量',
                    type:'bar',
                    data:[125,330,230,60]
                }
            ]
        };

        myChart.setOption(option);
    }

    //从数据库读取数据赋值给echarts
    function fuzhi(myChart){
        $.ajax({
            contentType : "application/json",
            type : "GET",
            url : "${pageContext.request.contextPath}/info",
            datatype:'json',
            success : function(data) {
                //创建一个数组，用来装对象传给series.data，因为series.data里面不能直接鞋for循环
                var servicedata=[];
                var servicedatas=[];
                for(var i=0;i<data.length;i++){
                    var objf=new Object();
                    objf.value = data[i].namel ;
                    servicedata[i]=objf;
                }
                for(var i=0;i<data.length;i++){
                    var obj=new Object();
                    obj.value=data[i].count;
                   /* servicedatas.push(obj);*/
                    servicedatas[i]=obj;
                }
                servicedatas=
                myChart.setOption({
                    title:{
                        text:'ECharts 数据统计'
                    },
                    xAxis:{
                        data:servicedata
                    },
                    series:[
                        {
                            //根据名字对应到相应的系列
                            name:"访问量",
                            data:servicedatas
                        }, {
                            //根据名字对应到相应的系列
                            name:"用户量",
                            data:servicedatas
                        }

                    ]

                });

            }
        });
    }

    //初始化echarts实例
    var myChart = echarts.init(document.getElementById('chartmain'));
    chushihua(myChart);
    fuzhi(myChart);
</script>
</html>