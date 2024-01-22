package com.xihua.schedulerserver.common.config;

import com.xihua.schedulerserver.common.netty.NettyServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    @Value("${nettyServer.port}")
    private int nettyServerPort;

    @Bean
    public NettyServer nettyServer() throws InterruptedException {
        NettyServer nettyServer = new NettyServer();
        nettyServer.init(nettyServerPort);
        return nettyServer;
    }
}
