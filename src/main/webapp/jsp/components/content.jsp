<%--
  Created by IntelliJ IDEA.
  User: tianx
  Date: 2022/12/5
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <script src="/static/js/jquery-3.6.1.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <script src="/static/js/utils.js"></script>
    <link rel="stylesheet" href="/static/css/main.css"/>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css"/>
    <script>
        // $(function () {
        //     function addArtList(page) {
        //         console.log("addArtList",page)
        //         for (const i in page.records) {
        //             // console.log("artworkaddress", page.records[i].artworkaddress);
        //             // for (let i = 0; i < page.records.length; i++) {
        //                 $('#artList').append(
        //                     '<div class="col-2">' +
        //                     '<form action="/UserServlet?action=mainselectuser" method="post">' +
        //                     `<input type="submit" class="artworks artwork" value="" style="background-image: url(` + page.records[i].artworkaddress + `);">` +
        //                     '</form>' +
        //                     '</div>'
        //                 )
        //             // }
        //         }
        //     }
        //     function getAllPage(current) {
        //         var page
        //         $.get("/artwork/getArtworkAllPage/"+current, function (res) {
        //             // 处理响应
        //             page = res.page
        //             console.log(res)
        //             addArtList(page)
        //             return page;
        //         });
        //         return false;
        //     }
        //     getAllPage(1);
        // })
        // function addArtList(page) {
        //     console.log("addArtList",page)
        //     $('#artList').html("");
        //     for (const i in page.records) {
        //         // console.log("artworkaddress", page.records[i].artworkaddress);
        //         // for (let i = 0; i < page.records.length; i++) {
        //         $('#artList').append(
        //             '<div class="col-2">' +
        //             '<form action="/UserServlet?action=mainselectuser" method="post">' +
        //             `<input type="submit" class="artworks artwork" value="" style="background-image: url(` + page.records[i].artworkaddress + `);">` +
        //             '</form>' +
        //             '</div>'
        //         )
        //         // }
        //     }
        // }
        // function getAllPage(current) {
        //     var page
        //     $.get("/artwork/getArtworkAllPage/"+current, function (res) {
        //         // 处理响应
        //         page = res.page
        //         console.log(res)
        //         addArtList(page)
        //         return page;
        //     });
        //     return false;
        // }
    </script>
</head>
<body>
<div class="content container">
    <div class="row title-artwork">
        <%if ("arkwork".equals(request.getAttribute("content"))) {%>

        <h1 class="col-6" style="color: #fff">投稿的其他作品</h1>
        <%} else if ("arkworkall".equals(request.getAttribute("content"))) {%>
        <h1 class="col-6" style="color: #fff">投稿的作品</h1>
        <%} else {%>
        <h1 class="col-6">投稿的作品</h1>
        <%}%>

    </div>
    <div class="row" id="artList">
                <c:forEach items="${records}" var="record">
                    <div class="col-2">

                      <form action="/artwork/artworkByArtworkId/${record.artworkid}" method="post">
                        <%if ("user".equals(request.getAttribute("content"))) {%>
                        <input type="hidden" name="top" value="mainartwork">
                        <%} else {%>
                        <input type="hidden" name="top" value="artwork">
                        <%}%>
                        <input type="hidden" name="artworkid" value="${record.artworkid}">
                        <input type="submit" class="artworks artwork" value=""
                           style="background-image: url(${record.artworkaddress});">
                      </form>
                    </div>
                </c:forEach>
    </div>
</div>
</body>
</html>
