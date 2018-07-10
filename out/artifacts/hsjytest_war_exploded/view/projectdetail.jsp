<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>患者招募</title>
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
    <link rel="stylesheet" href="/static/css/common.css">
    <link rel="stylesheet" href="/static/css/llt_v24.css">
    <link rel="stylesheet" href="/static/css/zm_20171020.css">

    <script>
        var _hmt = _hmt || [];
        _hmt.push(['_setCustomVar', 2, 'visitor', '【招募二十六】TCR-T细胞免疫治疗招募多类癌症患者', 3]);
        (function() {
            var hm = document.createElement("script");
            hm.src = "https://hm.baidu.com/hm.js?ae21f81532a53417066442d9786c456d";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>
    <style type="text/css">
        .article-title-second {
            display: inline-block;
            margin-top: 1.5625em;
            margin-bottom: 1.5625em;
            margin-left: auto;
            margin-right: auto;
        }

        .article-title-second.title-label {
            color: white;
            background-color: #53ace4;
            height: 2em;
            line-height: 2em;
            width: 12em;
            -webkit-border-radius: 0.25em;
            border-radius: 0.25em;
        }

        .fzzm-article-box p {
            color: #555;
            font-size: 0.875em;
        }

        .article-txt-box {
            border: 1px dotted #999;
            padding: 0.875em 1.25em;
            text-align: left;
            -webkit-border-radius: 0.25em;
            border-radius: 0.25em;
        }

        .yy-table-box {
            width: 100%;
        }

        .yy-table {
            border-collapse: collapse;
            width: 100%;
            /*table-layout: fixed;*/
        }

        .yy-table th,
        .yy-table td {
            border: 1px solid #c8c8c8;
            padding: 0 0.625em;
            font-size: 0.875em;
            color: #555;
            /*white-space: nowrap;*/
            vertical-align: middle;
            height: 2.5em;
        }

        .yy-table th {
            color: #333;
            text-align: left;
        }

        .yy-table td {
            color: #555;
            text-align: left;
        }

        .QR-card {
            position: relative;
            border: 3px solid #00a0e9;
            margin-left: 0.625rem;
            margin-right: 0.625rem;
            padding: 7px;
            max-width: 23em;
        }


        .QR-card .card-body {
            border: 2px dashed #00a0e9;
            padding: 5px;
        }

        .QR-card .img-box {
            height: 8.5em;
            position: relative;
        }

        .QR-card .img-box:before {
            content: '';
            position: absolute;
            top: 0;
            left: 50%;
            width: 3px;
            background-color: #00a0e9;
            height: 100%;
            -webkit-transform: scaleX(0.5);
            transform: scaleX(0.5);
        }

        .QR-card .img-qr-box {
            width: 4.5em;
            height: 4.5em;
            margin-left: auto;
            margin-right: auto;
        }

        .QR-card .img-qr-box img {
            vertical-align: middle;
            display: block;
            line-height: 1;
        }


        .article-txt-box ol,
        .article-txt-box ul {
            margin-left: 1em;
        }
    </style>
</head>
<body style="background-color: #f4f4f4;">
<article class="fzzm-article-box txt_c" style="padding-top: 1.5625em; padding-bottom: 1em;">
    <h1 class="article-title-first txt_l" style="font-weight: 1.125em; line-height: 1.2rem; color: #333;">${projectResruitslist.recruitTitle}</h1>
    <h2 class="article-title-second title-label">项目介绍</h2>
    <div class="article-txt-box">
        <p class=""><p>&nbsp; &nbsp; &nbsp;</p><p style="text-indent:29px;line-height:150%"><span style="font-size:15px;line-height:150%">TCR-T</span><span style="font-size:15px;line-height:150%">${projectResruitslist.recruitIntroduce}</span></p><p style="text-indent: 29px; line-height: 150%;"><span style="font-size:15px;line-height:150%"><span style="font-size: 15px; line-height: 150%; color: rgb(255, 0, 0);"></span></span></p></p>
    </div>
    <h2 class="article-title-second title-label">研究者与申办方</h2>
    <div class="article-txt-box">
        <p class=""><p>申办方：${projectResruitslist.bidParty}</p><p>研究者：${projectResruitslist.researcher}</p><p><br/></p></p>
    </div>
    <h2 class="article-title-second title-label">入选标准</h2>
    <div class="article-txt-box">
        <p class=""><p>${projectResruitslist.recruitSelectStandard}</p></p>
        <p class=""><p></p></p>
    </div>
    <h2 class="article-title-second title-label">患者获益</h2>
    <div class="article-txt-box">
        <p class=""><p>成功入组的患者可以免费获得：${projectResruitslist.recruitPatientBenefit}</p></p>
    </div>
    <h2 class="article-title-second title-label">研究中心医院列表</h2>
    <div class="yy-table-box cot_srolling">
        <table class="yy-table">
            <tr>
                <th style="width: 40%;">省市县</th>
                <th>医院</th>

            <c:forEach var="hosp" items="${hospital}">
            <tr>
                <td>${hosp.hospitalRegion}</td>
                <td>${hosp.hospitalName}</td>
            </tr>
            </c:forEach>
        </table>
    </div>


    <h2 class="article-title-second title-label">报名方式</h2>
    <div class="article-txt-box">
        <p class="">${projectResruitslist.enrollmode} </p>
    </div>
</article>
<h2 class="article-title-second title-label">立即报名</h2>
<div class="page-btm-btn-box">
    <a href="javascript:;" class="weui-btn fzzm-primary-btn add-border-top" id="bmBtn">立即报名</a>
</div>

<div style="padding-top: 1em; padding-bottom: 1em;">

    <div class="fzzm-zx-box" style="background-color: white;">
        <a href="https://www.v5kf.com/public/chat/chat?sid=10058&entry=5&ref=link&group_id=0&worker_id=159466"
           class="fzzm-zx-btn">
            <span class="fzzm-zx-icon f_l" style="margin-top: 0.5em; margin-right: 0.25em;"></span>
            <span class="ft_default">咨询客服</span>
        </a>
    </div>
</div>
<div class="weui-mask" id="xyMask">
    <div class="fzzm-xy-dialog">
        <div class="fzzm-xy-hd">
            <h1 class="hd-name">知情同意书</h1>
        </div>
        <div class="fzzm-xy-bd">
            <div style="padding-top: 0.5em; padding-bottom: 2em;">
                <p class="ft_default c-555555" style="text-indent: 2em;">
                    提交报名时，为与您确认报名信息及患者治疗情况，我们需要获取您的姓名、联系电话等个人信息，我平台郑重承诺您的信息不用于除入组招募以外的其他任何用途。</p>
            </div>
        </div>
        <div class="fzzm-xy-ft">
            <div class="m_center" style="width: 82%;">
                <a href="${pageContext.request.contextPath}/registration?recruitTitle=${projectResruitslist.recruitTitle}" class="weui-btn weui-btn_primary-v24 ft_lg">我已了解并同意</a>

                <a href="javascript:;" class="weui-btn weui-btn_plain-primary-v24 ft_lg" id="noBtn">不了，谢谢</a>
            </div>
        </div>
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
<!--<script src="//cdn.bootcss.com/jquery-weui/1.0.1/js/city-picker.min.js"></script>-->
<script type="text/javascript">


    var endDate = new Date('Mon Dec 31 00:00:00 CST 2018');
    var crtDate = new Date();
    $('#bmBtn').on('click', function (e) {
        if (crtDate > endDate) {
            $.alert('该活动已下线');
            $('#bmBtn').addClass('disabled');
        } else {

            $('#xyMask').addClass('weui-mask--visible');

            $('#noBtn').on('click', function (e) {
                $('#xyMask').removeClass('weui-mask--visible');
                return false;
            });

            $('.weui-mask').on('touchmove', function (e) {
                return false;
            });
        }
        return false;
    });
</script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.3.0.js"></script>
<script type="text/javascript">
    wx.config({
        debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
        appId: 'wx106cd54fb399a375',
        timestamp: 1523954038,
        nonceStr: 'CTPThzx0C9ALgkmdb5n6adDVjl0a',
        signature: '01651e0c327dcbafa88cd97f4d15eea5390209f0',
        jsApiList: [
            'onMenuShareTimeline',
            'onMenuShareAppMessage',
            'onMenuShareQQ',
            'onMenuShareWeibo',
            'hideMenuItems',
            'checkJsApi',
            'chooseImage',
            'previewImage',
            'uploadImage'
        ] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });
    var link = 'http://llt.hsgene.cn/f/wx/recruitProjectShare/9eb28d9017784e5d99ce07111cbf2544';
    wx.ready(function () {
        wx.onMenuShareTimeline({
            link: link, // 分享链接
            success: function () {
                alert("成功分享");
            },
            cancel: function () {
                alert("取消分享");
            }
        });
        wx.onMenuShareAppMessage({
            link: link, // 分享链接
            success: function () {
                alert("成功分享");
            },
            cancel: function () {
            }
        });
    });
</script>
</body>
</html>