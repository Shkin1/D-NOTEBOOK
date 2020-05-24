package com.pushkin.nettyim.protocol;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/5/24 14:25
 * <p>
 *     通信过程中 Java 对象的抽象类.
 *
 *
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public abstract class Packet {
    @JSONField(deserialize = false, serialize = false)
    private Byte version = 1;

    /**
     * 获取指令
     *
     * @return 指令
     */
    @JSONField(serialize = false)
    public abstract Byte getCommand();

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }
}
