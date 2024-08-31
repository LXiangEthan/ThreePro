$("#warning").on("click",()=>{
    $("#warning").fadeOut(1000,"linear")
})
$(".sOut").on("click",()=>{
    if(!$("#inputEmail").val() ||
        !$("#inputPassword").val() ||
        !$("#verifyPassword").val() ||
        !$("#gender").val() ||
        !$("#age").val()){
        $("#warning").fadeIn(1000,"linear")
        return
    }
    if($("#inputPassword").val() !== $("#verifyPassword").val()){
        $("#warning").fadeIn(1000,"linear")
        return
    }
    $.ajax({
        url:"/login/signOut",
        async:true,
        data:
            JSON.stringify({
                username: $("#inputEmail").val(),
                password: $("#inputPassword").val(),
                description: $("#describeText").val(),
                introduce: $("#introText").val(),
                gender: $("#gender").val(),
                age: $("#age").val(),
            }),
        headers:{
            'Content-Type': 'application/json'
        },
        method:"POST",
        dataType:"json",
        success:(res)=>{
            if(res.code === 200){
                // $("#warning").html(`
                // <h5 class="card-title">Success</h5>
                // <p class="card-text">${res.message}</p>
                // <button class="btn btn-primary" id="closeWarn">Go somewhere</button>
                // `).show()
                localStorage.setItem("id",res.data)
                location.href = "/page/index.html"
            }
            else{
                $("#warning").html(`
                <h5 class="card-title">Success</h5>
                <p class="card-text">${res.message}</p>
                <button class="btn btn-primary" id="closeWarn">Go somewhere</button>
                `).fadeIn(1000,"linear")
            }
        },
        error:(err)=>{
                $("#warning").html(`
                <h5 class="card-title">Error</h5>
                <p class="card-text">注册失败,系统错误</p>
                <button class="btn btn-primary" id="closeWarn">Go somewhere</button>
                `).fadeIn(1000,"linear")
        }
    })
})

