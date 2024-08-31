/**
 * @ author ethan
 * @ date  2024年08月31日 上午11:21
 * @ description  写下注释时请使用@变量名/方法名 描述
 **/
const Router = require('koa-router');
const getMessageRouter = new Router()
const chatMa = require("../dao/domain")
getMessageRouter.post("/personal",async (ctx)=>{
    // 获取数据
    await chatMa.find({$or:[{"sendId":ctx.request.body.sendId,"receiverId":ctx.request.body.receiverId},{"sendId":ctx.request.body.receiverId,"receiverId":ctx.request.body.sendId}]},["sendId","receiverId","data","time"]).sort({time:1}).then(res=>{
        ctx.body = JSON.stringify(res)
    })

})
getMessageRouter.post("/group",async (ctx)=>{
    await chatMa.find({"receiverId":ctx.request.body.receiverId},["sendId","receiverId","data","time"]).then(res=>{
        ctx.body = JSON.stringify(res)
    })
})

getMessageRouter.post("/create",(ctx)=>{
    chatMa.create({
        sendId: ctx.request.body.sendId,
        receiverId: ctx.request.body.receiverId,
        data: ctx.request.body.data,
        time: new Date().getTime()
    })
        .then(res => {
            console.log(ctx.request.body.sendId + "向" + ctx.request.body.receiverId + "发送了一条消息")
            ctx.body = "{ok:1}"
        })
        .catch(err => {
            console.log(err)
        })
})

module.exports = getMessageRouter