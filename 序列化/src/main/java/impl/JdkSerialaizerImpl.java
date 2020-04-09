package impl;

import service.ObjectSerializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * <p>Title: JdkSerialaizer</p>
 * <p>Description:
 * 描述：基于Java序列化来实现抽象的序列化接口
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-09 13:46
 */
public class JdkSerialaizerImpl implements ObjectSerializer {


    @Override
    public byte[] serialize(Object obj) throws IOException {
        /**
         * JDK自带的序列化具体的实现是由ObjectOutputStream完成的
         *
         */

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        try {
            oos.writeObject(obj);
            oos.flush();
            return baos.toByteArray();
        } finally {
            oos.close();
        }
    }

    @Override
    public void serialize(Object obj, OutputStream os) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(obj);
        oos.flush();
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) throws IOException, ClassNotFoundException {
        return deserialize(new ByteArrayInputStream(bytes), clazz);
    }

    @Override
    public <T> T deserialize(InputStream is, Class<T> clazz) throws IOException, ClassNotFoundException {
        return (T) this.deserialize(is);
    }


    @Override
    public Object deserialize(InputStream is) throws IOException, ClassNotFoundException {
        /**
         * 反序列化的具体实现是由ObjectInputStream完成的
         *
         */
        ObjectInputStream ois = null;
        if (is instanceof ObjectInputStream) {
            ois = (ObjectInputStream) is;
        } else {
            ois = new ObjectInputStream(is);
        }
        try {
            return ois.readObject();
        } finally {
            ois.close();
        }

    }

    @Override
    public Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public <T> T deserialize(byte[] b, T co) throws IOException, ClassNotFoundException {
        return null;
    }
}
