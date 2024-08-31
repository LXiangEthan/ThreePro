$("#send1").click(()=>{
    if($("#contain1").val() === ""){
        return
    }
    $.ajax({
        url:`/Article/comment`,
        async:true,
        dataType:"json",
        method:"post",
        data:JSON.stringify({
            id:0,
            articleId:$("#main-1").attr("aId"),
            info:$("#contain1").val(),
            userGood:localStorage.getItem("id")
        }),
        headers:{
            "Content-Type":"application/json"
        },
        success:(res)=>{
            console.log(res)
            location.reload()
        },
        error:(err)=>{
            console.log(err)
        }
    })
})
$("#writeInfoC").click(()=>{
    $("#addComments").toggle()
})