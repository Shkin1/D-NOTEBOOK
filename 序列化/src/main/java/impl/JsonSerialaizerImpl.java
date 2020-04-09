package impl;

import com.alibaba.fastjson.JSON;
import service.ObjectSerializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <p>Title: JsonSerialaizerImpl</p>
 * <p>Company:浩鲸云计算科技股份有限公司 </p>
 * <p>Description:
 * 描述：
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-09 14:59
 */
public class JsonSerialaizerImpl implements ObjectSerializer {
    public byte[] serialize(Object obj) throws IOException {
        return JSON.toJSONBytes(obj);
    }

    public void serialize(Object obj, OutputStream os) throws IOException {

    }

    public <T> T deserialize(byte[] bytes, Class<T> clazz) throws IOException, ClassNotFoundException {
        return JSON.parseObject(bytes, clazz);
    }

    public <T> T deserialize(InputStream is, Class<T> clazz) throws IOException, ClassNotFoundException {
        return null;
    }

    public Object deserialize(InputStream is) throws IOException, ClassNotFoundException {
        return null;
    }

    public Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        return null;
    }

    public <T> T deserialize(byte[] b, T co) throws IOException, ClassNotFoundException {
        return null;
    }
}
