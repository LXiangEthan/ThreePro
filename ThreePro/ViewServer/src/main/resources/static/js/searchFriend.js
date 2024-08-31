$("#searchF").keyup(function(evt){

    if (evt.which === 13) {
        if($("#searchF").val() === ""){
            let myId = localStorage.getItem("id")
            originFriend(myId)
        }
        else {
            $.ajax({
                url: `/friends/${$("#searchF").val()}`,
                async: true,
                headers: {
                    'Content-Type': 'application/json'
                },
                method: "GET",
                dataType: "json",
            }).then(res => {
                if(res.code === 200) {
                    console.log(res)
                    UserInfoInto(res)
                }
                else{
                    $("#friendList").html(`
                        <li class="list-group-item d-flex justify-content-between align-items-start ">
                        <div class="ms-2 me-auto">
                        <div class="fw-bold">ThreePro小助手</div>
                        没有找到该用户
                        </div>
                        <span class="badge bg-primary rounded-pill">20</span>
                        </li>
                            `)
                }
            }).catch(err => {
                console.log(err)
            })
        }
    }
})


function UserInfoInto(res){
    $("#friendList").html(res.data.filter(item=>item!==null).map(item=>`
                        <li class="list-group-item d-flex justify-content-between align-items-start activates" 
                        userName="${item.username}" userId="${item.id}" 
                        userGender="${item.gender}" userDescription="${item.description}"
                        userIntro="${item.introduce}" userAge="${item.age}"
                        >
                        <div class="ms-2 me-auto">
                        <div class="fw-bold" >${item.username}</div>
                        ${item.introduce}
                        </div>
                        <span class="badge bg-primary rounded-pill" ">${item.age}岁</span>
                        </li>
                            `).join(""))
    for(let i = 0;i < $("#friendList").children().length;i++){
        $("#friendList").children().eq(i).on("click",()=>{
            getMessage($("#friendList").children().eq(i).attr("userId"))
            $("#userIds").val($("#friendList").children().eq(i).attr("userId"))
            $("#userNames").val($("#friendList").children().eq(i).attr("userName"))
            $("#userAges").val($("#friendList").children().eq(i).attr("userAge"))
            $("#userIntros").val($("#friendList").children().eq(i).attr("userIntro"))
            $("#userDescribs").val($("#friendList").children().eq(i).attr("userDescription"))
            verifyFriend(localStorage.getItem("id"),$("#friendList").children().eq(i).attr("userId"))
            if($("#friendList").children().eq(i).attr("userGender") === "男"){
                $("#gen1").show()
                $("#gen2").hide()
            }
            else{
                $("#gen2").show()
                $("#gen1").hide()
            }


            $("#friendList").children().eq(i).addClass("super").siblings().removeClass("super")
        }).on("mouseover",()=>{
            if(!$("#friendList").children().eq(i).hasClass("super")) {
                $("#friendList").children().eq(i).css("background", "#00cbff")
                $("#friendList").children().eq(i).siblings().css("background","")
            }
        })

        $("#friendList").mouseout(()=>{
            $("#friendList").children().css("background","")
        })
    }
}

function originFriend(myId){
    $.ajax({
        url:`/friends/self/${myId}`,
        async:true,
        dataType:"json",
        success:(res)=>{
            if(res.code === 200){
                if(res.data.length === 0){
                    $("#friendList").html(`
                        <li class="list-group-item d-flex justify-content-between align-items-start ">
                        <div class="ms-2 me-auto">
                        <div class="fw-bold">ThreePro小助手</div>
                        你还没有交到朋友啊
                        </div>
                        <span class="badge bg-primary rounded-pill">20</span>
                        </li>
                            `)
                }
                else{
                    UserInfoInto(res)
                }
            }
            else{

            }
        },
        error:(err)=>{
        }
    })
}

function verifyFriend(presId,afterId){
    $.ajax({
        url:`/friends/verify`,
        async:true,
        dataType:"json",
        data:`presId=${presId}&afterId=${afterId}`,
        success:(res)=>{
            if(res.code === 200){
                $("#addF").hide()
                $("#delF").show()
            }
            else{
                $("#addF").show()
                $("#delF").hide()
            }
            console.log(res)
        },
        error:(err)=>{
            console.log(err)
        }
    })
}


function getMessage(receiverId){
    $.ajax({
        url:`http://localhost:3000/personal`,
        async:true,
        dataType:"json",
        method:"post",
        data:{
            sendId:localStorage.getItem("id"),
            receiverId:receiverId
        },
    }).then(async res=>{
        $("#message").html("")
        for(let i in res){
            if(res[i].sendId === localStorage.getItem("id")){
                $("#message").append(`
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="" aria-label="Recipient's username" value="${res[i].data}" aria-describedby="button-addon2" readonly>
                    <button class="btn btn-outline-secondary" type="button" id="button-addon2">我</button>
                </div>
        `)
            }
            else{
                $("#message").append(`
                <div class="input-group mb-3" style="margin-top: 30px;margin-bottom: 30px">
                    <button class="btn btn-outline-secondary" type="button" id="button-addon1">${$("#userNames").val()}</button>
                    <input type="text" class="form-control" placeholder="" aria-label="Example text with button addon" value="${res[i].data}" aria-describedby="button-addon1" readonly>
                </div>
        `)
            }
        }
    })
}