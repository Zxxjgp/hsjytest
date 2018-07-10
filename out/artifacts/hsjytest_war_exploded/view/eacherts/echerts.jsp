<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/echarts.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
</head>
<body>
<div id="chartmain" style="width:600px; height: 400px;"></div>
<script type="text/javascript">
        option = {
            title: {
                text: '某站点用户访问来源',
                subtext: '纯属虚构',
                x: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: ['直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎']
            },
            series: [
                {
                    name: '访问来源',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '60%'],
                    data: [
                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
    function fuzhi(myChart){
        $.ajax({
            contentType : "application/json",
            type : "GET",
            url : "${pageContext.request.contextPath}/ht/ea",
            datatype:'json',
            success : function(data) {
                alert(data);
                //创建一个数组，用来装对象传给series.data，因为series.data里面不能直接鞋for循环
                var sa=[];
                sa=['直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎'];
                myChart.setOption({
                    title:{
                        text: '某站点用户访问来源',
                        subtext: '纯属虚构'
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data: sa
                    },
                    series:[
                        {
                            name: '访问来源',
                            type: 'pie',
                            radius: '55%',
                            center: ['50%', '60%'],
                            data: data
                        }
                    ]
                });

            }
        });
    }
    //初始化echarts实例
    var myChart = echarts.init(document.getElementById('chartmain'));
        fuzhi(myChart);
    //使用制定的配置项和数据显示图表
    myChart.setOption(option);
</script>
</body>
</html>
