package com.demo.springdemo;
import org.springframework.stereotype.Component;

//default component name
//default bean id will be baseballCoach
@Component
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice batting";
    }
}