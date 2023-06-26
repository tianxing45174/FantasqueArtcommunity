<%--
  Created by IntelliJ IDEA.
  User: tianx
  Date: 2022/12/5
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <title>个人主页</title>
    <script src="/static/js/jquery-3.6.1.js"></script>
    <script src="/static/js/user.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <script src="/static/js/utils.js"></script>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/user.css">
    <link rel="stylesheet" href="/static/css/main.css">
    <script>
        function exitalert(){
            var a = confirm("确认注销账号");
            return a;
        }
    </script>
</head>
<body style="background-color: #f4f2f4;">
<div>
    <%@ include file="/jsp/components/top.jsp"%>
</div>

<div class="form-user clear fff">
    <div class="hp-user" style="background-image: url(${user.profilePhoto});"></div>
    <div>
        <h1>${user.nickname}</h1>
    </div>
    <div class="elem-user">
        <label>
            <p class="elem-title">自我介绍</p>
            <textarea name="user-cm" class="user-cm user-text" disabled>${user.userComment}</textarea>
        </label>
    </div>
    <div class="elem-user">
            <p class="elem-title">性别</p>
            <h4>${user.sex}</h4>
    </div>
    <div class="elem-user">
        <label>
            <p class="elem-title">邮箱</p>
            <input type="text" name="e-mail" class="e-mail user-text" value="${user.email}" disabled>
        </label>
    </div>
    <div class="elem-user">
        <label>
            <p class="elem-title">地址</p>
            <select name="address" class="user-text" disabled>
                <option value="${user.address}" selected>${user.address}</option>
            </select>
        </label>
    </div>
    <div class="elem-user">
        <label>
            <p class="elem-title">出生年份</p>
            <input type="text" name="birthday" class="user-text" value="${user.birthday}" disabled>
        </label>
    </div>
    <div class="elem-user center-user">
        <form action="/user/toUploadUser" method="post">
            <input type="hidden" name="id" value="${user.id}">
            <input type="submit" value="修改个人信息" class="btn-user btn-user-submit">
        </form>
        <form action="/user/logout" method="post">
            <input type="hidden" name="username" value="${user.username}">
            <input type="hidden" name="id" value="${user.id}">
            <input type="submit" value="退出登录" class="btn-user btn-user-esc">
        </form>
<%--            <a href="/UserServlet?action=exitlogin" class="btn-user btn-user-esc"></a>--%>
        <form action="/user/deleteUser" method="post">
            <input type="hidden" name="id" value="${user.id}">
            <input type="submit" value="注销账号" class="btn-user btn-user-exit" onclick="return exitalert()">
        </form>
        <form action="/user/toUploadUsernameAndPassword" method="post">
            <input type="hidden" name="id" value="${user.id}">
            <input type="submit" value="修改密码账号" class="btn-user btn-user-submit">
        </form>
    </div>
</div>
<%@include file="/jsp/components/content.jsp"%>
<script>
</script>
</body>
</html>
