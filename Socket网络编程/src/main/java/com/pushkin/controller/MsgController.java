package com.pushkin.controller;

import com.pushkin.websocket.WebSocketPushHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/4/19 13:39
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
@RestController
@RequestMapping("/msg")
public class MsgController {

    /**
     * 功能描述:向全体广播消息
     * @param: [msg] 消息内容
     * @return: boolean
     * @auther: lzy
     * @date: 2019/8/14 16:10
     */
    @PostMapping("/sendMsg")
    public boolean sendMsg(String msg){
        System.out.println("全体广播消息 ["+msg+"]");
        TextMessage textMessage = new TextMessage(msg);
        try{
            WebSocketPushHandler.sendMessagesToUsers(textMessage);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * 功能描述:向指定用户发送消息
     * @param msg 消息内容
     * @param userId 用户编号
     * @return: boolean
     * @auther: lzy
     * @date: 2019/8/14 16:13
     */
    @PostMapping("/sendMsgByUser")
    public boolean sendMsgByUser(String msg,String userId){
        System.out.println("向 "+userId+" 发送消息，消息内容为:"+msg);
        TextMessage textMessage = new TextMessage(msg);
        try{
            WebSocketPushHandler.sendMessageToUser(userId,textMessage);
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
