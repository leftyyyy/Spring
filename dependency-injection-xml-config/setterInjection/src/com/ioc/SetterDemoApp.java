package com.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {
        //load config
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve bean
        Coach theCricketCoach = context.getBean("myCricketCoach", Coach.class);
        //CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);


        //call bean methods
        System.out.println(theCricketCoach.getDailyWorkOut());
        System.out.println(theCricketCoach.getDailyFortune());
        System.out.println("setter injection working");

        //close context
        context.close();
    }
}
