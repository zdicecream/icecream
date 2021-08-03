package com.zdinit.icecream.msg.service;

import com.alibaba.fastjson.JSON;
import com.zdinit.icecream.msg.entity.AbstractMsg;
import com.zdinit.icecream.msg.entity.Msg001;
import com.zdinit.icecream.sys.entity.Role;

public class MsgFactory {

    public static AbstractMsg createMsg(String msgCode){
        return new Msg001();
    }
    public static AbstractMsg createMsg(String msgCode, Role role){
        return new Msg001();
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
