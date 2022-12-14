package com.example.mecomponent.Meconfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * 通过@enableconfigationproperties注册，标记为Spring组件
 * 或通过@ConfigurationPropertiesScan扫描
 */
@ConfigurationProperties(prefix ="me.redisson")
public class RedissonProperties {
    private String host ;
    private int port;
    private String password;
    private int timeout;
    private boolean ssl;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
