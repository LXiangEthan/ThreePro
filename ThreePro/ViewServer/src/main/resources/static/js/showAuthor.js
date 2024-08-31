$("#myId").click(()=>{
    navigator.clipboard.writeText($("#myId").attr("userId"))
    $("#authorInfo").show(50,"linear")
    setTimeout(()=>{
        location.href = "/page/index.html"
    },2000)

})