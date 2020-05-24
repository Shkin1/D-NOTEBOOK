package com.pushkin.register.autoconfig;

import com.pushkin.register.context.RegistryCenterContext;
import com.pushkin.register.properties.RegistryProperties;
import com.pushkin.register.registry.IRegistryCenter;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/5/24 22:29
 * <p>
 *      自动化配置类
 *
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
@ConditionalOnClass(CuratorFramework.class)
@Configuration
@ComponentScan(basePackages = {"com.pushkin.register.properties","com.pushkin.register.registry"})
public class RegistryAutoConfiguration {
    @Autowired
    private RegistryProperties registryProperties;
    @Autowired
    private IRegistryCenter registryCenter;

    @Autowired
    private Environment environment;

    /**
     * 当这个对象被spring注入后,自动执行初始化
     *
     * 注册中心的初始化: 服务注册 或者 服务发现
     *
     */
    @PostConstruct
    public void initRegistryCenter() {
        // 拿到用户配置的zk地址
        String zkAddress = registryProperties.getZkAddress();
        boolean server = registryProperties.isServer();
        // 服务名字
        String serviceName = environment.getProperty("spring.application.name");
        // 服务地址 192.168.1.1:9090
        String serviceAddress = null;

        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            String port = environment.getProperty("server.port");
            serviceAddress = ip + ":" + port;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        if (server) {
            // 服务提供者 -> 注册服务
            registryCenter.register(zkAddress, serviceName, serviceAddress);

        } else {
            // 客户端 -> 服务消费者 -> 服务发现
            List<String> serviceList = registryCenter.discoveryService(zkAddress, serviceName);
            registryCenterContext(serviceList);
        }
    }

    @Bean
    public RegistryCenterContext registryCenterContext(List<String> serviceList) {
        return new RegistryCenterContext(serviceList);

    }
}
