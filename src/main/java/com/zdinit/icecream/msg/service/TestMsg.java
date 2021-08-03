package com.zdinit.icecream.msg.service;

import com.alibaba.fastjson.JSON;
import com.zdinit.icecream.msg.entity.AbstractMsg;
import com.zdinit.icecream.msg.entity.Msg001;
import com.zdinit.icecream.msg.service.impl.AbstractMsgHandle;
import com.zdinit.icecream.msg.service.impl.Msg001HandleImpl;
import springfox.documentation.spring.web.json.Json;
import sun.util.calendar.LocalGregorianCalendar;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

public class TestMsg {
    public static void main(String[] args) {

/*        String year = "2022";
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(year), 0, 0);
        Calendar c2 = Calendar.getInstance();
        c2.set(Integer.parseInt(year) + 1, 0, 0);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        while (c.compareTo(c2) < 0) {
            if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                System.out.println(format.format(c.getTime()));
            }
            // 日期+1
            c.add(Calendar.DATE, 1);
        }*/
        new TestMsg().send();
        new TestMsg().receive();

    }

    private void send(){
        AbstractMsg msg = MsgFactory.createMsg(MsgCommonValue.MSG001);
        msg.setMsgCode(MsgCommonValue.MSG001);
        msg.setId(112131312l);
        msg.setCreateTime(LocalDateTime.now());
        msg.setMsgId("1231313123");
        msg.setState(1);
        MsgSendManager.send(msg);
    }

    private void receive(){
        String msgText = "msg001~{\"createTime\":\"2021-07-30T17:31:10.002\",\"msgId\":\"1231313123\",\"id\":112131312,\"state\":1,\"msgCode\":\"msg001\"}";
        String[] msgString = msgText.split(MsgCommonValue.MSGSPLIT);
        String msgCode = msgString[0];
        JSON json = (JSON) JSON.parse(msgString[1]);

        AbstractMsg msg = MsgFactory.convert(msgCode,json);

        AbstractMsgHandle msgHandle = MsgHandleFactory.getHandle(msg);
        msgHandle.receive(msg);
    }
}
