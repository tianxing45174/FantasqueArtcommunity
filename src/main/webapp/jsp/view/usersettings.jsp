<%--
  Created by IntelliJ IDEA.
  User: tianx
  Date: 2022/12/5
  Time: 14:44
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
     <title>修改个人信息</title>
     <script src="/static/js/jquery-3.6.1.js"></script>
     <script src="/static/js/user.js"></script>
     <!-- <script src="../js/bootstrap.min.js"></script> -->
     <link rel="stylesheet" href="/static/css/user.css">
     <link rel="stylesheet" href="/static/css/main.css">
     <!-- <link rel="stylesheet" href="../css/bootstrap.min.css"> -->
 </head>
 <body style="background-color: #f4f2f4;">
      <div>
      <%@ include file="/jsp/components/top.jsp"%>
      </div>
      <div class="form-user clear fff">
     <form action="/user/uploadUser" method="post" enctype="multipart/form-data">
         <input type="hidden" name="username" value="${user.username}">
         <input type="hidden" name="id" value="${user.id}">
         <div class="fff">
             <div class="hp-user" id="hp-user" style="background-image: url(${user.profilePhoto});"></div>
             <input type="file" name="profilePhoto" id="profile_photo" class="hp-user-up" onchange="previewFile()">
         </div>
         <div>
             <input type="text" class="user-text user-username" name="nickname" value="${user.nickname}">
         </div>
         <div class="elem-user">
             <p class="elem-title">自我介绍</p>
             <textarea name="userComment" class="user-cm user-text">${user.userComment}</textarea>
         </div>
         <div class="elem-user">
             <label>
                 <p class="elem-title">性别</p>

                 <label>
                     <input type="radio" name="sex" value="男性"
                     <c:if test="${user.sex == '男性' }">
                            checked
                     </c:if>
                     >男性
                 </label>
                 <label>
                     <input type="radio" name="sex" value="女性"
                     <c:if test="${user.sex == '女性' }">
                            checked
                     </c:if>
                     >女性
                 </label>
                 <label>
                     <input type="radio" name="sex" value="其他"
                     <c:if test="${user.sex == '其他' }">
                            checked
                     </c:if>
                     >其他
                 </label>
             </label>
         </div>
         <div class="elem-user">
             <p class="elem-title">邮箱</p>
             <input type="text" name="email" class="e-mail user-text" value="${user.email}">
         </div>
         <div class="elem-user">
             <p class="elem-title">地址</p>
             <select name="address" class="user-text">
                 <c:if test="${user.address!=''}">
                     <option value="${user.address}" class="user-select" checked>${user.address}</option>
                 </c:if>
                 <option value="茂名" class="user-select">茂名</option>
                 <option value="北京" class="user-select">北京</option>
                 <option value="肇庆" class="user-select">肇庆</option>
                 <option value="广州" class="user-select">广州</option>
                 <option value="深圳" class="user-select">深圳</option>
                 <option value="天津" class="user-select">天津</option>
             </select>
         </div>
         <div class="elem-user">
             <p class="elem-title">出生年份</p>
             <input type="date" name="birthday" class="user-text" value="${user.birthday}">
         </div>
         <div class="elem-user center-user">
             <input type="submit" value="保存修改" class="btn-user btn-user-submit">
         </div>
     </form>
      <form class="elem-user center-user" action="/user/toMyDetails" method="post">
          <input type="submit" class="btn-user btn-user-esc" value="取消" style="border: none">
      </form>
      </div>
 </body>
 </html>