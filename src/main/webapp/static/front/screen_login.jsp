<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./taglibs.jsp"%>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
	<!-- 告诉IE使用最新的引擎渲染网页 -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>大屏登录</title>
	<link href="${ctx}/static/css/screen_login.css" rel="stylesheet">
	
	
	
</head>
<body >
  	<div id="header">
		<h1>大数据洞察平台</h1>
	</div>
	
	<div id="imgs">
		<p>请通过移动控制端扫描下方二维码开启系统</p>
		<div style="height:300px;">
			<img src="${ctx}/static/images/demo/erweima.png" />
		</div>
		<div class="enter">
			<span class="enter_list" style="cursor:pointer;">进入专题列表</span>
			<span class="enter_back" style="cursor:pointer;">进入后台</span>
		</div>
	</div>
	
	<div id="footer">
		<h3>技术支持单位：华生基因</h3>
	</div>
	<script src="${ctx}/static/js/jquery-1.9.1.js"></script>
	<script src="${ctx}/static/js/rem.js"></script>
</body>
</html>