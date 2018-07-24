function initFileInput(ctrlName, uploadUrl,fileTypes) {    
    var control = $('#' + ctrlName); 
    control.fileinput({
        language: 'zh', //设置语言
        uploadUrl: uploadUrl, //上传的地址
        allowedFileExtensions : fileTypes,//['jpg', 'png','gif','icon'],//接收的文件后缀
        showUpload: false, //是否显示上传按钮
        showCaption: false,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式             
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 
    });
}
$(document).delegate(".icon-arrow-right,.icon-arrow-left","mousedown",function(){
	$(this).css({"color":"#aaa","margin-top":"1px"});
});
$(document).delegate(".icon-arrow-right,.icon-arrow-left","mouseup",function(){
	$(this).css({"color":"#333","margin-top":"0px"});
});
/***********************************************************************************/
/**
 * 初始化下拉框工具
 * <p> 调用示例 
 * <p>    组件依赖 
 * <p>      bootstrap.min.css
 * <p>      bootstrap-select.min.css 
 * <p>      jquery.1.11.1.min.js (version > 1.10.0)
 * <p>      bootstrap.min.js   (version > 3.0.0)
 * <p>      bootstrap-select.min.js
 * <p>      bootstrap-select-zh-CN.min.js
 * <p> 页面引入以下select表单
 * <p> select class="form-control form-search-input selectpicker" id="sysType" 
 * <p> 	 data-url="/dictElementController/getElementByCode?code=XTFL"
 * <p> 	 data-live-search="true" data-options="editable:false" >
 * <p> </select>
 * <p> 其中 data-url为请求参数必须制定 
 * <p> action路径：/dictElementController/getElementByCode
 * <p>     code 为字典分类编码，默认为拼音首字母大写
 */

/**
 * 字典类型下拉框数据初始化工具
 */
var SelectpickerUtil = {
	defaults:{
		url: '/dictElementController/getElementByCode',
		defaultOptions: '<option value="">请选择<\option>'
	},
	/**
	 * 字典类型下拉框数据初始化
	 */
	initAll: function(){
		$(".selectpicker").each(function(i,e){
			SelectpickerUtil.ajaxDictELements($(this));
		});
	},
	/**
	 * [{
	 *   node: $selectNode ,
	 *   code: '',//字典分类
	 *   options : ''
	 * }]
	 * @param dicts
	 * @returns {Boolean}
	 */
	init:function(dicts){
		if(dicts instanceof Array){
			if(dicts==null||dicts.length==0)
				return false;
			for(var i=0; i<dicts.length; i++){
				SelectpickerUtil.ajaxDictELements(dicts[i].node,dicts[i].code,dicts[i].options);
			}
		}else{
			SelectpickerUtil.ajaxDictELements(dicts.node,dicts.code,dicts.options);
		}
	}, 
	ajaxDictELements:function($selectNode,code,defaultOptions,callFunctions){
		if($selectNode.attr("data-url")==null&&(code==null||""==code))
			return false;
		$.ajax({
			type: 'GET',
			url: path + ($selectNode.attr("data-url")==null?(SelectpickerUtil.defaults.url+"?code="+code):$selectNode.attr("data-url"))+"&random="+new Date().getMilliseconds(),
			dateType: 'json',
			success: function(dicts) {
				var options = defaultOptions==null?SelectpickerUtil.defaults.defaultOptions:defaultOptions;
				$.each(dicts,function(i,e){
					options += "<option value='"+e.id+"'>"+e.name+"</option>";
				});
				$selectNode.empty();
				$selectNode.html(options);
				$selectNode.selectpicker('refresh');
				if(callFunctions!=null){
					callFunctions();
				}
			}
		});
	}
};
/**
 * 设置弹出框的最大高度
 */
//未初始化ModleBodyHeight时为false,执行设置函数否则不执行
var isSetModalBodyHeight = false;
function setModalBodyHeight(){
	if(!isSetModalBodyHeight){
		$('#editModal').on('shown.bs.modal', function () {
			// 设置.modal-body的高度
			var maxHeight = parseInt($("#page",window.parent.document).outerHeight()) - 53 - 64 - 50;
			$('#editModal').find(".modal-body").css({"height": maxHeight+"px"});
			$('#editModal').find(".ztree").css({"height":"100%"});
			$('#editModal').find(".ztree").css({"overflow":"auto"});
		});
		isSetModalBodyHeight = true;
	}
}
/**
 * 修正layer确认框，确认无法关闭
 */
function colseLayer(){
	$(".layui-layer-dialog").remove();
	$(".layui-layer-shade").remove();
}
/**
 * 增加列超长提示
 */
function showTitileFormatter(value, row, index){
	return '<span title="'+value+'">'+value+'</span>';
}