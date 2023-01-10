package com.example.onetemplate;

import com.example.conditions.ConditionService;
import com.example.conditions.MyCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
//要扫描的配置类
@Configuration
public class OneConfiguration {
    @Bean
    public OneTemplate oneTemplate(){
        System.out.println("===装配OneTemplate");
        return new OneTemplate();
    }
}
