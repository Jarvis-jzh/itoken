package person.jzh.itoken.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author jzh
 * @date 2019/10/21 18:09
 * @description 异步线程配置
 */
//@EnableAsync // 开启对异步任务的支持
//@Configuration
//@EnableScheduling
public class ThreadAsyncConfig {

    @Bean
    public Executor getAsyncExecutor(){
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        threadPool.setCorePoolSize(20);
        // 设置最大线程数
        threadPool.setMaxPoolSize(100);
        // 线程池所使用的缓冲队列
        threadPool.setQueueCapacity(20);
        // 等待任务在关机时完成 -- 表明等待所有线程执行完
        threadPool.setWaitForTasksToCompleteOnShutdown(true);
        // 等待时间（默认为0，此时立即停止）,并没等待xx秒后强制停止
        threadPool.setAwaitTerminationSeconds(5);
        threadPool.setWaitForTasksToCompleteOnShutdown(true);
        // 初始化线程
        threadPool.initialize();
        return threadPool;
    }
}
