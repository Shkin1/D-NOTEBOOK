package com.pushkin.nettyim.serialize.impl;

import com.alibaba.fastjson.JSON;
import com.pushkin.nettyim.serialize.Serializer;
import com.pushkin.nettyim.serialize.SerializerAlgorithm;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/5/24 14:34
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public class JSONSerializer implements Serializer {

    @Override
    public byte getSerializerAlogrithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
