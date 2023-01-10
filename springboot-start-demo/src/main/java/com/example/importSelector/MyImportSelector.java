package com.example.importSelector;

import com.example.onetemplate.OneConfiguration;
import com.example.twotemplate.TwoConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
实现ImportSelector接口 批量扫描配置类
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //动态导入bean ，告诉IOC 配置类在哪里
        return new String[]{OneConfiguration.class.getName(), TwoConfiguration.class.getName()};
    }
}
