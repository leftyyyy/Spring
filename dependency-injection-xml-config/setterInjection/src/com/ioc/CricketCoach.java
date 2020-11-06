package com.ioc;

public class CricketCoach implements Coach {
    private FortuneService fortuneService;


    //create a no-arg constructor
    public CricketCoach(){
        System.out.println("CricketCoach: inside no-arg constructor");
    }


    //setter method for setter injection
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("Inside setter method of CricketCoach");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkOut() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
