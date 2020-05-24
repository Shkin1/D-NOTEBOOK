package com.pushkin.register.context;

import java.util.List;
import java.util.Random;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/5/24 23:07
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public class RegistryCenterContext {
    private List<String> serviceList;


    public RegistryCenterContext() {
    }

    public RegistryCenterContext(List<String> serviceList) {
        this.serviceList = serviceList;
    }

    /**
     * 获取服务地址
     *
     * @return
     */
    public String getService() {
        // 负载均衡(随机负载均衡)
        int index = new Random().nextInt(serviceList.size());
        return serviceList.get(index);
    }

    public List<String> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<String> serviceList) {
        this.serviceList = serviceList;
    }
}
