package com.xihua.schedulerserver.service.activiti.tasks;

import com.alibaba.fastjson.JSON;
import org.activiti.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DemoTask {
    private final Logger logger = LoggerFactory.getLogger(DemoTask.class);

    public void action1(DelegateExecution execution) {
        logger.info("start action1 with {}", JSON.toJSONString(execution.getVariables()));

        execution.setVariable("action1", "ok");

        logger.info("end action1 with {}", JSON.toJSONString(execution.getVariables()));
    }

    public void action2(DelegateExecution execution) {
        logger.info("start action2 with {}", JSON.toJSONString(execution.getVariables()));

        execution.setVariable("action2", "ok");

        logger.info("end action2 with {}", JSON.toJSONString(execution.getVariables()));
    }
}
