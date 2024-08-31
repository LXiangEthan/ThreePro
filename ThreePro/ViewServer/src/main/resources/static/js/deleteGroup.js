$("#delF").click(()=>{
    $.ajax({
        url:`/group/`,
        async:true,
        dataType:"json",
        method:"delete",
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
                $("#addF").show()
                $("#delF").hide()
            }
            else{
                $("#addF").hide()
                $("#delF").show()
            }
        },
        error:(err)=>{
            console.log(err)
        }
    })
})