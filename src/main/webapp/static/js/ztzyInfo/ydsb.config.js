var $table;
/**页面初始化函数*/
$(function(){
	//初始化表格,动态从服务器加载数据  
	$table=$("#ydsbList").bootstrapTable({
		method : "GET", //使用get请求到服务器获取数据  
		url : path + "/pipYdsbInfo/getPageList", //获取数据的地址  
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
	            sbMc:encodeURI($("#sbMc").val()),
	            sbMac:encodeURI($("#sbMac").val())
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
		   {field : 'sbId',title : '设备编号',formatter:showAllName},
		   {field : 'sbMc',title : '设备名称',formatter:showAllName},
		   {field : 'sbXh',title : '设备型号',formatter:showAllName},
		   {field : 'sbCzxt',title :'操作系统',formatter:showAllName},
		   {field : 'sbXtbb',title : '系统版本',formatter:showAllName},
		   {field : 'sbMac',title : '设备mac地址',formatter:showAllName},
		   {field : 'sbSyrMc',title : '使用人/单位名称',formatter:showAllName},
		   {field : 'sbSyrZh',title : '使用人/单位平台账号',formatter:showAllName},
		   {field : 'sbSyrLxfs',title : '使用人/单位联系方式',formatter:showAllName},
		   {field : 'sbSyrQx',title : '使用人/单位权限',formatter:showAllName},
		   {field : 'isValid',title : '数据状态',formatter:isEnableFormatter},
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
	+'<button title="删除" type="button" class="btn btn-danger" onclick="deleteCurrentRow(\''+row.id+'\')">删除</button>';
	return html;
}

/**
 * 获取所有的信息类型列表
 */
$(function (){
	$.ajax({
		url: path+'/pipYdsbInfo/findAll',
		success:function(data){
				for(var i=0;i<data.length;i++){
					var option=$("<option></option>");
					option.val(data[i]);
					option.text(data[i]);
					//$("#typeIdl").append(option);
				}
		}
	})
})

/**
 * 查询最新动态详情
 */
function view(id){
	$("#editModal").on("hidden.bs.modal", function() {  
	    $(this).removeData("bs.modal");  
	});  
	$("#editModal").modal({  
	    remote: path + "/pipYdsbInfo/gotoView?id=" + id
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
	    remote: path + "/pipYdsbInfo/gotoAdd?action="+ option
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
	    remote: path + "/pipYdsbInfo/gotoUpdate?id="+ id
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
			url : path + "/pipYdsbInfo/delete?id=" + id,
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
