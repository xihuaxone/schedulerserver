package com.xihua.schedulerserver;


import com.xihua.schedulerserver.service.activiti.ActivitiInitializer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {"com.xihua.schedulerserver"})
@MapperScan("com.xihua.schedulerserver.dal")
@EnableTransactionManagement
public class Application implements ApplicationContextAware {
    private static ApplicationContext CONTEXT;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        ActivitiInitializer activitiInitializer = CONTEXT.getBean(ActivitiInitializer.class);
        activitiInitializer.init();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CONTEXT = applicationContext;
    }
}
