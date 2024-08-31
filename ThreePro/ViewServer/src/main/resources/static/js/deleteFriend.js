$("#delF").click(()=>{
        $.ajax({
            url:`/friends/`,
            async:true,
            dataType:"json",
            method:"delete",
            data:JSON.stringify({
                    presId: localStorage.getItem("id"),
                    afterId: $("#userIds").val(),
                    relationShip: 1
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