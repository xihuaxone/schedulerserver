package com.xihua.schedulerserver.service.activiti;

import org.activiti.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivitiInitializer {
    @Autowired
    RepositoryService repositoryService;

    public void init() {
        repositoryService.createDeployment().addClasspathResource("bpmns/demo.bpmn").name("demo").deploy();
    }
}
