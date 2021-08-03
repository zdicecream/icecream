package com.zdinit.icecream.msg.service;

import com.alibaba.fastjson.JSON;
import com.zdinit.icecream.msg.entity.AbstractMsg;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MsgSendManager {
    public static void send(AbstractMsg msg){

        StringBuffer msgJson = new StringBuffer();
        msgJson.append(msg.getMsgCode()+MsgCommonValue.MSGSPLIT);
        msgJson.append(JSON.toJSON(msg));


        log.info("发送:"+msgJson.toString());
    }

}
