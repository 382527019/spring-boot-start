package com.example.conditions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * 属性条件注解：@ConditionalOnProperty
 * https://blog.csdn.net/qq_42145871/article/details/118310230
 */
@ConditionalOnProperty(name = "condition.enable", havingValue = "true")
@Configuration
public class ConditionalOn {
    private static final Logger logger = LoggerFactory.getLogger(ConditionalOn.class);

    //注入
    public ConditionalOn(){
        logger.info("load ConditionlOn.Class");
    }
}
