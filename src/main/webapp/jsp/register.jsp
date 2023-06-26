<%--
  Created by IntelliJ IDEA.
  User: tianx
  Date: 2022/12/3
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <title>注册页面</title>
    <link rel="stylesheet" href="/static/css/main.css">
    <script src="/static/js/jquery-3.6.1.js"></script>
    <script src="/static/js/signup.js"></script>
    <script>
        <%
        if (request.getAttribute("errmsg")=="用户名已存在"){
            %>
        $(function () {
            ac_check();
        })
        <%}%>
    </script>
</head>
<body class="bgimg"
      style="background-image: url(https://gulimall-fantasque.oss-cn-guangzhou.aliyuncs.com/artcommunity/bgImages/signupbgimg.jpg)">
<div class="header">
    <div>
        <a href="/jsp/login.jsp" class="btn login-btn right" style="color: #ffffff">登录</a>
    </div>
</div>
<form class="index-form clear" onsubmit="return check()" method="post" action="/user/register">
    <div>
        <input type="hidden" name="action" value="signup">
    </div>
    <div class="alert psw-alert">
        <p>两次密码不同</p>
    </div>
    <div class="alert psw-c-alert">
        <p>密码应该由8到16个字符组成</p>
        <p>且不应该含有中文字符</p>
    </div>
    <div class="alert ac-alert">
        <p>该用户名已存在</p>
    </div>
    <div class="alert ac-c-alert">
        <p>用户名格式不合法</p>
    </div>
    <h1>注册账号</h1>
    <br>
    <br>
    <div>
        <label>
            <input type="text" name="username" autocomplete="off"
                   id="username" class="text" placeholder="用户名"
                   value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>">
        </label>
    </div>
    <div>
        <label>
            <input type="password" name="password-one"
                   id="password-one" class="text" placeholder="密码"
                   value="<%=request.getAttribute("password")==null?"":request.getAttribute("password")%>">
        </label>
    </div>
    <div>
        <label>
            <input type="password" name="password"
                   id="password-two" class="text" placeholder="确认密码"
                   value="<%=request.getAttribute("password")==null?"":request.getAttribute("password")%>">
        </label>
    </div>
    <br>
    <div class="top-distance">
        <button type="submit" class="btn signup-btn login-button" id="sign" disabled>注册</button>
    </div>
</form>
</body>
</html>
