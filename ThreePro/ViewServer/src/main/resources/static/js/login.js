$(".sIn").on("click",()=>{
    if(!$("#inputPassword").val() || !$("#inputEmail").val()){
        $("#warning").fadeIn(1000,"linear")
        return
    }
    $.ajax({
        url:"/login/",
        async:true,
        data:JSON.stringify({
            username:$("#inputEmail").val(),
            password:$("#inputPassword").val()
        }),
        headers:{
            'Content-Type': 'application/json'
        },
        method:"POST",
        dataType:"json",
        success:(res)=>{
            if(res.code === 200){
                localStorage.setItem("id",res.data)
                location.href = "/page/index.html"
            }
            else{
                $("#warning").html(`
                <h5 class="card-title">Warning</h5>
                <p class="card-text">${res.message}</p>
                <button class="btn btn-primary" id="closeWarn">Go somewhere</button>
                `).fadeIn(1000,"linear")
            }
        },
        error:(err)=>{
            $("#warning").html(`
                <h5 class="card-title">Error</h5>
                <p class="card-text">登录失败</p>
                <button class="btn btn-primary" id="closeWarn">Go somewhere</button>
            `).fadeIn(1000,"linear")
        }
    })
})
$("#signout").on("click",()=>{
    if($(".sIn").is(":hidden")){
        $(".sIn").show()
        $(".sOut").hide()
    }
    else{
        $(".sOut").show()
        $(".sIn").hide()
    }
    $("#vPassword").slideToggle(500,"linear")
    $("#intro").slideToggle(500,"linear")
    $("#describe").slideToggle(500,"linear")
    $("#ageBar").slideToggle(500,"linear")
    $("#gender").slideToggle(500,"linear")
    $("#end").slideToggle(500,"linear")
})