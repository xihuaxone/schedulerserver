package com.xihua.schedulerserver.controller;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.history.HistoricDetail;
import org.activiti.engine.history.HistoricVariableUpdate;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/demo")
@RestController
public class DemoController {
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private HistoryService historyService;

    @PostMapping(value = "runDemoProcess")
    public String runDemoProcess() {
        ProcessInstance demoProcess = runtimeService.startProcessInstanceByKey("demoProcess");
        return demoProcess.getProcessInstanceId();
    }

    @GetMapping(value = "query")
    public Map<String, Object> query(@RequestParam String pid) {
        Map<String, Object> variables = new HashMap<>();
        List<HistoricDetail> list = historyService.createHistoricDetailQuery()
                .processInstanceId(pid).list();
        list.forEach(v -> {
            HistoricVariableUpdate var = (HistoricVariableUpdate) v;
            variables.put(var.getVariableName(), var.getValue());
        });
        return variables;
    }
}
