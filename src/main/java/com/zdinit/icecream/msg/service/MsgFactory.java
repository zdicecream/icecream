package com.zdinit.icecream.msg.service;

import com.alibaba.fastjson.JSON;
import com.zdinit.icecream.msg.entity.AbstractMsg;
import com.zdinit.icecream.msg.entity.Msg001;
import com.zdinit.icecream.sys.entity.Role;

import java.time.LocalDateTime;

public class MsgFactory {

    public static AbstractMsg createMsg(String msgCode) {
        AbstractMsg msg = initMsg(msgCode);
        initMsgHead(msg,msgCode);
        return msg;
    }

    private static AbstractMsg initMsg(String msgCode) {
        switch (msgCode){
            case MsgCommonValue.MSG001 :
                Msg001 msg = new Msg001();
                return msg;
            default:
                return null;
        }
    }
    private static void initMsgHead(AbstractMsg msg,String msgCode) {
        msg.setMsgCode(msgCode);
        msg.setId(112131312l);
        msg.setCreateTime(LocalDateTime.now());
        msg.setMsgId("1231313123");
        msg.setState(1);
    }

    public static AbstractMsg convert(String msgCode,JSON json){

        switch (msgCode){
            case MsgCommonValue.MSG001 :
                return JSON.toJavaObject(json,Msg001.class);
            default:
                return null;
        }
    }
}
