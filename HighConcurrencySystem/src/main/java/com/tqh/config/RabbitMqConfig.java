package com.tqh.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Mcorleon
 * @Date 2019/2/26 21:19
 */
@Configuration
public class RabbitMqConfig {
    public static final String DIRECT_QUEUE = "DIRECT_QUEUE";
    /**
     * Direct模式
     * @return
     */
    @Bean
    public Queue directQueue() {
        // 第一个参数是队列名字， 第二个参数是指是否持久化
        return new Queue(DIRECT_QUEUE);
    }

}
