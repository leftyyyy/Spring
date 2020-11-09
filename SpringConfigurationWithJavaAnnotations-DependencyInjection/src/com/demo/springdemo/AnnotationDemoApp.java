package com.demo.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        //read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //get the bean from spring container
        Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
        Coach theCricketCoach = context.getBean("cricketCoach", Coach.class);

        //call a method on the bean
        System.out.println(theCoach.getDailyWorkout());

        //call method to get the daily fortune
        System.out.println(theCoach.getDailyFortune());

        //field injection checker
        System.out.println();
        System.out.println(theCricketCoach.getDailyWorkout());
        System.out.println(theCricketCoach.getDailyFortune());
        System.out.println("Field injection working just fine");

        //close the context
        context.close();
    }
}
