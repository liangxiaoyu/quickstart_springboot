package com.xintaike.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by jay on 2020/4/1.
 */
@Component
public class AsyncService {

    @Async("taskExecutor")
    public void asyncCall(){
        System.out.println(Thread.currentThread().getName());
    }
}
