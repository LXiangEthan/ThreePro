let myId = localStorage.getItem("id")
const socket = io(`ws://localhost:3000?id=${myId}`)
const WebSocketType = {
    ERROR:0,
    SINGLECHAT:1,
    GROUPCHAT:2,
    GROUPLIST:3
}


$("#mSend").click(()=>{
    if($("#search").val() === ""){
        return
    }
    else{
        $.ajax({
            url:`/user/groupUser/${$("#groupIds").val()}`,
            async:true,
            dataType:"json"
        }).then(res=>{
            let data = createMessage(myId,$("#search").val(),$("#groupIds").val(),res)
            console.log(data)
            socket.emit(WebSocketType.GROUPCHAT,data)
            data = JSON.parse(data)
            if($("#groupIds").val() === data.receiver) {
                $("#message").append(`
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="" aria-label="Recipient's username" value="${data.data}" aria-describedby="button-addon2" readonly>
                    <button class="btn btn-outline-secondary" type="button" id="button-addon2">我</button>
                </div>
        `       )
                $.ajax({
                    url:`http://localhost:3000/create`,
                    async:true,
                    dataType:"json",
                    method:"post",
                    data:{
                        sendId:localStorage.getItem("id"),
                        receiverId:data.receiver,
                        data:data.data
                    },
                }).then(res=>{
                    console.log(res)
                })
            }else{
                $.ajax({
                    url:`http://localhost:3000/create`,
                    async:true,
                    dataType:"json",
                    method:"post",
                    data:{
                        sendId:localStorage.getItem("id"),
                        receiverId:data.receiver,
                        data:data.data
                    },
                }).then(res=>{
                    console.log(res)
                })
            }
            $("#search").val("")
        }).catch(err=>{
            console.log(err)
        })

    }
})


socket.on(WebSocketType.GROUPLIST,(msg)=>{
    console.log(msg)

})
socket.on(WebSocketType.ERROR,(err)=>{
    console.log(err)
    location.href = "/index.html"
})
socket.on(WebSocketType.GROUPCHAT,(msg)=>{
    let data = JSON.parse(msg)
    console.log(data)
    if($("#groupIds").val() === data.receiver){
        $("#message").append(`
                <div class="input-group mb-3" style="margin-top: 30px;margin-bottom: 30px">
                    <button class="btn btn-outline-secondary" type="button" id="button-addon1">${data.sender}</button>
                    <input type="text" class="form-control" placeholder="" aria-label="Example text with button addon" value="${data.data}" aria-describedby="button-addon1" readonly>
                </div>
        `)
    }
})
socket.on(WebSocketType.SINGLECHAT,(msg)=>{
    console.log(msg)

})

function createMessage(sender,data,receiver,mode){
    return JSON.stringify({
        sender,
        data,
        receiver,
        mode
    })
}