package com.ioc;

public class CricketCoach implements Coach {
    private FortuneService fortuneService;

    //set up private field for literals
    private String emailAddress;
    private String team;

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

    //generate setter methods for those literals

    public void setEmailAddress(String emailAddress) {
        System.out.println("Inside setEmailAddress");
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        System.out.println("Inside setTeam");
        this.team = team;
    }

    //to print and test also generate getters

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }
}
