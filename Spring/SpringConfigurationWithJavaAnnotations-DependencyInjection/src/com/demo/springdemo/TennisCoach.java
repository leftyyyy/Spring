package com.demo.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    //define a default constructor
    public TennisCoach(){
        System.out.println("inside tennis default cons");
    }
    /*
    @Autowired
    public TennisCoach(FortuneService theFortuneService){
        fortuneService = theFortuneService;
    }

     */

    @Autowired
    @Qualifier("randomService")
    public void setFortuneService(FortuneService theFortuneService){
        System.out.println("inside setter method (setter injection)");
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    /*
    @Autowired
    public void doCrazyStuff(){
        System.out.println("I'm doing someCrazyStuff");
    }
    
     */
}
