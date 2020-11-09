package com.demo.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        //read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //get the bean from spring container
        Coach theCoach = context.getBean("thatSillyCoach", Coach.class);

        //get the bean with default bean id
        Coach theBaseballCoach = context.getBean("baseballCoach", Coach.class);
        //call a method on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theBaseballCoach.getDailyWorkout());

        //close the context
        context.close();
    }
}
