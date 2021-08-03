package com.zdinit.icecream.msg.service;

import com.zdinit.icecream.msg.entity.AbstractMsg;
import com.zdinit.icecream.msg.service.impl.AbstractMsgHandle;
import com.zdinit.icecream.msg.service.impl.Msg001HandleImpl;
import com.zdinit.icecream.msg.service.impl.Msg002HandleImpl;

public class MsgHandleFactory {
    public static AbstractMsgHandle getHandle(AbstractMsg msg){
        switch (msg.getMsgCode()){
            case MsgCommonValue.MSG001 :
                return new Msg001HandleImpl();
            case MsgCommonValue.MSG002 :
                return new Msg002HandleImpl();
            default:
               return null;
        }
    }
}
