package com.pushkin.register.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/5/24 22:19
 * <p>
 *
 *
 *
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
@Component
@ConfigurationProperties(prefix = "spring.registry.zookeeper")
public class RegistryProperties {
    private String zkAddress;

    /**
     * 如果是服务端--> 服务注册; 不是->服务发现
     */
    private boolean server;

    public String getZkAddress() {
        return zkAddress;
    }

    public void setZkAddress(String zkAddress) {
        this.zkAddress = zkAddress;
    }

    public boolean isServer() {
        return server;
    }

    public void setServer(boolean server) {
        this.server = server;
    }
}
