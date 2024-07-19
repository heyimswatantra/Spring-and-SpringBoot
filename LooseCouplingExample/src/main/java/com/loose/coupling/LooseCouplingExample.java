package com.loose.coupling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LooseCouplingExample {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationSpringPractice.xml");

        UserManager userManagerPractice = (UserManager)context.getBean("manager");

        System.out.println(userManagerPractice.getUserInfo());

//
//        //interface's object
//        UserDataProvider userDataProvider = new UserDBProvider();
//
//        UserManager userManagerWithDB = new UserManager(userDataProvider);
//        System.out.println(userManagerWithDB.getUserInfo());
//
//        //create reference var of interface and assign it and obj of the implementation class;
//        UserDataProvider webSerProvider = new WebServiceDataProvider();
//        UserManager userManagerWebService = new UserManager(webSerProvider);
//        System.out.println(userManagerWebService.getUserInfo());
    }
}
