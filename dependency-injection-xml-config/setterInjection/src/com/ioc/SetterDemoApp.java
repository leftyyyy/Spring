package com.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {
        //load config
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve bean
        //Coach theCricketCoach = context.getBean("myCricketCoach", Coach.class);
        CricketCoach theCricketCoach = context.getBean("myCricketCoach", CricketCoach.class);


        //call bean methods
        System.out.println(theCricketCoach.getDailyWorkOut());
        System.out.println(theCricketCoach.getDailyFortune());
        System.out.println("setter injection working");

        //test injection of literal values
        System.out.println(theCricketCoach.getEmailAddress());
        System.out.println(theCricketCoach.getTeam());

        /*
        Note that when using
        Coach theCricketCoach = context.getBean("myCricketCoach", Coach.class);

        you won't be able to find email and team.
        Because it's of reference Coach, and Coach interface doesn't have those methods
         */

        //close context
        context.close();
    }
}
