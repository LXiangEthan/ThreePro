$("#cangku").click(()=>{
    $("#request").fadeToggle(1000,"linear")
    $.ajax({
        url:`/group/request/${localStorage.getItem("id")}`,
        async:true,
        dataType:"json",
        method:"get",
        headers:{
            "Content-Type":"application/json"
        },
        success:(res)=> {
            $("#request").html(
                "<li class=\"list-group-item active\" aria-current=\"true\">入群请求</li>"+
                res.data.map(item=>
                    `
                    <li className="list-group-item fixReq">来自ID(${item.userId})的用户的入群(${item.groupId})请求
                        <button type="button" class="btn btn-primary rels" userId="${item.userId}" groupId="${item.groupId}">agree</button>
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
    console.log($(evt.target).attr("userId"));

    $.ajax({
        url:`/group/`,
        async:true,
        dataType:"json",
        method:"put",
        headers:{
            "Content-Type":"application/json"
        },
        data:JSON.stringify({
            userId:$(evt.target).attr("userId"),
            groupId:$(evt.target).attr("groupId"),
            groupRel: 1
        }),
        success:(res)=> {
            console.log(res)
            $("#addF").hide()
            $("#delF").show()
            $("#request").fadeOut(1000,"linear")
        },
        error: (err) => {

        }
    })
})
