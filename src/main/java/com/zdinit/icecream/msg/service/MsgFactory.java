package com.zdinit.icecream.msg.service;

import com.alibaba.fastjson.JSON;
import com.zdinit.icecream.msg.entity.AbstractMsg;
import com.zdinit.icecream.msg.entity.Msg001;
import com.zdinit.icecream.msg.entity.Msg002;

import java.time.LocalDateTime;

public class MsgFactory {

    public static AbstractMsg createMsg(String msgCode) {
        AbstractMsg msg = null;
        switch (msgCode){
            case MsgCommonValue.MSG001 :
                msg = new Msg001();
                break;
            case MsgCommonValue.MSG002 :
                msg = new Msg002();
                break;
            default:
        }
        msg.setMsgCode(msgCode);
        msg.setId(112131312L);
        msg.setCreateTime(LocalDateTime.now());
        msg.setMsgId("1231313123");
        msg.setState(1);
        return msg;
    }

    public static AbstractMsg convert(String msgCode,JSON json){

        ClassLoader classLoader = MsgFactory.class.getClassLoader();
        Class<AbstractMsg> c = null;
        try {
            c = (Class<AbstractMsg>) classLoader.loadClass("com.zdinit.icecream.msg.entity."+msgCode.substring(0, 1).toUpperCase()+msgCode.substring(1));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return JSON.toJavaObject(json,c);

    }
}
