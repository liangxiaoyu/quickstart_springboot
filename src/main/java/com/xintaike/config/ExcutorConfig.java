package com.xintaike.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created by jay on 2020/4/1.
 */
@Configuration
@EnableAsync
public class ExcutorConfig {



    @Value("${async.core_pool_size}")
    private int corePoolSize;
    @Value("${async.max_pool_size}")
    private int maxPoolSize;
    @Value("${async.queue_capacity}")
    private int queueCapacity;
    @Value("${async.keep_alive_seconds}")
    private int keepAliveSeconds;
    @Value("${async.thread_name_prefix}")
    private String ThreadNamePrefix;

    /*通过Bean名称来指定调用的线程池-比如上例中设置的线程池参数不满足业务需求，
    可以另外定义合适的线程池，调用时指明使用这个线程池-缺省时springboot会优先使用名称为'taskExecutor'的线程池，
    如果没有找到，才会使用其他类型为TaskExecutor或其子类的线程池。*/
    @Bean("taskExecutor")
    public Executor getExecutor(){

        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(corePoolSize);
        taskExecutor.setMaxPoolSize(maxPoolSize);
        taskExecutor.setQueueCapacity(queueCapacity);
        taskExecutor.setKeepAliveSeconds(keepAliveSeconds);
        taskExecutor.setThreadNamePrefix(ThreadNamePrefix);
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        taskExecutor.setAwaitTerminationSeconds(60);
        taskExecutor.setRejectedExecutionHandler((r, executor) -> System.out.println("异常处理接口") );
        return taskExecutor;

    }
}
