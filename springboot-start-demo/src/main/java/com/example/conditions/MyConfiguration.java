package com.example.conditions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IDEA
 * author:YunGui Hhuang
 * Date:2022/12/10
 * Time:20:44
 */
//@Configuration => 声明bean 装载到IOC
@Configuration
public class MyConfiguration {

    /**
     * 在某环境 或不满足条件时 或已经装载过 =》
     * @conditional 条件装载(Class<? extends Condition>[] value());
     *  =》MyCondition.class实现 interface Condition
     */
    @Conditional(MyCondition.class)
    @Bean
    public ConditionService conditionService(){
        return new ConditionService();
    }
}
