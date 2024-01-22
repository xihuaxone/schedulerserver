package com.xihua.schedulerserver.common.netty;

import com.xihua.nettym.common.handler.ReqHandleHandler;
import com.xihua.schedulerserver.common.netty.handlers.LocalCmdHandler;
import com.xihua.schedulerserver.common.netty.handlers.SayHiHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyServer {

    private final Logger logger = LoggerFactory.getLogger(NettyServer.class);

    public void init(int port) throws InterruptedException {
        ReqHandleHandler.registerReqHandler("sayHi", SayHiHandler.class);
        ReqHandleHandler.registerReqHandler("localCmd", LocalCmdHandler.class);

        logger.info("start server with port={}", port);
        com.xihua.nettym.server.NettyServer.start(port);
    }
}
