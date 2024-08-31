$("#cangku").click(()=>{
    $("#request").fadeToggle(1000,"linear")
    $.ajax({
        url:`/friends/request/${localStorage.getItem("id")}`,
        async:true,
        dataType:"json",
        method:"get",
        headers:{
            "Content-Type":"application/json"
        },
        success:(res)=> {
            $("#request").html(
                "<li class=\"list-group-item active\" aria-current=\"true\">好友请求</li>"+
                res.data.map(item=>
                    `
                    <li class="list-group-item fixReq">来自ID(${item.id})的用户(${item.username})的好友请求
                        <button type="button" class="btn btn-primary rels" thisId = ${item.id}>agree</button>
                    </li>
                    `
                ).join(" ")
            )


        },
        error: (err) => {
            console.log(err)
        }
    })
})



$("#request").click("#agree",function(evt){


    $.ajax({
        url:`/friends/`,
        async:true,
        dataType:"json",
        method:"put",
        headers:{
            "Content-Type":"application/json"
        },
        data:JSON.stringify({
            presId:$(evt.target).attr("thisId"),
            afterId:localStorage.getItem("id"),
            relationShip: 1
        }),
        success:(res)=> {
            $("#addF").hide()
            $("#delF").show()
            $("#request").fadeOut(1000,"linear")
        },
        error: (err) => {

        }
    })
})
