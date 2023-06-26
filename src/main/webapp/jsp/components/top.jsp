<%--
  Created by IntelliJ IDEA.
  User: tianx
  Date: 2022/12/4
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <script src="/static/js/jquery-3.6.1.js"></script>
    <script src="/static/js/popper.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <script src="/static/js/utils.js"></script>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/top.css">
    <script>
        $(function () {
            $.get("/user/getUser", function (res) {
                var _user = res.user
                // 处理响应
                if (res.msg != "用户不存在"){
                    $('#topnickname').html(_user.nickname)
                    $('#topProfilePhoto').css("background-image","url("+_user.profilePhoto+")")
                    $('#topRightFrom').attr("action","/user/toMyDetails")
                } else {
                    $('#topRightFrom').attr("action","/jsp/main.jsp")
                    $('#topProfilePhoto').attr("value","登录")
                }
            });
        })
    </script>
</head>
<body>
    <div class="top container-fluid">
      <div class="row">
          <div class="offset-md-1">
            <a href="/user/toIndex">
                <input type="submit" class="btn-index" value="主页">
            </a>
          </div>
          <div class="offset-md-7">
              <a href="/jsp/view/upload.jsp">
                  <input type="submit"  class="up-input" value="投稿作品">
              </a>
          </div>
          <div>
              <form id="topRightFrom" method="post">
                  <input type="submit" id="topProfilePhoto" class="hp hp-top" value="">
                  <span class="username-id" id="topnickname">
                  </span>
              </form>
          </div>
      </div>
    </div>
</body>
</html>
