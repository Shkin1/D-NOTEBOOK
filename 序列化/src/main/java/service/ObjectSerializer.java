package service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author shijinpu
 * @version v1.0.0
 * @date 2020/4/9 11:42
 * <p>Description: 序列化接口
 * <p>
 *  为方便集成多种序列化, 实现多种序列化组件的插拔和替换,
 *  将序列化及反序列化抽象为ObjectSerializer接口
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
public interface ObjectSerializer {

    /**
     * 将指定对象序列化为字节数组.
     *
     * @param obj 需要序列化的对象
     * @return 字节数组
     * @throws IOException
     */
    byte[] serialize(Object obj) throws IOException;

    /**
     * 将指定对象序列化并输出到流.
     *
     * @param obj
     * @param os
     * @throws IOException
     */
    void serialize(Object obj, OutputStream os) throws IOException;

    /**
     * 将字节数组反序列化为指定类型的对象 (确定该对象是何种类型时).
     *
     * @param bytes
     * @param clazz
     * @param <T>
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    <T> T deserialize(byte[] bytes, Class<T> clazz) throws IOException, ClassNotFoundException;

    /**
     * 从流中读取数据并反序列化为指定类型的对象 (确定该对象是何种类型时).
     *
     * @param is
     * @param clazz
     * @param <T>
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    <T> T deserialize(InputStream is, Class<T> clazz) throws IOException, ClassNotFoundException;

    /**
     * 从流中读取数据并反序列化为对象 (不确定对象类型时)
     *
     * @param is
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    Object deserialize(InputStream is) throws IOException, ClassNotFoundException;

    /**
     * 将字节数组反序列化为指定类型的对象 (不确定对象类型时)
     * @param bytes
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException;

    /**
     * 以对象T为模板, 反序列化后得到新的T
     * @param b
     * @param co
     * @param <T>
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    <T> T deserialize(byte[] b, T co) throws IOException, ClassNotFoundException;



}
