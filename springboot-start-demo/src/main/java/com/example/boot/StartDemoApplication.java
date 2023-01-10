package com.example.boot;

import com.example.importSelector.EnableConfiguration;
import com.example.importSelector.MyImportSelector;
import com.example.onetemplate.OneTemplate;
import com.example.twotemplate.TwoTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@EnableConfiguration //==>@Import(MyImportSelector.class)
@SpringBootApplication
public class StartDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(StartDemoApplication.class, args);
        System.out.println(run.getBean(OneTemplate.class));
        System.out.println(run.getBean(TwoTemplate.class));
    }
}
