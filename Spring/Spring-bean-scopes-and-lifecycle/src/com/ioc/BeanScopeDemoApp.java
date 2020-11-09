package com.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        // load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");


        // retrieve bean from spring container
        /*
        Coach theCoach = context.getBean("myBaseBallCoach", Coach.class);
        Coach alphaCoach = context.getBean("myBaseBallCoach", Coach.class);
         */

        Coach theCoach = context.getBean("myTrackCoach", Coach.class);
        Coach alphaCoach = context.getBean("myTrackCoach", Coach.class);
        //check if they are the same
        boolean result = (theCoach == alphaCoach);

        if(result){
            System.out.println("both beans are same i.e. Scope is Singleton or default (which is also singleton)");
            System.out.println("Memory location for theCoach: "+theCoach);
            System.out.println("Memory location for alphaCoach: "+alphaCoach);
        }else{
            System.out.println("both beans are not same i.e. Scope is not Singleton or default");
            System.out.println("Scope is prototype");
            System.out.println("Memory location for theCoach: "+theCoach);
            System.out.println("Memory location for alphaCoach: "+alphaCoach);
        }
    }
}
