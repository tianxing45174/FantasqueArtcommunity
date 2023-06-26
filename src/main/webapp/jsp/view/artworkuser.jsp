<%--
  Created by IntelliJ IDEA.
  User: tianx
  Date: 2022/12/7
  Time: 6:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
  <title>作者主页</title>
  <script src="/static/js/jquery-3.6.1.js"></script>
  <script src="/static/js/user.js"></script>
  <script src="/static/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="/static/css/bootstrap.min.css">
  <link rel="stylesheet" href="/static/css/user.css">
  <link rel="stylesheet" href="/static/css/main.css">
  <%
    request.setAttribute("content","arkworkall");
  %>
</head>

<body style="background-color: #606060;">
<%@ include file="/jsp/components/top.jsp"%>

<div class="form-user clear fff">
  <div class="hp-user" style="background-image: url(${artworkuser.profilePhoto});"></div>
  <div>
    <h1>${artworkuser.nickname}</h1>
  </div>
  <div class="elem-user">
    <label>
      <p class="elem-title">自我介绍</p>
      <textarea name="user-cm" class="user-cm user-text" disabled>${artworkuser.userComment}</textarea>
    </label>
  </div>
  <div class="elem-user">
    <p class="elem-title">性别</p>
    <h4>${artworkuser.sex}</h4>
  </div>
  <div class="elem-user">
    <label>
      <p class="elem-title">邮箱</p>
      <input type="text" name="e-mail" class="e-mail user-text" value="${artworkuser.email}" disabled>
    </label>
  </div>
  <div class="elem-user">
    <label>
      <p class="elem-title">地址</p>
      <select name="address" class="user-text" disabled>
        <option value="${artworkuser.address}" selected>${artworkuser.address}</option>
      </select>
    </label>
  </div>
  <div class="elem-user">
    <label>
      <p class="elem-title">出生年份</p>
      <input type="text" name="birthday" class="user-text" value="${artworkuser.birthday}" disabled>
    </label>
  </div>
</div>
<%
  request.setAttribute("content","arkworkall");
%>
<%@include file="/jsp/components/content.jsp"%>
</body>
</html>
