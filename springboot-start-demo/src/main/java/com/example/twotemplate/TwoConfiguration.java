package com.example.twotemplate;

import com.example.conditions.ConditionService;
import com.example.conditions.MyCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
//要扫描的配置类
@Configuration
public class TwoConfiguration {
    @Bean
    public TwoTemplate twoTemplate(){
        System.out.println("===装配TwoTemplate");
        return new TwoTemplate();
    }
}
