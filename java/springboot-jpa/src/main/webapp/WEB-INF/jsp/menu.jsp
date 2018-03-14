<!doctype html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+ "://"+request.getServerName()+ ":"+request.getServerPort()+ path + "/";
    String serverPort=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>客户360视图属性</title>
    <style type="text/css">
        /*body{ text-align:center}*/
        .wrap-menu {width:778px; position:fixed;top:-8px;height:604px;width:268px;margin-top: 10px; background:#FFF; font:15px/1.5 Tahoma,Arial,sans-serif}
        .wrap-menu ul{ list-style:none; margin:0; padding:0;}
        .wrap-menu ul li{ text-indent:3em; white-space:nowrap; }
        .wrap-menu ul li h2{ cursor:pointer; height:40px; width:100%; margin:0 0 1px 0; font:16px/31px '微软雅黑';}
        .wrap-menu ul li a{ display:block; outline:none; height:40px; line-height:40px; margin:1px 0; color:#000000; text-decoration:none;}
        .wrap-menu ul li img{ margin-right:10px; margin-left:-17px;width:7px; height:7px; background:url(images/33.gif) no-repeat; border:none;}
        .wrap-menu ul li img.unfold{ background-position:0 -9px;}
        .wrap-menu ul li a:hover{ background-color:#ccc; background-image:none;border-left: 2px solid #055EB6;}
        h1 { width:100%; text-align:center;display:block; line-height:1.5em; overflow:visible; font-size:22px; text-shadow:#f3f3f3 1px 1px 0px, #b2b2b2 1px 2px 0}
    </style>
    <link href="${pageContext.request.contextPath}/css/tabstyle.css" rel="stylesheet" type="text/css" />

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/theme/admin-designs/assets/skin/default_skin/css/theme.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/theme/admin-designs/assets/admin-tools/admin-forms/css/admin-forms.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/theme/admin-designs/assets/img/favicon.ico">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/theme/admin-designs/assets/fonts/iconsweets/iconsweets.css">

    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/zzsc.js"></script>
    <script src="${pageContext.request.contextPath}/js/menu.js"></script>
    </meta>
</head>
<body style="
    background-color: #f0f5fb;;margin: 0 0 0 0 !important;">
<div id="menu" class="wrap-menu"></div>
</body>
</html>
