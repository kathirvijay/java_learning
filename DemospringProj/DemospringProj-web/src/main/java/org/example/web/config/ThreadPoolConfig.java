package org.example.web.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Slf4j
@EnableAsync
@Configuration
//@EnableConfigurationProperties(ThreadPoolConfig.ThreadPoolConfigProperties.class)
public class ThreadPoolConfig {

    @Bean
    @ConditionalOnMissingBean(ThreadPoolExecutor.class)
    public ThreadPoolExecutor threadPoolExecutor(ThreadPoolConfig.ThreadPoolConfigProperties properties) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 实例化策略
        RejectedExecutionHandler handler;
        switch (properties.getPolicy()){
            case "AbortPolicy":
                handler = new ThreadPoolExecutor.AbortPolicy();
                break;
            case "DiscardPolicy":
                handler = new ThreadPoolExecutor.DiscardPolicy();
                break;
            case "DiscardOldestPolicy":
                handler = new ThreadPoolExecutor.DiscardOldestPolicy();
                break;
            case "CallerRunsPolicy":
                handler = new ThreadPoolExecutor.CallerRunsPolicy();
                break;
            default:
                handler = new ThreadPoolExecutor.AbortPolicy();
                break;
        }
        // 创建线程池
        return new ThreadPoolExecutor(properties.getCorePoolSize(),
                properties.getMaxPoolSize(),
                properties.getKeepAliveTime(),
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(properties.getBlockQueueSize()),
                Executors.defaultThreadFactory(),
                handler);
    }

    @Data
    @Component
    @ConfigurationProperties(prefix = "thread.pool.executor.config", ignoreInvalidFields = true)
    public static class ThreadPoolConfigProperties {

        /** 核心线程数 */
        private Integer corePoolSize = 20;
        /** 最大线程数 */
        private Integer maxPoolSize = 200;
        /** 最大等待时间 */
        private Long keepAliveTime = 10L;
        /** 最大队列数 */
        private Integer blockQueueSize = 5000;
        /*
         * AbortPolicy：丢弃任务并抛出RejectedExecutionException异常。
         * DiscardPolicy：直接丢弃任务，但是不会抛出异常
         * DiscardOldestPolicy：将最早进入队列的任务删除，之后再尝试加入队列的任务被拒绝
         * CallerRunsPolicy：如果任务添加线程池失败，那么主线程自己执行该任务
         * */
        private String policy = "AbortPolicy";

    }

}
