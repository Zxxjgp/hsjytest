r.
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
</head>
<script type="text/javascript">
    function submitData(){
        var name=$("#name").val();
        var title=$("#title").val();

        if(name==null || name==''){
            alert("请输入昵称！");
        }else if(title==null || title==''){
            alert("请输入个性签名！");
        }else{
            $('#form1').submit();
        }
    }

</script>
<body>
<div>
<form id="form1" action="${pageContext.request.contextPath}/test/fileupload" method="post" enctype="multipart/form-data">
    <table cellspacing="20px">
        <tr>
            <td width="80px">用户名：</td>
            <td>
                <input type="hidden" id="id" name="id" value="${currentUser.id }"/>
                <input type="text" id="name" name="name" style="width: 200px;"/>
            </td>
        </tr>
        <tr>
            <td>昵称：</td>
            <td><input type="text" id="title" name="title"  style="width: 200px;"/></td>
        </tr>

        <tr>
            <td>个人头像：</td>
            <td><input type="file" id="file" name="file" style="width: 400px;"/></td>
        </tr>
                    <tr>
                    <td></td> <td>
                    <a href="javascript:submitData()" class="easyui-linkbutton" data-options="iconCls:'icon-submit'">提交</a>
                    </td>
                    </tr>
                    </table>
      </form>
</div>
</body>
</html>
