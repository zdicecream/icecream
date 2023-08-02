package com.zdinit.icecream;

import com.alibaba.fastjson.JSON;
import com.zdinit.icecream.business.msg.entity.AbstractMsg;
import com.zdinit.icecream.business.msg.entity.Msg001;
import com.zdinit.icecream.business.msg.service.MsgCommonValue;
import com.zdinit.icecream.business.msg.service.MsgFactory;
import com.zdinit.icecream.business.msg.service.MsgHandles;
import com.zdinit.icecream.business.msg.service.MsgSendManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IcecreamApplicationTests {

	@Test
	void contextLoads() {
		Msg001 msg1 = (Msg001) MsgFactory.createMsg(MsgCommonValue.MSG001);
		msg1.setNb("1212");
		MsgSendManager.send(msg1);

		String msgText = "cim001~{\"createTime\":\"2021-07-30T17:31:10.002\",\"msgId\":\"1231313123\",\"id\":112131312,\"state\":1,\"msgCode\":\"cim001\",\"originalMsgId\":\"3332\"}";
		String[] msgString = msgText.split(MsgCommonValue.MSGSPLIT);
		String msgCode = msgString[0];
		JSON json = (JSON) JSON.parse(msgString[1]);

		AbstractMsg msg = MsgFactory.convert(msgCode,json);

		MsgHandles.getHandle(msgCode).receive(msg);
	}

}
