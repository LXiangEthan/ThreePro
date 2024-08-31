$("#addF").click(()=>{
    $.ajax({
        url:`/group/`,
        async:true,
        dataType:"json",
        method:"post",
        data:JSON.stringify({
            userId: localStorage.getItem("id"),
            groupId: $("#groupIds").val(),
            groupRel: 0
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