package com.xihua.schedulerserver.controller;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/demo")
@RestController
public class DemoController {
    @Autowired
    private RuntimeService runtimeService;

    @PostMapping(value = "runDemoProcess")
    public String runDemoProcess() {
        ProcessInstance demoProcess = runtimeService.startProcessInstanceByKey("demoProcess");
        return demoProcess.getProcessInstanceId();
    }
}
