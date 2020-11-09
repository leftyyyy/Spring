package com.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        //load the spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve bean from spring container
        Coach theBaseBallCoach = context.getBean("myBaseBallCoach", Coach.class);

        Coach theTrackCoach = context.getBean("myTrackCoach", Coach.class);

        //call methods on bean
        System.out.println(theBaseBallCoach.getDailyWorkOut());
        System.out.println();
        System.out.println(theTrackCoach.getDailyWorkOut());

        //close context
        context.close();
    }
}
