<html>

<%@ page contentType="text/html; charset=utf-8" language="java"
         pageEncoding="utf-8" errorPage="" import="java.net.*"%>
<head>
    <title>123</title>
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <script type="text/javascript">
        function getElements()
        {
            var x=document.getElementsByName("inputname");
            var _list = [];
            for (var i = 0; i < x.length; i++) {
                _list[i] = x[i].value;
            }
            $.ajax({
                type:"POST",
                url:'http://localhost:8080/hsjytest/test/arraylisttset',
                data:{"datelist":_list},
                traditional :true,  //注意这个参数是必须的
                dataType:"json",
                success:function(date){
                    alert("date");
                    alert(date);
                    if(date == "GOOD"){
                        /*document.getElementById("stage_two").style.display="";*/
                        alert("你已经完全的学会这些知识！");
                    }else if(date == "ERROR"){
                        alert("所上传证书不是一个完整的证书链，请重新上传！");
                    }
                }
            });
        }
    </script>


</head>

<body>
<h2>Hello Wo!</h2>
<form action="http://localhost:8080/hsjytest/test/save" method="post">
    <div class="title">

        姓名：<input type="text" id="username" name="username"/>
        密码：<input type="text" name="password" id="password">
        <input type="submit" value="提交">
    </div>


</form>
<form action="http://localhost:8080/hsjytest/test/save" method="post">
    <div>
        <input name="inputname" type="text" size="30" />
        <input name="inputname" type="text" size="30" />
        <input name="inputname" type="text" size="30" />
        <input name="inputname" type="text" size="30" />

        <input type="button" onclick="getElements()" value="提交进行数据的测试">
    </div>

</form>

<a href="../page/he.jsp">1316就业  囧s</a>
</body>

</html>
