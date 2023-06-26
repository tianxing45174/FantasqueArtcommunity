// function getPage(userid, current) {
//     var page
//     $.get("/artwork/getPage/" + userid + "/" + current, function (res) {
//         // 处理响应
//         // console.log('Page',res)
//         page = res.page
//     });
//     return page
// }
$(function () {
    // function getAllPage(current) {
    //     var page
    //     $.get("/artwork/getArtworkAllPage/" + current, function (res) {
    //         // 处理响应
    //         page = res.page
    //         console.log(page)
    //         addArtList(page)
    //     });
    //     return page
    // }

    function getCookie(name) {
        var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");

        if (arr = document.cookie.match(reg))
            // console.log(arr[2]);
            return unescape(arr[2]);
        else
            return null;
    }

    // function addArtList(page) {
    //     console.log(page)
    //     for (const i in page.records) {
    //         console.log("artworkaddress", page.records[i].artworkaddress);
    //         for (let i = 0; i < 12; i++) {
    //             $('#artList').append(
    //                 '<div class="col-2">' +
    //                 '<form action="/UserServlet?action=mainselectuser" method="post">' +
    //                 `<input type="submit" class="artworks artwork" value="" style="background-image: url(` + page.records[i].artworkaddress + `);">` +
    //                 '</form>' +
    //                 '</div>'
    //             )
    //         }
    //     }
    // }

})