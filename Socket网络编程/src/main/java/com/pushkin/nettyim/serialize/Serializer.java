package com.pushkin.nettyim.serialize;

import com.pushkin.nettyim.serialize.impl.JSONSerializer;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/5/24 14:33
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public interface Serializer {
    /**
     * json 序列化 [默认]
     */
    byte JSON_SERIALIZER = 1;

    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法
     */
    byte getSerializerAlogrithm();
    /**
     * java 对象转换成二进制
     */
    byte[] serialize(Object object);
    /**
     * 二进制转换成 java 对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);

}
