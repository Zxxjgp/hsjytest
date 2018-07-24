<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/views/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">

	<head>
		<meta charset="utf-8">
		<!-- 告诉IE使用最新的引擎渲染网页 -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>大屏登录</title>
		<link href="${ctx}/static/css/abnormal.css" rel="stylesheet">
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
		<body style="position:relactives">
		<div id="imgs">
			<p style="font-size:20px;">异常：用户不存在!</p>
			<img src="${ctx}/static/images/demo/alert.png" />
		</div>
		<script src="${ctx}/static/js/jquery-1.9.1.js"></script>
		<script type="text/javascript">
			allotHeight();
			// 分配高度
			function allotHeight() {
				// 获取屏幕可视区的高度
				var dH = $(window).height();
				dH = parseInt(dH);
				// btn
				var h2 = Math.ceil(dH * (1060 / 1080));
			 	//body
				var h3 = Math.ceil(dH * (1060 / 1080));
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
		</body>


</html>