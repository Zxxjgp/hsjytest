<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>患者招募列表</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="format-detection" content="telephone=no,email=no">
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="HandheldFriendly" content="true">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <link rel="stylesheet" href="http://cdn.bootcss.com/normalize/4.2.0/normalize.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/weui/1.1.1/style/weui.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/jquery-weui/1.0.1/css/jquery-weui.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/llt_v24.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/zm_20171020.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/styles_v4.3.css?v=1">
    <style>
        .c-444 {
            color: #444444;
        }
    </style>
    <script>
        var _hmt = _hmt || [];
        _hmt.push(['_setCustomVar', 2, 'visitor', '患者招募列表页', 3]);
        (function() {
            var hm = document.createElement("script");
            hm.src = "https://hm.baidu.com/hm.js?ae21f81532a53417066442d9786c456d";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>
</head>
<body style="background-color: #f4f4f4;" class="">
<header class="txt_c">
    <div class="fzzm-banner m_center bg-white" id="bannerBox">
        <div class="swiper-container" style="">
            <!-- Additional required wrapper -->
            <div class="swiper-wrapper">
                <input type="hidden" value="缓存Key-'recruitProjectList_20180417_'">

                <div class="swiper-slide">

                    <a href="http://llt.hsgene.cn/f/wx/recruitProject/9eb28d9017784e5d99ce07111cbf2544" class="block">

                        <img src="${pageContext.request.contextPath}/static/image/1.png" style="height: 10em; width: 100%; vertical-align: middle; display: block;"/></a>
                </div>

                <div class="swiper-slide">

                    <a href="http://llt.hsgene.cn/f/wx/recruitProject/4b00bb751c4e4c8690d9fd0312d6c1cb" class="block">

                        <img src="${pageContext.request.contextPath}/static/image/2.png" style="height: 10em; width: 100%; vertical-align: middle; display: block;"/></a>
                </div>


            </div>
            <!-- If we need pagination -->
            <div class="swiper-pagination"></div>
        </div>
    </div>
    <div class="ub zmxm-nav-box add-border-top" id="myFixedBox">
        <div class="ub-f1">
            <div class="ub-con cot_srolling">
                <div class="zmxm-nav-items-box">
                    <span class="ft_default pd_l10">疾病分类</span>
                    <span style="float: right; text-align: right;"><span class="ft_default">全部</span></span>
                </div>
            </div>
        </div>
        <div class="zmxm-nav-btn-box">
            <a href="javascript:;" class="zmxm-nav-btn" id="navBtn">
                <span class="iconfont icon-arw-select"></span>
            </a>
        </div>
    </div>
</header>
<article style="background-color: #f0f0f0;  " class="">
    <div style="padding: 1.2185em 1em;">
        <c:forEach var="projectlist" items="${projectResruitslist}" >
        <a href="${pageContext.request.contextPath}/resruitdetail?id=${projectlist.id}" class="fzzm-info-box fzzm-info-white"
           style="margin-bottom: 1.2185em;">
            <div class="info-txt-box ub ub-ac">
                <div class="ub-f1">
                    <p class="info-txt"><span class="ft_xl">${projectlist.recruitTitle}</span></p>
                    <p class="info-time">截止时间:${projectlist.recruitTime}</p>
                </div>
            </div>
        </a>
        </c:forEach>
    </div>
</article>
<div class="zmxm-nav-dialog" id="navDialog">
    <div class="zmxm-list-box cot_srolling">
        <ul class="zmxm-list" id="xmList">
            <c:forEach items="${diseaseTypeList}" var="diseaselist">
            <li><a href="${pageContext.request.contextPath}/querylist?diseaseTypeId=${diseaselist.id}"class="ellipsis">
                <sapn class="zmxm-icon"><img src="${pageContext.request.contextPath}/individual/cms/images/all.png" alt=""></sapn>
                ${diseaselist.category}</a></li>
            </c:forEach>
        </ul>
    </div>
</div>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="http://cdn.staticfile.org/fastclick/1.0.6/fastclick.min.js"></script>
<script>
    $(function () {
        FastClick.attach(document.body);
    });
</script>
<script src="//cdn.bootcss.com/jquery-weui/1.0.1/js/jquery-weui.min.js"></script>
<script src="//cdn.bootcss.com/jquery-weui/1.0.1/js/swiper.min.js"></script>
<script src="http://cdn.bootcss.com/ScrollToFixed/1.0.8/jquery-scrolltofixed-min.js"></script>
<script type="text/javascript">
    $(".swiper-container").swiper({
        loop: true,
        autoplay: 3000
    });

    var head_h = $('header').height();
    $('#navDialog').css({
        top: head_h + 'px'
    })

    var nav_h = $('.zmxm-nav-box').outerHeight();
    var max_move = head_h - nav_h;
    $('#navBtn').on('click', function (e) {
        if ($('#navDialog').hasClass('active')) {
            $('#navDialog').removeClass('active');
        } else {
            var t = $(window).scrollTop();
            if( t <= max_move){
                t = head_h - t;
            }else{
                t = nav_h;
            }
            $('#navDialog').css('top',t + 'px');
            $('#navDialog').addClass('active');
        }
        return false;
    });

    $('#navDialog').on('click', function (e) {
        if (e.target == this) {
            $('#navDialog').removeClass('active');
        }
    });

    $('#myFixedBox').scrollToFixed();


    $(window).on('scroll',function(e){
        if ($('#navDialog').hasClass('active')) {
            $('#navDialog').removeClass('active');
        }
    });
</script>
</body>
</html>