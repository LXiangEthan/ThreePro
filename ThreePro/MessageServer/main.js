/**
 * @ author ethan
 * @ date  2024年08月30日 下午4:47
 * @ description  写下注释时请使用@变量名/方法名 描述
 **/
const port = 3000
const Koa = require('koa')
const chatMa = require("./dao/domain")
const app = new Koa()
const bodyParser = require('koa-bodyparser')
const server = require('http').createServer(app.callback());
const io = require('socket.io')(server,{ cors: true });
const createMessage = require("./Until/createMessage");
const getMessageRouter = require("./Router/getMessage");
const cors = require('@koa/cors')
require("./dao/conn")
app.use(cors());
app.use(bodyParser())
app.use(getMessageRouter.routes()).use(getMessageRouter.allowedMethods())
const WebSocketType = {
    ERROR:0,
    SINGLECHAT:1,
    GROUPCHAT:2,
    GROUPLIST:3
}

io.on('connection', (socket,req) => {
    socket.id = socket.handshake.query.id
    console.log("用户"+socket.id+"已经连接")
    socket.on(WebSocketType.GROUPLIST, (msg) => {
        console.log(msg)
    })

    socket.on(WebSocketType.GROUPCHAT, (msg) => {
        let parseMsg = JSON.parse(msg)
        let onlineUser = []
        for(let i of parseMsg.mode.data){
            onlineUser.push(i.userId)
        }
        Array.from(io.sockets.sockets).forEach(Socket => {
            if (onlineUser.indexOf(Socket[1].id) !== -1 && Socket[1].id !== socket.id) {
                console.log(msg.data)
                Socket[1].emit(WebSocketType.GROUPCHAT, createMessage(socket.id, parseMsg.receiver, parseMsg.data, "group"))
            }
        })
        socket.on("disconnect", () => {
            console.log("您已断开链接")
        })
    })

    socket.on(WebSocketType.SINGLECHAT, (msg) => {
        msg = JSON.parse(msg)
        Array.from(io.sockets.sockets).forEach(Socket => {
            if (Socket[1].id === msg.receiver) {
                Socket[1].emit(WebSocketType.SINGLECHAT, createMessage(socket.id, msg.receiver, msg.data, "single"))
            }
        })
        socket.on("disconnect", () => {
            console.log("您已断开链接")
        })
    })
})
server.listen(port)



