#### xxx-spring-boot-start 组件自动装配
##### 1. 引入jar

        <dependency>
            <groupId>org.redisson</groupId>
            <artifactId>redisson</artifactId>
            <version>3.18.1</version>
        </dependency>
##### 2. 配置bean
~~~
package com.example.mecomponent.Meconfiguration;

@ConditionalOnClass(Redisson.class)
@EnableConfigurationProperties(RedissonProperties.class)
@Configuration
public class RedissonAutoConfiguration {
~~~
##### 3.配置属性
~~~
package com.example.mecomponent.Meconfiguration;
/
 * 通过@enableconfigationproperties注册，标记为Spring组件
 * 或通过@ConfigurationPropertiesScan扫描
 */
@ConfigurationProperties(prefix ="me.redisson")
public class RedissonProperties {
~~~
##### 4.spring扫描
* META-INF/spring.factories告诉spring要扫描的配置类
~~~
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
com.example.mecomponent.Meconfiguration.RedissonAutoConfiguration
~~~

##### 5.配置提示
1. ~~~
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <version>2.7.6</version>
        </dependency>
   ~~~
2. 编写文件 META-INF/additional-spring-configuration-metadata.json
~~~
{
  "properties": [
    {
      "name": "me.redisson.host",
      "type": "java.lang.String",
      "description": "xxx",
      "defaultValue": "xxx"
    }
  ]
}
~~~