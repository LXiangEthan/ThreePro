/**
 * @ author ethan
 * @ date  2024年08月30日 下午4:52
 * @ description  写下注释时请使用@变量名/方法名 描述
 **/
const mongoose = require("mongoose")
const Schema = mongoose.Schema
const schema = {
    sendId:String,
    receiverId:String,
    data:String,
    time:String
}
const chatMaModel = mongoose.model("chatMa",new Schema(schema))

module.exports = chatMaModel