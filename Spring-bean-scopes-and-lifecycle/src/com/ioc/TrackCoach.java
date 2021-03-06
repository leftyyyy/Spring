package com.ioc;

public class TrackCoach implements Coach {

    //define a private field for dependency Injection
    private FortuneService fortuneService;

    //define constructor for dependency injection
    public TrackCoach(FortuneService theFortuneService){
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkOut() {
        return "Run 5KM";
    }

    @Override
    public String getDailyFortune() {
        //use my fortune service to get a fortune
        return fortuneService.getFortune();
    }

    //add an init method
    public void doMyStartupStuff(){
        System.out.println("inside init method");
    }

    //add a destroy method
    public void doMyCleanupStuff(){
        System.out.println("inside destroy method");
    }
}
