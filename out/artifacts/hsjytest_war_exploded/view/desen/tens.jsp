<%--
  Created by IntelliJ IDEA.
  User: XX
  Date: 2018/6/25
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
</head>
<body>
  <script type="text/javascript">
      function des() {
          var id =$("#des").val();
          alert(id);
          $.ajax({
              type: 'POST',
              url: '${pageContext.request.contextPath}/test/nulltest',
              data:{"id":id},
              success: function(data){
                  alert(data);
                      $(".xs").append(data);
                  /*addBox(data);*/
              },
              error:function(data) {
                  console.log('错误...');
              },
          });
      }
      function addBox(result){
          //result是一个集合,所以需要先遍历

          $(".xs").append("<input type=\"text\" value=\"result\"/> ");
/*          $.each(result,function(index,obj){
              var data = data;

          });*/
      }
  </script>
  <input type="text" id="des" name="des" width="50px" height="100px">
      <div class="xs"></div>

    <input type="button" onclick="des()" value="提交"/>


</body>
</html>
