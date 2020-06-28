package com.pushkin.register.registry;

import com.pushkin.register.constants.Constants;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/5/24 21:51
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
@Service
public class IRegistryCenterImpl implements IRegistryCenter {

    public CuratorFramework curatorFramework = null;

    /**
     * 连接zookeeper
     *
     * @param zkAddress zkAddress
     * @return CuratorFramework
     */
    public CuratorFramework getCuratorFramework(String zkAddress) {
        if (curatorFramework == null) {
            synchronized (this) {
                if (curatorFramework == null) {
                    curatorFramework = CuratorFrameworkFactory.builder()
                            .connectString(zkAddress)
                            .connectionTimeoutMs(10000)
                            .retryPolicy(new RetryNTimes(3, 2000))
                            .build();
                    curatorFramework.start();
                    try {
                        curatorFramework.blockUntilConnected();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("连接zookeeper成功");
                }
            }
        }
        return curatorFramework;
    }


    @Override
    public void register(String zkAddress, String serviceName, String serviceAddress) {
        curatorFramework = getCuratorFramework(zkAddress);
        // zk节点: /registry/xxxx-provider/ip:9090
        try {
            // 创建根节点
            if (curatorFramework.checkExists().forPath(Constants.REGISTRY) == null) {
                curatorFramework.create()
                        // 持久节点
                        .withMode(CreateMode.PERSISTENT)
                        .forPath(Constants.REGISTRY);
            }

            // 创建服务节点
            String serviceNode = Constants.REGISTRY + "/" + serviceName + "/" + serviceAddress;
            curatorFramework.create()
                    .creatingParentsIfNeeded()
                    // 临时节点
                    .withMode(CreateMode.EPHEMERAL)
                    .forPath(serviceNode);

            System.out.println("服务注册完毕...."+serviceName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 服务发现
     *
     * @param zkAddress zkAddress
     * @param serviceName serviceName
     * @return
     */
    @Override
    public List<String> discoveryService(String zkAddress, String serviceName) {
        curatorFramework = getCuratorFramework(zkAddress);
        // zk节点: /registry/xxxx-provider/ip:9090

        String serviceNode = Constants.REGISTRY + "/" + serviceName;
        try {
            // 服务提供者可能是集群提供多个
            return curatorFramework.getChildren().forPath(serviceNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
