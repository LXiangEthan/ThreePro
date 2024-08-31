$("#cG").click(()=>{
    $("#createGroup").toggle(500,"linear")
})

$("#closeCreate").click(()=>{
    $("#createGroup").hide(500,"linear")
})

$("#updateCreate").click(()=>{
    if($("#gName").val() === ""){
        $("#gName").val("请填写完整群名称")
    }
    $.ajax({
        url:`/group/create`,
        async:true,
        dataType:"json",
        method:"post",
        data:JSON.stringify({
            groupMasterId:localStorage.getItem("id"),
            groupname: $("#gName").val(),
            introduce: $("#gIntro").val()
        }),
        headers:{
            "Content-Type":"application/json"
        },
        success:(res)=>{
            $("#createGroup").hide(500,"linear")
            location.reload()
        },
        error:(err)=>{
        }
    })
})