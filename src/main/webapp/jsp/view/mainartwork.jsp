<%--
  Created by IntelliJ IDEA.
  User: tianx
  Date: 2022/12/7
  Time: 7:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/artwork.css">
  <script>
    function exitalert(){
      var a = confirm("确认删除图片");
      return a;
    }
  </script>
</head>
<body>
<body style="background-color: #606060;">
<%@ include file="/web/common/top.jsp"%>
<div class="form-artwork">
  <div class="mainphotobg">
    <div class="mainphoto" style="background-image: url(${artworks.artworkaddress})">
    </div>
  </div>
  <div class="form-artworkuser">
<%--    <div>--%>
<%--      <h1 class="ffffff">作者</h1>--%>
<%--    </div>--%>
    <div>
      <form action="/ArtworkServlet?action=delete" method="post">
        <input type="hidden" name="username" value="${mainuser.username}">
        <input type="hidden" name="userid" value="${mainuser.id}">
        <input type="hidden" name="top" value="user">
        <input type="hidden" name="artworkid" value="${artworks.artworkid}">
        <input type="submit" value="删除" onclick="return exitalert();" class="delartwork">
      </form>
    </div>
    <from action="/ArtworkServlet?action=updateArtwork" method="post">
      <input type="hidden" name="username" value="${mainuser.username}">
      <input type="hidden" name="userid" value="${mainuser.id}">
      <input type="hidden" name="top" value="user">
      <input type="hidden" name="artworkid" value="${artworks.artworkid}">
      <div class="top-bb">
        <input class="artworktitle" type="text" name="artworktitle" value="${artworks.artworktitle}">
      </div>
      <div>
        <textarea class="artworkcomment" type="text" name="artworkcomment" >${artworks.artworkcomment}</textarea>
      </div>
    </from>
  </div>
</div>
</body>
</html>
