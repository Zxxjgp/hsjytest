<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>写博客页面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/jquery-easyui-1.3.3/themes/icon.css">
<%--    <link rel="stylesheet" href="http://cdn.bootcss.com/weui/1.1.2/style/weui.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/jquery-weui/1.2.0/css/jquery-weui.min.css">--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
<%--
    <script src="http://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/jquery-weui/1.2.0/js/jquery-weui.min.js"></script>
    <script src="http://cdn.bootcss.com/jquery-weui/1.2.0/js/swiper.min.js"></script>
    <script src="http://cdn.bootcss.com/jquery-weui/1.2.0/js/city-picker.min.js"></script>--%>
    <script type="text/javascript">
        function submitData(){
            var projectresruitid=$("#title").val();
            var yearmonth=$("#yearmonth").val();
            var sex=$("#sex").val();
            var patientname=$("#patientname").val();
            var diseasetype=$("#diseasetype").val();
            var patientcity=$("#patientcity").val();
            var detailedaddress=$("#detailedaddress").val();
            var recruitTitle=$("#title").val();
            var hospital=$("#hospital").val();
            var department=$("#department").val();
            var contacts=$("#contacts").val();
            var patientrelationship=$("#patientrelationship").val();
            var phonenumberone=$("#phonenumberone").val();
            var phonenumbertwo=$("#phonenumbertwo").val();
            var remark= $("#remark").val();


            if(title==null || title==''){
                alert("请输入标题！");
            }else if(yearmonth==null || yearmonth==''){
                alert("请选择博客类别！");
            }else{
             $.post("${pageContext.request.contextPath}/resuser/add",{'projectresruitid':projectresruitid,'yearmonth':yearmonth,'sex':sex, 'patientname':patientname, 'diseasetype':diseasetype,'patientcity':patientcity,'detailedaddress':detailedaddress, 'recruitTitle':recruitTitle, 'hospital':hospital, 'department':department, 'contacts':contacts, 'patientrelationship':patientrelationship, 'phonenumberone':phonenumberone, 'phonenumbertwo':phonenumbertwo, 'remark':remark },function(result){
                    if(result.success){
                        alert("发布成功！");
                        resetValue();
                    }else{
                        alert("发布失败！");
                    }
                },"json");

            }
        }

        // 重置数据
        function resetValue(){
/*            $("#title").val("");
           /!* $("#blogTypeId").combobox("setValue","");*!/
            UE.getEditor('editor').setContent("");
            $("#keyWord").val("");*/
        }

    </script>
</head>
<body style="margin: 10px; background: url(/static/image/background.jpg) no-repeat fixed top;">
<script>
   /* $("#datetime-picker").datetimePicker();*/

   $(function () {
       $("#yearmonth").calendar();
       $("#patientcity").cityPicker({
           title: "请选择城市"
       });
       $("#sex").picker({
           title: "请选择您的性别",
           cols: [
               {
                   textAlign: 'center',
                   values: ['未知', '男', '女']
               }
           ]
       });
       $("#patientrelationship").picker({
           title: "与患者关系",
           cols: [
               {
                   textAlign: 'center',
                   values: ['患者本人', '患者家属', '患者亲友','患者医生','其他']
               }
           ]
       });
   });
</script>

<div id="p" class="easyui-panel" title="报名" style="padding: 10px">
    <table cellspacing="20px" style="margin: 0 auto; text-align: center">
        <tr>
            <td width="80px">报名项目：</td>
            <td><input type="text" value="${recruitTitle}" id="title" name="title" style="width: 400px;"  readonly="readonly"/></td>
        </tr>
        <tr>
            <td>患者姓名：</td>
            <td>
                <input type="text" id='patientname' name="patientname" style="width: 400px;"  placeholder="输入患者姓名"/>
            </td>
        </tr>
        <tr>
            <td valign="top">患者出生年月：</td>
            <td><input type="text" id='yearmonth' name="yearmonth" style="width: 400px;" placeholder="请选择患者日期" /></td></td>
        </tr>
        <tr>
                <td>性别：</td>
                <td><input type="text" id='sex' name="sex"  style="width: 400px;" placeholder="请选择患者性别"/></td>
        </tr>
        <tr>
            <td>疾病类型：</td>
            <td><input type="text" id='diseasetype' name="diseasetype" style="width: 400px;" placeholder="请输入疾病类型" /></td>
        </tr>
        <tr>
            <td>所在城市：</td>
            <td><input type="text" id='patientcity' name="patientcity" style="width: 400px;" placeholder="请选择城市"/></td>
        </tr>
        <tr>
            <td>详细地址：</td>
            <td><input type="text" id="detailedaddress" name="detailedaddress" style="width: 400px;" placeholder="请输入详细地址" /></td>
        </tr>
        <tr>
            <td>就诊医院：</td>
            <td><input id="hospital" name="hospital" style="width: 400px;" placeholder="请选择就诊医院" /></td>
        </tr>
        <tr>
            <td>就诊科室：</td>
            <td><input id="department" name="department" style="width: 400px;" placeholder="请输入就诊科室" /></td>
        </tr>
        <tr>
            <td>联系人：</td>
            <td><input id="contacts" name="contacts" style="width: 400px;" placeholder="请输入联系人"/></td>
        </tr>
        <tr>
            <td>与患者关系：</td>
            <td><input id="patientrelationship" name="patientrelationship" style="width: 400px;" placeholder="请确定与患者关系" /></td>
        </tr>
        <tr>
            <td>联系电话1：</td>
            <td><input name="phonenumberone" id="phonenumberone" style="width: 400px;" placeholder="亲和输入回访第一联系" ></td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td><input name="code" id="code" style="width: 400px;"  placeholder="请输入验证码"></td>
        </tr>
        <tr>
            <td>联系电话2：</td>
            <td><input name="phonenumbertwo" id="phonenumbertwo" style="width: 400px;" placeholder="请输入回访联系电话2" ></td></td>
        </tr>
        <tr>
            <td>备注：</td>
            <td><input name="remark" id="remark" style="width: 400px;" placeholder="选填项，请简述患者疾病及用药情况或者备注其他信息    "></td>
        </tr>
        <tr>
            <td>图片的上传：</td>
            <td>
                <form action="resuser/loadup" method="post" enctype="multipart/form-data"
                      class="fram"><input type="file" name="file" id="file" /><input type="submit" value="上传" />
                </form>
            </td>
        </tr>
        <tr><td></td>
                <td>
                <a href="javascript:submitData()" class="easyui-linkbutton" data-options="iconCls:'icon-submit'">确认提交</a>
                    </td>
          </tr>
      </table>
     </div>
</body>

</html>