$("#addF").click(()=>{
    $.ajax({
        url:`/friends/`,
        async:true,
        dataType:"json",
        method:"post",
        data:JSON.stringify({
            presId: localStorage.getItem("id"),
            afterId: $("#userIds").val(),
            relationShip: 0
        }),
        headers:{
            "Content-Type":"application/json"
        },
        success:(res)=>{
            if(res.code === 200){
                $("#addF").hide()
                $("#delF").show()
            }
            else{
                $("#addF").show()
                $("#delF").hide()
            }
        },
        error:(err)=>{
            console.log(err)
        }
    })
})