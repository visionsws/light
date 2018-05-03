package com.vicente.light.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author shiweisen
 * @since 2018-02-02
 */
@Component
public class SchedulerTask {

    private int count=0;

    @Scheduled(cron="*/6 * * * * ?")
    public void printLog(){
        System.out.println("this is scheduler task runing  "+(count++));
    }

    @Scheduled(fixedRate = 6000)
    public void printLog2(){
        System.out.println("run2 XXXXXXXXXXXXXXXXXXXX  "+(count++));
    }
}
