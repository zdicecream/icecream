package com.zdinit.icecream.common.task;

import com.zdinit.icecream.bankinterface.client.NettyClient;
import com.zdinit.icecream.bankinterface.handle.NettyServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sun.security.krb5.internal.NetClient;

@Component
@Order(3)
@Slf4j
public class ServerRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        NettyServer nettyServer = new NettyServer();
        log.info("Netty接口服务端启动");
        nettyServer.start();
    }
}
