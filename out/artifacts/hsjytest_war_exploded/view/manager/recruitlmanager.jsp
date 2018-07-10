<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>招募管理页面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">

        var url;

        function deleteLink(){
            var selectedRows=$("#dg").datagrid("getSelections");
            var state =$(".ste").value;
            if(selectedRows.length==0){
                $.messager.alert("系统提示","请选择数据！");
                return;
            }
            var strIds=[];
            for(var i=0;i<selectedRows.length;i++){
                strIds.push(selectedRows[i].id);
            }
            var ids=strIds.join(",");

            var states=[];
            for(var i=0;i<selectedRows.length;i++){
                states.push(selectedRows[i].state);
            }
            var state =states.join(",");


            $.messager.confirm("系统提示","您确定要操作这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
                if(r){
                    $.post("${pageContext.request.contextPath}/delete",{ids:ids,state:state},function(result){
                        if(result.success){
                            $.messager.alert("系统提示","SUCCESS！");
                            $("#dg").datagrid("reload");
                        }else{
                            $.messager.alert("系统提示","failure！");
                        }
                    },"json");
                }
            });
        }

        function openLinkAddDialog(){
            $("#dlg").dialog("open").dialog("setTitle","添加项目招募信息");
            url="${pageContext.request.contextPath}/hospital/adds";
        }

        function opensearchLink(){
            $("#dlgs").dialog("open").dialog("setTitle","招募搜索");
            url="${pageContext.request.contextPath}/searchhospital?recruitTitle=";
        }

        function openLinkModifyDialog(){
            var selectedRows=$("#dg").datagrid("getSelections");
            if(selectedRows.length!=1){
                $.messager.alert("系统提示","请选择一条要编辑的数据！");
                return;
            }
            var row=selectedRows[0];
            url="${pageContext.request.contextPath}/adds?id="+row.id;
        }

        function saveLink(){
            $("#fm").form("submit",{
                url:url,
                onSubmit:function(){
                    return $(this).form("validate");
                },
                success:function(result){
                    var result=eval('('+result+')');
                    if(result.success){
                        $.messager.alert("系统提示","保存成功！");
                        resetValue();
                        $("#dlg").dialog("close");
                        $("#dg").datagrid("reload");
                    }else{
                        $.messager.alert("系统提示","保存失败！");
                        return;
                    }
                }
            });
        }


        function saveLinks(recruitTitle){
            $("#fms").form("submit",{
                url:url+recruitTitle,
                onSubmit:function(){
                    return $(this).form("validate");
                },
                success:function(result){
                    console.log(result);
                    var r = JSON.parse(result);
                    console.log(typeof r);
                    alert(result);
                    if(r.success){
                        $.messager.alert("系统提示","查找成功！");

                        resetValue();
                        $("#dlgs").dialog("close");
                        $("#dg").datagrid("reload");
                        var str = JSON.stringify( r.list );
                        window.location.href="${pageContext.request.contextPath}/pagejump?recruitTitle="+recruitTitle;

                    }else{
                        $.messager.alert("系统提示","查找失败！");
                        return;
                    }
                }
            });
        }

        function resetValue(){
            $("#hospitalName").val("");
            $("#linkUrl").val("");
            $("#remarks").val("");
        }

        function closeLinkDialog(){
            $("#dlg").dialog("close");
            resetValue();
        }

        function closeLinkDialogs(){
            $("#dlgs").dialog("close");
            resetValue();
        }
    </script>
</head>
<body style="margin: 1px">


<table id="dg" title="医院管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${pageContext.request.contextPath}/findalllist" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="32" align="center">编号</th>
        <th field="recruitTitle" width="300" align="center">招募标题</th>
        <th field="state" class="ste" width="32" align="center">发布的状态</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:opensearchLink()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
        <a href="${pageContext.request.contextPath}/view/manager/add.jsp" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:openLinkModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">更新</a>
        <a href="javascript:deleteLink()" class="easyui-linkbutton" iconCls="icon-hosp" plain="true">发布</a>
        <a href="javascript:deleteLink()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>

    </div>
</div>


<div id="dlg" class="easyui-dialog" style="width:500px;height:200px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons">

    <form id="fm" method="post">
        <table cellspacing="8px">
            <tr>
                <td>医院名称：</td>
                <td>
                    <input type="text" id="hospitalName" name="hospitalName" class="easyui-validatebox" required="true" style="width: 250px"/>
                </td>
            </tr>
            <tr>
                <td>所属区域：</td>
                <td>
                    <input type="text" id="hospitalRegion" name="hospitalRegion" class="easyui-validatebox" required="true" style="width: 250px"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="dlgs" class="easyui-dialog" style="width:500px;height:200px;padding: 10px 20px"
     closed="true" buttons="#dlg-bu">
    <form id="fms" method="post">
        <table cellspacing="8px">
            <tr>
                <td>医院名字：</td>
                <td>
                    <input type="text" id="recruitTitle" name="recruitTitle" class="easyui-validatebox"  required="true" style="width: 250px"/>
                </td>
            </tr>
        </table>
    </form>
</div>


<div id="dlg-bu">
    <a href="javascript:saveLinks( $('#recruitTitle' ).val() )" class="easyui-linkbutton" iconCls="icon-ok">搜索</a>
    <a href="javascript:closeLinkDialogs(  )" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>
<div id="dlg-buttons">
    <a href="javascript:saveLink()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeLinkDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>


</body>
</html>