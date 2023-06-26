<%--
  Created by IntelliJ IDEA.
  User: tianx
  Date: 2022/12/4
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <title>error</title>
    <style>
        div {
            font-size: larger;
            text-align: center;
            position: relative;
            top: 40%;
            height: 400px;
            width: 400px;
        }

        a {
            color: black;
            text-decoration: none;
        }

        h1 {
            color: red;
        }
    </style>
</head>
<body>
<div>
    <div>
        <h1>${errmsg}</h1>
        </br>
        <a href="/jsp/index">回到主页</a>
    </div>
</div>
</body>
</html>
