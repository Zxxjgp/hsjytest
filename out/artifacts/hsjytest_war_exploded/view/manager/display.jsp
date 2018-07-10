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
            series:[{
                name:'访问量',
                type:'pie',
                radius:'90%',
                data:[
/*                    {value:123, name:'DADA'},
                    {value:789, name:'DDI'},*/
                ]
            }]
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
                for(var i=0;i<data.length;i++){
                    var obj=new Object();
                    obj.value=data[i].count;
                    obj.name=data[i].namel;
//                    servicedata[i]=obj;
                    servicedata.push(obj);
                }

                myChart.setOption({
                    title:{
                        text:'ECharts 数据统计'
                    },
                    series:[{
                        name:'访问量',
                        type:'pie',
                        radius:'60%',
                        data:servicedata
                    }]

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