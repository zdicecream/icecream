package com.zdinit.icecream.msg.service;

import com.zdinit.icecream.msg.entity.AbstractMsg;

/**
 * msg处理通用接口
 */
public interface IMsgHandle {

    void receive(AbstractMsg msg);

    void handle(AbstractMsg msg);
}
