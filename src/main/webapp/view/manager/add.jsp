<%--suppress ALL --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>写博客页面</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/jquery-easyui-1.3.3/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/jquery-easyui-1.3.3/themes/icon.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery-easyui-1.3.3/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/ueditor/ueditor.all.min.js"> </script>
	<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
	<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript">

        function submitData(){
            var selectedRows=$("#dg").datagrid("getSelections");
            if(selectedRows.length==0){
                $.messager.alert("系统提示","请选择研究医院！");
                return;
            }
            var strIds=[];
            for(var i=0;i<selectedRows.length;i++){
                strIds.push(selectedRows[i].id);
            }
            var ids=strIds.join(",");


            var recruitTitle=$("#recruitTitle").val();
            var recruitSelectStandard = UE.getEditor('editor').getContent();
            var recruitIntroduce = UE.getEditor('editor1').getContent();
            var researcher=$("#researcher").val();
            var bidParty=$("#bidParty").val();
            var recruitPatientBenefit=$("#recruitPatientBenefit").val();
            var enrollmode=$("#enrollmode").val();
            var diseaseTypeId=$("#diseaseTypeId").combobox("getValue");

            if(recruitTitle==null || recruitTitle==''){
                alert("请输入标题！");
            }else if(recruitSelectStandard==null || recruitSelectStandard==''){
                alert("请输入招募入选的标准！");
            }else if(recruitIntroduce==null || recruitIntroduce==''){
                alert("请输入项目介绍！");
            }else if(researcher==null || researcher==''){
				alert("请输入研究方");
			}else if(bidParty==null || bidParty==''){
                alert("请输入要申请方");
			}else if(recruitPatientBenefit==null || recruitPatientBenefit==''){
                alert("请输入患者获益的介绍");
			}else if(enrollmode==null || enrollmode==''){
                alert("请输入报名方式");
			}else{
                $.post("${pageContext.request.contextPath}/esruitadd",{'recruitTitle':recruitTitle, 'recruitSelectStandard':recruitSelectStandard, 'recruitIntroduce':recruitIntroduce, 'researcher':researcher, 'bidParty':bidParty, 'recruitPatientBenefit':recruitPatientBenefit, 'enrollmode':enrollmode, 'selectlist':ids, 'diseaseTypeId':diseaseTypeId },function(result){
                    if(result.success){
                        alert("博客发布成功！");
                        resetValue();
                    }else{
                        alert("博客发布失败！");
                    }
                },"json");
            }
        }

        // 重置数据
        function resetValue(){
            $("#title").val("");
            $("#blogTypeId").combobox("setValue","");
            UE.getEditor('editor').setContent("");
            $("#keyWord").val("");
        }

	</script>
</head>
<body style="margin: 10px">
<div id="p" class="easyui-panel" title="添加招募" style="padding: 10px">
	<table cellspacing="20px">
		<tr>
			<td width="80px">招募标题：</td>
			<td><input type="text" id="recruitTitle" name="recruitTitle" style="width: 400px;"/></td>
		</tr>

		<tr>
			<td valign="top">项目简介：</td>
			<td>
				<script id="editor1" type="text/plain"  style="width:100%;height:500px;"></script></td>
		</tr>
		<tr>
			<td>所属类别：</td>
			<td>
				<select class="easyui-combobox" style="width: 154px" id="diseaseTypeId" name="diseaseTypeId" editable="false" panelHeight="auto" >
					<option value="">请选择博客类别...</option>
					<c:forEach var="blogType" items="${hospitalList }">
						<option value="${blogType.id }">${blogType.category}</option>
					</c:forEach>
				</select>
			</td>
		</tr
		<tr>
			<td>研究者：</td>
			<td><input type="text" id="researcher" name="researcher" style="width: 400px;"/>
			</td>
		</tr>

		<tr>
			<td>举办方：</td>
			<td><input type="text" id="bidParty" name="bidParty" style="width: 400px;"/>
			</td>
		</tr>
		<tr>
			<td valign="top">入选标准：</td>
			<td>
				<script id="n" type="text/plain" style="width:100%;height:500px;"></script></td>
        </tr>
		<tr>
                <td>患者获益：</td>
                <td><input type="text" id="recruitPatientBenefit" name="recruitPatientBenefit" style="width: 600px; height:200px "/>&nbsp;(多个关键字中间用空格隔开)</td>
        </tr>
		<tr>
			<td valign="top">研究医院：</td>
			<td style="width:1250px;height:500px;">
				<table id="dg" title="医院列表" class="easyui-datagrid"
					   fitColumns="true" pagination="true" rownumbers="true"
					   url="${pageContext.request.contextPath}/hospital/findalllist" fit="true" toolbar="#tb">
					<thead>
					<tr>
						<th field="cb" checkbox="true" align="center"></th>
						<th field="id" width="20" align="center">编号</th>
						<th field="hospitalRegion" width="200" align="center">医院名称</th>
					</tr>
					</thead>
				</table>
			</td>
		</tr>
		<tr>
			<td valign="top">报名方式：</td>
			<td><input type="text" id="enrollmode" name="enrollmode" style="width: 400px;"/>
		</tr>
        <tr>
			 <td></td>
              <td> <a href="javascript:submitData()" class="easyui-linkbutton" data-options="iconCls:'icon-submit'">发布招募</a> </td> </tr>
	</table>
   </div>

        <script type="text/javascript">

                //实例化编辑器
                //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
                var ue = UE.getEditor('editor');
				var ue1 = UE.getEditor('editor1');
		</script>
</body>
</html>