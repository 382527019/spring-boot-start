package com.example.conditions;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IDEA
 * author:YunGui Hhuang
 * Date:2022/12/10
 * Time:20:56
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        context.getBean(ConditionService.class);
    }

}
