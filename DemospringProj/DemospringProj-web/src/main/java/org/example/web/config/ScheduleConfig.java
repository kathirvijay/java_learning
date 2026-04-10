package org.example.web.config;

import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.UUID;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

@EnableScheduling
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        // 开启一个线程调度池
        ThreadPoolTaskScheduler taskScheduler = new CustomerThreadPoolTaskScheduler();
        // 设置线程池大小为 1 ：防止多个定时任务并发执行
        taskScheduler.setPoolSize(1);
        taskScheduler.initialize();
        taskRegistrar.setTaskScheduler(taskScheduler);
    }

    public static class CustomerThreadPoolTaskScheduler extends ThreadPoolTaskScheduler {
        @Override
        protected ScheduledExecutorService createExecutor(int poolSize, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
            return new CustomerScheduledExecutorService(poolSize, threadFactory, rejectedExecutionHandler);
        }
    }
    public static class CustomerScheduledExecutorService extends ScheduledThreadPoolExecutor {
        @Override
        protected void beforeExecute(Thread t, Runnable r) {
            // 执行前绑定链路追踪ID到线程上下文
            MDC.put("x-trace-id", UUID.randomUUID().toString().replace("-",""));
        }
        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            // 执行后清除链路追踪ID
            MDC.remove("x-trace-id");
        }
        public CustomerScheduledExecutorService(int corePoolSize, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
            super(corePoolSize, threadFactory, handler);
        }
    }
}
