# schedulerserver

# 客户端：
### 客户端执行本地脚本的handler：com.xihua.schedulerserver.common.netty.handlers.LocalCmdHandler （服务端默认不需要注册该handler，客户端注册，服务端调用）

# 服务端： 
## activiti：
##### 配置文件：com.xihua.schedulerserver.common.config.ActivitiConfig
##### 初始化（注册bpmn）：com.xihua.schedulerserver.service.activiti.ActivitiInitializer.init
##### activiti是否保留历史工作流实例的上下文：org.activiti.engine.ProcessEngineConfiguration.setHistory
##### web创建/查询工作流的演示api：com.xihua.schedulerserver.controller.DemoController

## netty:
##### nettyserver启动（默认随spring启动而启动）：com.xihua.schedulerserver.common.netty.NettyServer.init
##### nettyclient的使用：参考nettym项目的对应测试类