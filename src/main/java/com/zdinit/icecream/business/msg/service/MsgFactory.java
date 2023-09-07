package com.zdinit.icecream.business.msg.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zdinit.icecream.business.msg.entity.AbstractMsg;
import com.zdinit.icecream.business.msg.entity.Cim001;
import com.zdinit.icecream.business.msg.entity.Msg001;
import com.zdinit.icecream.business.msg.entity.Msg002;

import java.time.LocalDateTime;

public class MsgFactory {

    public static AbstractMsg createMsg(String msgCode) {
        if (msgCode == null) {
            throw new RuntimeException("msgCode is null");
        }
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

    public static AbstractMsg convert(String msgCode,String json){
          //fastjson 用法
        ClassLoader classLoader = MsgFactory.class.getClassLoader();
        Class<AbstractMsg> c = null;
        try {
            c = (Class<AbstractMsg>) classLoader.loadClass("com.zdinit.icecream.business.msg.entity."+msgCode.substring(0, 1).toUpperCase()+msgCode.substring(1));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return JSON.parseObject(json,c);

//        ObjectMapper objectMapper = new ObjectMapper();
//        ClassLoader classLoader = MsgFactory.class.getClassLoader();
//        Class<AbstractMsg> c = null;
//        AbstractMsg abstractMsg = null;
//        try {
////            c = (Class<AbstractMsg>) classLoader.loadClass("com.zdinit.icecream.business.msg.entity."+msgCode.substring(0, 1).toUpperCase()+msgCode.substring(1));
//            // 将JSON字符串转换为对象
//            abstractMsg = objectMapper.readValue(json, Cim001.class);
//            System.out.println(abstractMsg);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return abstractMsg;
    }
}
