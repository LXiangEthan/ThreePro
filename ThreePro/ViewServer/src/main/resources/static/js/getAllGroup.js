let myId = localStorage.getItem("id")
originGroup(myId)

function originGroup(myId){
    $.ajax({
        url:`/group/self/${myId}`,
        async:true,
        dataType:"json",
        success:(res)=>{
            if(res.code === 200){
                if(res.data.length === 0){
                    $("#friendList").html(`
                        <li class="list-group-item d-flex justify-content-between align-items-start ">
                        <div class="ms-2 me-auto">
                        <div class="fw-bold">ThreePro小助手</div>
                        赶快进入一个群和大家聊聊吧
                        </div>
                        <span class="badge bg-primary rounded-pill">20</span>
                        </li>
                            `)
                }
                else{
                    GroupInfoInto(res)
                }
            }
            else{

            }
        },
        error:(err)=>{
            console.log(err)
        }
    })
}


function GroupInfoInto(res){
    $("#friendList").html(res.data.map(item=>`
                        <li class="list-group-item d-flex justify-content-between align-items-start activates" 
                        groupName="${item.groupname}" groupId="${item.id}" 
                        groupIntro="${item.introduce}" groupMasterId="${item.groupMasterId}"
                        >
                        <div class="ms-2 me-auto">
                        <div class="fw-bold" >${item.groupname}</div>
                        ${item.introduce}
                        </div>
                        <span class="badge bg-primary rounded-pill" ">群主: 未知</span>
                        </li>
                            `).join(""))
    for(let i = 0;i < $("#friendList").children().length;i++){
        $("#friendList").children().eq(i).on("click",()=>{
            getMessage($("#friendList").children().eq(i).attr("groupId"))
            $("#userDescribs").val($("#friendList").children().eq(i).attr("groupIntro"))
            $("#groupIds").val($("#friendList").children().eq(i).attr("groupId"))
            $("#userService").val($("#friendList").children().eq(i).attr("groupName"))
            let myId = $("#friendList").children().eq(i).attr("groupMasterId")
            verifyGroup(localStorage.getItem("id"),$("#friendList").children().eq(i).attr("groupId"))
            $.ajax({
                url:`/user/${myId}`,
                async:true,
                dataType:"json",
                success:(ress)=>{
                    console.log(ress)
                    if(ress.code === 200){
                        if(ress.data === null){

                            }
                        else{
                            $("#userIds").val(ress.data.id)
                            $("#userNames").val(ress.data.username)
                            $("#userAges").val(ress.data.age)
                            $("#userIntros").val(ress.data.introduce)
                            if(ress.data.gender === "男"){
                                $("#gen1").show()
                                $("#gen2").hide()
                            }
                            else{
                                $("#gen2").show()
                                $("#gen1").hide()
                            }
                        }
                    }
                    else{

                    }
                },
                error:(errr)=>{
                    console.log(errr)
                }
            })
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




function verifyGroup(userId,groupId){
    $.ajax({
        url:`/group/verify`,
        async:true,
        dataType:"json",
        data:`userId=${userId}&groupId=${groupId}`,
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
}


function getMessage(receiverId){
    $.ajax({
        url:`http://localhost:3000/group`,
        async:true,
        dataType:"json",
        method:"post",
        data:{
            receiverId:receiverId
        },
    }).then(async res=>{
        console.log(res)
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
                    <button class="btn btn-outline-secondary" type="button" id="button-addon1">${res[i].sendId}</button>
                    <input type="text" class="form-control" placeholder="" aria-label="Example text with button addon" value="${res[i].data}" aria-describedby="button-addon1" readonly>
                </div>
        `)
            }
        }
    })
}