package com.autowired.annotation;

import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Employee employee = context.getBean("employee", Employee.class);

        Manager manager = context.getBean("manager", Manager.class);
        System.out.println(employee.toString());
        logger.info(employee.toString());

    }
}
