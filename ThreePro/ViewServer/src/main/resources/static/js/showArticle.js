$("#InfoDatas").hide()
$.ajax({
    url: `/Article/`,
    async: true,
    dataType: "json",
    success: (res) => {
        $("#main-3").html(
            "<div class = \"border border-success p-2 mb-2\" style = \"background-color: #005cbf\" > 帖子 </div>"+
            res.data.map(item=>`
            <div class="card" style="width: 100%;color:black">
                   <div class="card-body">
                    <h6 class="card-subtitle mb-2 text-body-secondary">作者：${item.authorId}</h6>
                    <p class="card-text" id="info">${item.infoData}</p>
                    <p class="card-text">${item.time}</p>
            <a href="#" class="btn btn-primary knowMore" authorIds="${item.authorId}" articleIds="${item.id}">点击查看详情</a>
            </div>
            </div>
            `).join("")+"<div id=\"end\">没有了你翻到尽头了</div>")

    },
    error: (err) => {
        console.log(err)
    }
})


$("#main-3").on("click",".knowMore",function(evt){
    $("#main-1").attr("aId",$(evt.target).attr("articleIds"))
    $.ajax({
        url: `/friends/${$(evt.target).attr("authorIds")}`,
        async: true,
        dataType: "json",
        success: (res) => {
            $("#myName").text(res.data[0].username)
            $("#myIntro").text(res.data[0].introduce)
            $("#myHead").attr("src", res.data[0].gender === "男" ? "../img/头像%20男孩.svg" : "../img/头像%20女孩.svg")
            $("#myAge").text(res.data[0].age)
            $("#myId").attr("userId", res.data[0].id)
        },
        error: (err) => {
        }
    })

    $.ajax({
        url: `/Article/${$(evt.target).attr("articleIds")}`,
        async: true,
        dataType: "json",
        success: (res) => {
            $("#authorId").val(res.data.authorId)
            $("#MainInfo").val(res.data.infoData)
            $("#myTime").val(res.data.time)
            $("#InfoDatas").fadeOut(500, "linear")
        },
        error: (err) => {
        }
    })

    $.ajax({
        url: `/Article/comment/${$(evt.target).attr("articleIds")}`,
        async: true,
        dataType: "json",
        success: (res) => {
            if (res.data.length === 0) {
                $("#nav-0").html(
                    `<div class=\"border border-success p-2 mb-2\" id=\"nav-2\" >评论</div>
                            <div class="card" style="width: 100%;color:black" id="comment">
                                <div class="card-body">
                                <h6 class="card-subtitle mb-2 text-body-secondary">来自ThreePro小助手</h6>
                                <p class="card-text">${res.message}</p>
                            </div>
                           </div>`
                )
                return
            }
            $("#nav-0").html(
                "<div class=\"border border-success p-2 mb-2\" id=\"nav-2\">评论</div>" +
                res.data.map(item => `
            <div class="card" style="width: 100%;color:black" id="comment">
                <div class="card-body">
                    <h6 class="card-subtitle mb-2 text-body-secondary">来自:${item.userGood}</h6>
                    <p class="card-text">${item.info}</p>
                </div>
            </div>
            
            `).join("")
            )
        },
        error: (err) => {
        }
    })
})