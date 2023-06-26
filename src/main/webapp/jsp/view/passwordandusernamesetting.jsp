<%--
  Created by IntelliJ IDEA.
  User: tianx
  Date: 2022/12/7
  Time: 3:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <title>修改密码账号</title>
    <script src="/static/js/jquery-3.6.1.js"></script>
    <script src="/static/js/signup.js"></script>
    <link rel="stylesheet" href="/static/css/main.css">
    <link rel="stylesheet" href="/static/css/passwordchange.css">

    <style type="text/css">
        .btn-user-esc {
            position: relative;
            margin: -20px auto 0;
            text-align: center;
            background-color: rgba(255, 255, 255, 0.80);
            box-sizing: border-box;
            padding: 9px 24px;
            display: block;
            height: 40px;
            color: #fff;
            line-height: 24px;
            font-weight: 700;
            font-size: 14px;
            text-decoration: none;
            border-radius: 20px;
            transition: background-color 0.5s ease 0s, color 0.5s ease 0s;
            background: #3c3c3c;
            width: 200px;
            border: none;
            margin-bottom: 5px;
        }
    </style>

    <script>
        $(function(){
      <%
      if (request.getAttribute("signmsg")=="用户名已存在"){
        %>ac_check()<%
      } else if (request.getAttribute("signmsg")=="旧密码错误"){
      %>psw_check();
      <%}else {%>

        <%}%>
        })
  </script>
</head>
<body class="bgimg">
  <div>
    <%@ include file="/jsp/components/top.jsp"%>
  </div>
  <form  class="index-form clear" onsubmit="return ac_c_check()" action="/user/uploadUsernameAndPassword" method="post">
      <input type="hidden" name="id" value="${user.id}">
      <div class="alertchange psw-alert">
          <p>旧密码错误</p>
      </div>
      <div class="alertchange ac-alert">
          <p>该用户名已存在</p>
      </div>
      <div class="alertchange ac-c-alert">
          <p>用户名格式不合法</p>
      </div>

      <h1>修改密码账号</h1>
      <br>
      <br>
      <div>
          <label>
              <input type="text" name="username" autocomplete="off"
                     id="username" class="text" placeholder="用户名" value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>">
          </label>
      </div>
      <div>
          <label>
              <input type="password" name="password-one"
                     id="password-one" class="text" placeholder="旧密码"
                     value="<%=request.getAttribute("password-one")==null?"":request.getAttribute("password-one")%>">
          </label>
      </div>
      <div>
          <label>
              <input type="password" name="password-two"
                     id="password-two" class="text" placeholder="新密码"
                     value="<%=request.getAttribute("password-two")==null?"":request.getAttribute("password-two")%>">
          </label>
      </div>
      <br>
      <div class="top-distance">
          <button type="submit" class="btn signup-btn login-button" id="sign" disabled>确认修改</button>
      </div>
</form>
<form class="elem-user center-user" action="/user/toMyDetails" method="post">
  <input type="submit" class="btn-user-esc" value="取消" style="border: none">
</form>
</body>
</html>
