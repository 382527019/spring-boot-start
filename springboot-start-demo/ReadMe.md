##### @condition条件装配
* 实现 interface Condition
~~~
package com.example.conditions

    @Conditional(MyCondition.class)
    @Bean
    public ConditionService conditionService(){
        return new ConditionService(); }
~~~

###2.Spring IOC Bean的装载
* IOC bean 的装载
  * .xml | @configuration | @Enable
* spring IOC 动态装载
  * ImportSelector: DeferredImportSelector
  * Registator: ImportBeanDefinitionRegistrar
##### 2.1 spring IOC 批量扫描配置类
  1. 实现 ImportSelector接口
~~~
  package com.example.importSelector;
  
    public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //动态导入bean ，告诉IOC 配置类在哪里
        return new String[]{OneConfiguration.class.getName(), TwoConfiguration.class.getName()};
    }
        }
~~~
  2.启动 `package com.example.boot;` @EnableConfiguration
~~~
@EnableConfiguration //==>@Import(MyImportSelector.class)
@SpringBootApplication
public class StartDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(StartDemoApplication.class, args);
        System.out.println(run.getBean(OneTemplate.class));
        System.out.println(run.getBean(TwoTemplate.class));
    }
}
~~~
##### 2.2 SpringFactoriesLoader(SPI)
* spring规范 扫描 classpath:META-INF/spring.factories文件=》声明配置类在哪里 
     1. 启动 `@SpringBootApplication`
     2. `@EnableAutoConfiguration =》@Import({AutoConfigurationImportSelector.class})`
     3. 在 `AutoConfigurationImportSelector.class 实现DeferredImportSelector接口  selectImports()`方法
     4. getAutoConfigurationEntry=》拿到配置类 ：`List<String> configurations = this.getCandidateConfigurations(annotationMetadata, attributes);`

* SPI机制
  * 需要要classpath目录下创建一个META-INF/services
  * 在该目录下创建一个扩展点的全路径名
    * 文件中填写这个扩展点实现
    * UTF-8
    * ServiceLoader去进行加载
#### 3 自定义组件使用
~~~
<groupId>com.example</groupId>
<artifactId>meComponent-spring-boot-start</artifactId>
<version>0.0.1-SNAPSHOT</version>
~~~

### 4 actuator 监控
~~~
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
~~~
* Production-ready Features
  * https://docs.spring.io/spring-boot/docs/2.7.6/reference/html/actuator.html#actuator
  * Endpoints 执行器端点允许您监视应用程序并与之交互。Spring Boot包括许多内置端点，并允许您添加自己的端点。例如，运行状况端点提供基本应用程序运行状况信息。