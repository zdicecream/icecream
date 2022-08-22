package com.zdinit.icecream.msg.service.impl;

import com.zdinit.icecream.msg.entity.AbstractMsg;
import com.zdinit.icecream.msg.entity.Cim001;
import com.zdinit.icecream.msg.service.AbstractMsgHandle;
import com.zdinit.icecream.msg.service.MsgHandles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Cim001HandleImpl extends AbstractMsgHandle {
    @Override
    public void handle(AbstractMsg msg) {
        Cim001 cim001 = (Cim001) msg;
        log.info("原报文id："+cim001.getOriginalMsgId());
        String originalMsgCode = "msg001";

        MsgHandles.getHandle(originalMsgCode+msg.getMsgCode().substring(0,1).toUpperCase()+msg.getMsgCode().substring(1)).receive(msg);
    }
}
