package car.example.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class app {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationBeanContext.xml");

        MyBean bean = (MyBean) context.getBean("myBean");

        System.out.println(bean);
    }
}