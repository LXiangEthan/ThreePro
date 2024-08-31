/**
 * @ author ethan
 * @ date  2024年08月30日 下午4:52
 * @ description  写下注释时请使用@变量名/方法名 描述
 **/
const mongoose = require("mongoose")
mongoose.connect("mongodb://127.0.0.1:27017/ThreePro")
const chatMaModel = require("./domain")