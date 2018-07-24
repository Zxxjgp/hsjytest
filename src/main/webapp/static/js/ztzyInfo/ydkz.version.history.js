var $table;
/**页面初始化函数*/
$(function(){
	//初始化表格,动态从服务器加载数据  
	$table=$("#ydkzVersionHistoryList").bootstrapTable({
		method : "GET", //使用get请求到服务器获取数据  
		url : path + "/pipYdkzVersion/findHistoryById?id="+$('#id').val(), //获取数据的地址  
		striped : false, //表格显示条纹  
		pagination : true, //启动分页 
		pageSize : 10, //每页显示的记录数  
		pageNumber : 1, //当前第几页  
		pageList : [ 10, 20, 30, 40, 50 ], //记录数可选列表  
		uniqueId: "id",
		showColumns : false, //显示下拉框勾选要显示的列  
		showToggle : false, //显示 切换试图（table/card）按钮
		clickToSelect : true, //点击可选
		singleSelect : false, //禁止多选
		maintainSelected : true, //在点击分页按钮或搜索按钮时，将记住checkbox的选择项
		sortable : true, //禁止所有列的排序
		sidePagination : "server", //表示服务端请求  后台分页
		toolbar : "#toolbar",//指明自定义的toolbar
		queryParamsType : "undefined",
		responseHandler :function(data) { //格式化数据
			var tmp="";
        	if(data.total!=undefined)
        	    tmp = { total:data.total, rows:data.rows };
        	if(data.total==undefined)
        	    tmp = { total:data.length, rows:data };
			return tmp;
		},	        
		columns : [
           {field : 'ydkzBb',title :'版本',formatter:showAllName},
		   {field : 'ydkzFbsj',title : '发布时间',formatter:showDateTime},
		   {field : 'ydkzMs',title : '描述',formatter:showAllName}
		]
	});
}); 

