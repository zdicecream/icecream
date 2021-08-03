package com.zdinit.icecream.msg.service.impl;

import com.zdinit.icecream.msg.entity.AbstractMsg;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Msg001HandleImpl extends AbstractMsgHandle{

    @Override
    public void handle(AbstractMsg msg) {
        log.info("处理报文001");
    }
}
