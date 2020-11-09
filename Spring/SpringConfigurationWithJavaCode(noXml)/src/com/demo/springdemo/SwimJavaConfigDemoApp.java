package com.demo.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        //get the bean from spring container
        SwimCoach theSwimCoach = context.getBean("swimCoach", SwimCoach.class);

        //call a method on the bean
        System.out.println(theSwimCoach.getDailyWorkout());

        //call method to get the daily fortune
        System.out.println(theSwimCoach.getDailyFortune());

        System.out.println(theSwimCoach.getEmail());
        System.out.println(theSwimCoach.getTeam());

        //close the context
        context.close();
    }
}
