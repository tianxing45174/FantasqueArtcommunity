
<%--
  Created by IntelliJ IDEA.
  User: tianx
  Date: 2022/12/5
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>主页</title>
  <script src="/static/js/jquery-3.6.1.js"></script>
  <script src="/static/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="/static/css/main.css">
  <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>

<%
  request.setAttribute("content","all");
%>
<%@include file="/jsp/components/top.jsp"%>

<%@include file="/jsp/components/content.jsp"%>

<%@include file="/jsp/components/navbottom.jsp"%>
</body>
</html>
