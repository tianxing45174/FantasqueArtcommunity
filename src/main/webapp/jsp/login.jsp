<%--
  Created by IntelliJ IDEA.
  User: tianx
  Date: 2022/12/3
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
    <head>
        <title>登录页面</title>
        <link rel="stylesheet" href="/static/css/main.css">
        <script src="/static/js/jquery-3.6.1.js"></script>
        <script src="/static/js/login.js"></script>
        <script>
            <%
            if (request.getAttribute("loginmsg")==null){

            } else {
            %>
            $(function(){
                ac_check();
            })
            <%}
            %>
        </script>
    </head>
    <body class="bgimg" style="background-image: url(https://gulimall-fantasque.oss-cn-guangzhou.aliyuncs.com/artcommunity/bgImages/loginbgimg.jpg)">
        <div class="header">
            <div>
                <a href="/jsp/register.jsp" class="btn signup-btn right" style="background-color: rgb(0, 150, 250)">注册账号</a>
            </div>
        </div>
        <form name="loginForm" class="index-form clear" action="/user/login" method="post">
            <input type="hidden" name="_method" value="GET"/>
            <div class="alert ac-alert">
                <p>${loginmsg}</p>
            </div>
            <h1>登录</h1>
            <br>
            <div class="top-distance">
                <label>
                    <input type="text" name="username" autocomplete="off"
                           class="username text" id="username" placeholder="用户名"
                           value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>">
                </label>
            </div>
            <div class="top-distance">
                <label>
                    <input type="password" name="password" autocomplete="off"
                           class="password text" id="password" placeholder="密码"
                           value>
                </label>
            </div>
            <div class="top-distance">
                <button type="submit" class="btn signup-btn login-button" id="login" disabled>登录</button>
            </div>
        </form>
    </body>
</html>
