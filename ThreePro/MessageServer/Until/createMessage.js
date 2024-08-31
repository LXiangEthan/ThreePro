/**
 * @ author ethan
 * @ date  2024年08月30日 下午5:04
 * @ description  写下注释时请使用@变量名/方法名 描述
 **/

function createMessage(sender,receiver,data,mode){
    return JSON.stringify({
        sender,
        receiver,
        data,
        mode
    })
}

module.exports = createMessage