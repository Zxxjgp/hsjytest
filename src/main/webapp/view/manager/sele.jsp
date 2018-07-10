
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/select2.js"></script>

</head>
<body>

<<a href=""></a

<%--<script type="text/javascript">
    $(document).ready(function(){
        $("").select2({
            placeholder          : "请输入",
            minimumInputLength   : 1,
            multiple             : true,
            separator            : "^",                             // 分隔符
            maximumSelectionSize : 5,                               // 限制数量
            initSelection        : function (element, callback) {   // 初始化时设置默认值
                var data = [];
                $(element.val().split("^")).each(function () {
                    data.push({id: this, text: this});
                });
                callback(data);
            },
            createSearchChoice   : function(term, data) {           // 创建搜索结果（使用户可以输入匹配值以外的其它值）
                return { id: term, text: term };
            },
            formatSelection : function (item) { return item.id; },  // 选择结果中的显示
            formatResult    : function (item) { return item.id; },  // 搜索列表中的显示
            ajax : {
                url      : "${pageContext.request.contextPath}/hospital/sec",              // 异步请求地址
                dataType : "json",                  // 数据类型
                data     : function (term) {
                    // 请求参数（GET）
                    return { q: term };
                },
                results      : function (data) { return
                    alert(data);
                    data; },  // 构造返回结果
                escapeMarkup : function (m) {
                    alert(m);
                    return m; }   ,            // 字符转义处理
            },
        });
    });


</script>
        <tr>
            <td>标题</td>
            <td><input id="gt"/></td>
        </tr>--%>


<script type="text/javascript">
    $(".fmr_90").append("<option value=\""+"\">"+"</option>");

</script>

</body>
</html>
