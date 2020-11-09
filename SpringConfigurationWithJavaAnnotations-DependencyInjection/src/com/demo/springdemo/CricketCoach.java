package com.demo.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Autowired
    @Qualifier("RESTFortuneService")
    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "practice bowling nigga";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
