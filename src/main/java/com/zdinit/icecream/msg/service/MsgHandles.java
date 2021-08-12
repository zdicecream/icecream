package com.zdinit.icecream.msg.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@Component
public class MsgHandles implements ApplicationContextAware {

    private static Map<String,IMsgHandle> msgHandleMap = new HashMap<>();

    public static IMsgHandle getHandle(String msgCode){
        return msgHandleMap.get(msgCode+"HandleImpl");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        msgHandleMap = applicationContext.getBeansOfType(IMsgHandle.class);
        log.info("已加载报文处理类： "+msgHandleMap.keySet().toString());
    }
}
