<%--
  Created by IntelliJ IDEA.
  User: tianx
  Date: 2022/12/7
  Time: 4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <title>${artworktitle}</title>
    <script src="/static/js/jquery-3.6.1.min"></script>
    <link rel="stylesheet" href="/static/css/artwork.css">
    <%
        request.setAttribute("content","arkwork");
    %>
</head>
<body style="background-color: #606060;">
    <%@ include file="/jsp/components/top.jsp"%>
    <div class="form-artwork">
      <div class="mainphotobg">
        <div class="mainphoto" style="background-image: url(${artwork.artworkaddress})">
        </div>
      </div>
      <div class="form-artworkuser">
        <div>
          <h1 class="ffffff">作者</h1>
        </div>
        <div>
            <form action="/user/toArtworkUser" method="post">
              <input type="hidden" name="id" value="${artwork.userid}">
              <input class="user-profile-photo" type="submit" style="background-image: url(${artworkuser.profilePhoto})" value="">
              <input class="user-color" type="text" value="${artworkuser.username}" disabled>
            </form>
        </div>
        <div class="top-bb">
          <input class="artworktitle" type="text" value="${artwork.artworktitle}"disabled>
        </div>
        <div>
          <textarea class="artworkcomment" type="text"  disabled>${artwork.artworkcomment}</textarea>
        </div>
      </div>
    </div>
    <div class="ffffff clear">
      <%@include file="/jsp/components/content.jsp"%>
    </div>
</body>
</html>
