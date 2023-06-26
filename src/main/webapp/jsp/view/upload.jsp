<%--
  Created by IntelliJ IDEA.
  User: tianx
  Date: 2022/12/5
  Time: 0:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <title>投稿</title>
    <script src="/static/js/jquery-3.6.1.js"></script>
    <script src="/static/js/upload.js"></script>
    <link rel="stylesheet" href="/static/css/upload.css">
    <link rel="stylesheet" href="/static/css/main.css">
</head>
<body class="upload-bg">
  <div>
    <%@ include file="/jsp/components/top.jsp"%>
  </div>
  
  <form class="upload-form" action="/artwork/uploadUser" method="post" enctype="multipart/form-data">
    
    <div class="photo-show" >

      <div class="input-upload">

        
        <div id="photo-show">
          <button class="upload" onclick="return false;">选择文件</button>
        </div>

        <input type="file" name="artworkaddress" id="input-file" onchange="previewFile()" 
        class="show upload-a">

      </div>
      
    </div>

    <div class="ttext">
      <input type="text" name="artworktitle" id="title" class="input" autocomplete="off"
        placeholder="标题" value>
      <div class="options">
        <span class="title-count">0</span>
        /20
      </div>
    </div>
    <hr>
    <div class="ttext">
      <textarea type="text" name="artworkcomment" class="input"
      autocomplete="off" placeholder="说明" id="comment"></textarea>
      <div class="options">
        <span class="cm-count">0</span>
        /300
      </div>
    </div>
    
    <div>
      <input type="submit" value="投稿" class="up-submit up-submit-false" disabled>
    </div>
  </form>
</body>
</html>
