package com.example.mecomponent.Meconfiguration;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IDEA
 * author:YunGui Hhuang
 * Date:2022/12/11
 * Time:11:08
 */
@ConditionalOnClass(Redisson.class)
@EnableConfigurationProperties(RedissonProperties.class)
@Configuration
public class RedissonAutoConfiguration {
    @Bean
    RedissonClient redissonClient(RedissonProperties redissonProperties) {
        Config config = new Config();
        String prefix = "redis://";
        if (redissonProperties.isSsl()){
            prefix = "rediss://";
        }
        System.out.println("扫描到配置类-》加载配置，我的组件");
        config.useSingleServer()
                .setAddress(prefix + redissonProperties.getHost() + ":" + redissonProperties.getPort())
                .setPassword(redissonProperties.getPassword())
                .setConnectTimeout(redissonProperties.getTimeout());
        return Redisson.create(config);
    }
}
