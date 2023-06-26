<%--
  Created by IntelliJ IDEA.
  User: tianx
  Date: 2022/12/3
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<%--<%--%>
<%--    System.out.println(request.getAttribute("username"));--%>
<%--%>--%>
${username}
<head>
    <title>主页</title>
    <link rel="stylesheet" href="/static/css/main.css">
</head>
<body class="bgimg" style="background-image: url(https://gulimall-fantasque.oss-cn-guangzhou.aliyuncs.com/artcommunity/bgImages/indexbgimg.jpg)">
<div>

</div>
<div class="index-form">
    <a href="/jsp/register.jsp" class="btn signup-btn">注册账号</a>
    <a href="/jsp/login.jsp" class="btn login-btn top-distance">登录</a>
</div>
</body>
</html>