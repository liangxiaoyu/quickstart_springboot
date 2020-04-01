package com.xintaike.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by jay on 2020/4/1.
 */
@Component
@EnableScheduling
public class SchedulingService {

//    @Scheduled(cron = "*/2 * * * * ?")
    @Scheduled(cron = "${Scheduled_cron}")
    public void ScheduledService(){
//        System.out.println("ScheduledService");
    }
}
