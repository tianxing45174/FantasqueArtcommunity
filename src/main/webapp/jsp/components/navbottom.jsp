<%--
  Created by IntelliJ IDEA.
  User: tianx
  Date: 2022/12/5
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>navbottom</title>
    <script src="/static/js/jquery-3.6.1.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/static/css/main.css">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="row">
    <div class="offset-4"></div>

    <button class="col-1 navbottomall">
        <span>第${page}页 共${pages}页</span>
    </button>
    <form class="col-1" action="/artwork/getArtworkAllPage/1"
<%--          onsubmit="return false" onclick="getAllPage(1)" --%>
          method="post">
        <input type="hidden" name="page" value="1">
        <c:choose >
            <c:when test="${page==1}">
                <button type="submit" class="navbottom" disabled>
            </c:when>
            <c:otherwise>
                <button type="submit" class="navbottom navbottomone">
            </c:otherwise>
        </c:choose>
            第一页
        </button>
    </form>
    <form class="col-1" action="/artwork/getArtworkAllPage/${page-1}"
<%--          onsubmit="return false" onclick="getAllPage(${page-1})" --%>
          method="post">
<%--        <input type="hidden" name="username" value="${mainuser.username}">--%>
        <input type="hidden" name="page" value="${page-1}">
        <c:choose >
            <c:when test="${page==1}">
                <button type="submit" class="navbottom" disabled>
            </c:when>
            <c:otherwise>
                <button type="submit" class="navbottom navbottomone">
            </c:otherwise>
        </c:choose>
            上一页
        </button>
    </form>
    <form class="col-1" action="/artwork/getArtworkAllPage/${page+1}"
<%--          onsubmit="return false" onclick="getAllPage(${page+1})" --%>
          method="post">
<%--        <input type="hidden" name="username" value="${mainuser.username}">--%>
        <input type="hidden" name="page" value="${page+1}">
        <c:choose >
            <c:when test="${page==pages}">
                <button type="submit" class="navbottom" disabled>
            </c:when>
            <c:otherwise>
                <button type="submit" class="navbottom navbottomone">
            </c:otherwise>
        </c:choose>
            下一页
<%--            <a href="/web/main.jsp?page=<%=p+1%>" class="col-1">下一页</a>--%>
        </button>
    </form>
    <form class="col-1" action="/artwork/getArtworkAllPage/${pages}"
<%--          onsubmit="return false" onclick="getAllPage(${pages})" --%>
          method="post">
        <input type="hidden" name="page" value="${pages}">
        <c:choose >
            <c:when test="${page==pages}">
                <button type="submit" class="navbottom" disabled>
            </c:when>
            <c:otherwise>
                <button type="submit" class="navbottom navbottomone">
            </c:otherwise>
        </c:choose>
            最后一页
<%--            <a href="/web/main.jsp?page=<%=pagecount %>" class="col-1">最后一页</a>--%>
        </button>
    </form>
<%--    <form>--%>
<%--    跳转至<input type="text" id="inputPage"--%>
<%--                 onchange="inputPage()"--%>
<%--                 size="2" value=""/>--%>
<%--        <a href="/artwork/getArtworkAllPage/">跳转</a>--%>
<%--    </form>--%>

</div>
</body>
</html>