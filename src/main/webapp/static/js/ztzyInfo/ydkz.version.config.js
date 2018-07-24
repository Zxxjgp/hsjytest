var $table;
/**页面初始化函数*/
$(function(){
	//初始化表格,动态从服务器加载数据  
	$table=$("#ydkzVersionList").bootstrapTable({
		method : "GET", //使用get请求到服务器获取数据  
		url : path + "/pipYdkzVersion/getPageList", //获取数据的地址  
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
        queryParams : function queryParams(params) {  //设置查询参数  
          var param = {
        		page: params.pageNumber,    
	            pageSize: params.pageSize,  
	            ydkzFbr:encodeURI($("#ydkzFbr").val())
          };    
          return param;                   
        },
		responseHandler :function(data) { //格式化数据
			var tmp="";
        	if(data.total!=undefined)
        	    tmp = { total:data.total, rows:data.rows };
        	if(data.total==undefined)
        	    tmp = { total:data.length, rows:data };
			return tmp;
		},	        
		columns : [
		   {field : 'id',title : '序号',width:'40px',formatter:indexFormatter},
		   {field : 'ydkzLx',title : '类型',formatter:showYdkzLxFormatter},
		   {field : 'ydkzFbr',title : '发布人',formatter:showAllName},
		   {field : 'ydkzFbsj',title : '发布时间',formatter:showDateTime},
		   {field : 'ydkzBb',title :'版本',formatter:showAllName},
		   {field : 'ydkzDx',title : '大小(KB)',formatter:showAllName},
		   {field : 'ydkzJrx',title : '兼容性',formatter:showAllName},
		   {field : 'ydkzApkUrl',title : 'Apk下载地址',formatter:showAllName},
		   {field : 'ydkzMs',title : '描述',formatter:showAllName},
		   {field : 'ydkzzt',title : '启动状态',formatter:showYdkzztFormatter},
		   {field : 'operate',title : '操作',align:'center',width:'180px',formatter:operateFormatter}
		]
	});
	showTitle();
}); 

/*给表格添加title*/
function showTitle(){
	$(".th-inner").each(function(index,ele){
		var titleContent = $(ele).text();
		$(ele).attr("title",titleContent);
	});
}

/**
 * 显示序号
 */
function indexFormatter(value, row, index){
	return index + 1;
}
/**超出部分显示全称**/
function showAllName(value, row, index){
	return '<span title="'+value+'">'+value+'</span>';
	
}

/*function showDateTime(value, row, index){
	return '<span title="'+value+'">'+value+'</span>';
}*/

function showDateTime(value, row, index){
	var Timestamp = new Date(value) ;
	var normalTime=Timestamp.getFullYear() + "-" + (Timestamp.getMonth() + 1) + "-" + Timestamp.getDate(); 
	return '<span title="'+normalTime+'">'+normalTime+'</span>';
}

/**
 * 类型
 */
function showYdkzLxFormatter(value, row, index){
	if(value == '1')
		return 'Android';
	else if(value == '0')
		return 'IOS';
	else
		return '';
}

/**
 * 启动状态
 */
function showYdkzztFormatter(value, row, index){
	if(value == '1')
		return '启用';
	else if(value == '0')
		return '停用';
	else
		return '';
}

/**
 * 数据状态
 */
function isEnableFormatter(value, row, index){
	if(value == '1')
		return '有效';
	else if(value == '0')
		return '无效';
	else
		return '';
}

/**
 * 添加操作按钮
 */
function operateFormatter(value, row, index){
	var html ='<button title="查询详情" type="button" class="btn btn-primary" onclick="view(\''+row.id+'\')">查询</button>' 
	+'<button title="修改" type="button" class="btn btn-info" onclick="update(\''+row.id+'\')">修改</button>'
	+'<button title="历史" type="button" class="btn btn-danger" onclick="goHistory(\''+row.id+'\')">历史</button>';
	return html;
}

/**
 * 获取所有的信息类型列表
 */
$(function (){
	$.ajax({
		url: path+'/pipYdkzVersion/findAll',
		success:function(data){
				for(var i=0;i<data.length;i++){
					var option=$("<option></option>");
					option.val(data[i]);
					option.text(data[i]);
				}
		}
	});
});

/**
 * 查询最新动态详情
 */
function view(id){
	$("#editModal").on("hidden.bs.modal", function() {  
	    $(this).removeData("bs.modal");  
	});  
	$("#editModal").modal({  
	    remote: path + "/pipYdkzVersion/gotoView?id=" + id
	}); 
	//设置弹出框的最大高度
	setModalBodyHeight();
}

/**
 * 增加最新动态
 */
function add(option){
	$("#editModal").on("hidden.bs.modal", function() {  
	    $(this).removeData("bs.modal");  
	});
	$("#editModal").modal({  
	    remote: path + "/pipYdkzVersion/gotoAdd?action="+ option
	});
	//设置弹出框的最大高度
	setModalBodyHeight();
}

/**
 * 修改最新动态
 */
function update(id){
	$("#editModal").on("hidden.bs.modal", function() {  
	    $(this).removeData("bs.modal");  
	});  
	$("#editModal").modal({  
	    remote: path + "/pipYdkzVersion/gotoUpdate?id="+ id
	});
	//设置弹出框的最大高度
	setModalBodyHeight();
}

/**
 * 删除当前行的最新动态
 */
function deleteCurrentRow(id){
	layer.confirm('删除后无法恢复您确定要删除?', function(index){
		$.ajax({
			type : 'get',
			url : path + "/pipYdkzVersion/delete?id=" + id,
			success : function(data) {
				if(data=="success"){
					$table.bootstrapTable('refresh');
					layer.closeAll();
				 }else{
					 layer.msg("删除失败");
				 }
			}
		});
	}); 
}


/**
 * 历史版本
 */
function goHistory(id){
	$("#editModal").on("hidden.bs.modal", function() {  
	    $(this).removeData("bs.modal");  
	});  
	$("#editModal").modal({  
	    remote: path + "/pipYdkzVersion/gotoHistory?id="+ id
	});
	//设置弹出框的最大高度
	setModalBodyHeight();
}

/**
 * 查询
 */
function search(){
	$table.bootstrapTable('refresh');
}

/**
 * 重置
 */
function reset(){
	 $("#queryCont").find("input").each(function() {
		  var type = $(this).attr("type");
		  switch (type) {
			case "text":
				$(this).val("");
			default:
				$(this).val("全部");
			}
	});
}
