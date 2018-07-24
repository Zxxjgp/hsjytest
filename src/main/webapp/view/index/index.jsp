<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="./taglibs.jsp"%>
<html lang="zh-cn" style="height: 100%;">
<head>
	<meta charset="utf-8">
	<!-- 告诉IE使用最新的引擎渲染网页 -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>江苏华生基因</title>
	<link rel="stylesheet" href="${ctx}/static/css/frame.css" />
	<script type="text/javascript" src="/static/js/rem.js"></script>
	<script type="text/javascript" src="/static/js/jquery-1.9.1.js" ></script>
	
	<style>
		html body{
			width:100%;
			height: 100%;
			overflow-x:hidden ; /*隐藏水平滚动条*/ 
               overflow-y:hidden ; /*隐藏水平滚动条*/ 
		}
	</style>
	<script type="text/javascript">
		rem(window, {
			designWidth: 1920,
			designHeight: 1080,
			designFontSize: 20,
			callback: function(argument) {
				console.timeEnd("test");
			}
		});
		
		// 分配高度
		function allotHeight() {
			// 获取屏幕可视区的高度
			var dH = $(window).height();
			dH = parseInt(dH);
			// header
			var h1 = Math.ceil(dH * (100 / 1080));
			// main
			var h2 = Math.ceil(dH * (1080/ 1080));
			// footer
			var h3 = Math.ceil(dH * (50/ 1080));

			$("#header").css({
			//"overflow": "hidden",
				"height": h1 + 'px',
				"line-height": h1 + 'px'
			});
			$("#ifrm").css({
				//"overflow": "hidden",
				"height": h2 + 'px',
				"line-height": h2 + 'px'
			});
			$("#footer").css({
				"overflow": "hidden",
				"height": h3 + 'px',
				"line-height": h3 + 'px'
			});
		}
	</script>
	<script type="text/javascript">
	    $(document).ready(function() {
	       	var socketPath='${socketPath}';
        	// 指定websocket路径
         	if ('WebSocket' in window) {  
			    websocket= new WebSocket("ws://"+socketPath+"/ws?uid=test1");  
			}else {  
			    websocket = new SockJS("ws://"+socketPath+"/ws/sockjs?uid=test1");
			}  
        	websocket.onmessage = function(event) {
	        	if(typeof(event.data)=="string"){  
			         var obj = eval('(' + event.data + ')');
			         var tempPath=obj.path;
			         //var code=obj.code;//获取电视的识别码
			         if(tempPath!=null){
				         if(tempPath=="load"){
				             $("#ifrm").attr("src","/static/front/load.jsp");
				         }else if(tempPath=="success"){
				             $("#ifrm").attr("src","/views/front/load.jsp");
				         }else if(tempPath=="login"){
				             $("#ifrm").attr("src","/views/front/screen_login.jsp");
				         }else if(tempPath=="user_failed"){
				             $("#ifrm").attr("src","/views/front/abnormalUser.jsp");/*/bonc_ioc_PIP*/
				         }else{
					         var fullPath=tempPath;
					         $("#ifrm").attr("src",fullPath);
				         }
			         }
			    }
	        };
	    });
	    
	</script>
</head>

<body style="background:#050a0d;">

	<input type="hidden" id="code" name="code" value=""/>
	<iframe id="ifrm" name="ifrm" src="/static/front/screen_login.jsp" width="100%"  height="100%"  scrolling="no" frameborder="0">
	<!-- 带我二维码的主显示区域 -->
	</iframe>
	
<body>
</html>