<%--
  Created by IntelliJ IDEA.
  User: tianx
  Date: 2022/12/5
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%
    String basepath = request.getScheme()
        + "://"
        + request.getServerName()
        + ":"
        + request.getServerPort()
        + request.getContextPath()
        + "/";
%>
<base href="<%=basepath%>">
<script type="text/javascript" src="/static/js/jquery-3.6.1.js"></script>
<link type="text/css" rel="stylesheet" href="/static/css/bootstrap.min.css">
<script type="text/javascript" src="/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/static/js/popper.min.js"></script>
