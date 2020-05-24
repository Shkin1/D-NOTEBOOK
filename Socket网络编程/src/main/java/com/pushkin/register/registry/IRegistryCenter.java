package com.pushkin.register.registry;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/5/24 21:44
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
@Component
public interface IRegistryCenter{
    /**
     * 注册服务
     *
     * @param zkAddress zkAddress
     * @param serviceName 服务名称
     * @param serviceAddress 服务地址
     */
    void register(String zkAddress, String serviceName, String serviceAddress);


    /**
     * 服务发现.
     *
     * @param zkAddress zkAddress
     * @param serviceName serviceName
     * @return serviceList
     */
    List<String> discoveryService(String zkAddress, String serviceName);
}
