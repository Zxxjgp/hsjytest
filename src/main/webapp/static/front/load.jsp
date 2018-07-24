<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/views/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">

	<head>
		<meta charset="utf-8">
		<!-- 告诉IE使用最新的引擎渲染网页 -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>IOC全景洞察平台</title>
		<link href="${ctx}/static/css/screen_login.css" rel="stylesheet">
		<link rel="stylesheet" href="${ctx}/static/css/pageloader.css" />
		<script type="text/javascript" src="${ctx}/static/js/rem.js"></script>
		<script type="text/javascript">
			rem(window, {
				designWidth: 1920,
				designHeight: 1080,
				designFontSize: 20,
				callback: function(argument) {
					console.timeEnd("test");
				}
			});
		</script>
	</head>

	<body >
		<div id="imgs" style="top:380%!important; margin-top:0!important;">
			<p style="font-size:20px;">系统已正常开启,等待接收移动控制端指令</p>
		</div>
		<script src="${ctx}/static/js/jquery-1.9.1.js"></script>
		<script type="text/javascript">
		
			allotHeight();
			// 分配高度
			function allotHeight() {
				// 获取屏幕可视区的高度
				var dH = $(window).height();
				dH = parseInt(dH);
				// header
				var h1 = Math.ceil(dH * (110 / 1080));
				// btn
				var h2 = Math.ceil(dH * (1060 / 1080));
				// footer
				var h3 = Math.ceil(dH * (100 / 1080));
				$("#imgs").css({
					"overflow": "hidden",
					"height": h2 + 'px',
				});
			 	$("body").css({
			 	    "position":"relative",
					"overflow": "hidden",
					"height": h3 + 'px',
					"line-height": h3 + 'px'
				}); 
				}
		</script>

		<body>

</html>