import impl.JdkSerialaizerImpl;
import impl.JsonSerialaizerImpl;
import service.ObjectSerializer;

import java.io.IOException;

/**
 * <p>Title: TestSerialaizer</p>
 * <p>Description:
 * 描述：
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-09 14:14
 */
public class TestSerialaizer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TestStudent t1 = new TestStudent(110, "student1");

        // JDK序列化
        JdkSerialaizerImpl jdkSerialaizer = new JdkSerialaizerImpl();
        // Json序列化
        ObjectSerializer jsonSerialaizer = new JsonSerialaizerImpl();

        // 测试JDK自带的序列化
        testSerialaizer(t1, jdkSerialaizer);
        // 测试JSON序列化
//        testSerialaizer(t1, jsonSerialaizer);

    }

    static void testSerialaizer(Object obj, ObjectSerializer objectSerializer) throws IOException, ClassNotFoundException {
        // 序列化
        byte[] serialize = objectSerializer.serialize(obj);
        // 反序列化
        TestStudent t3 = objectSerializer.deserialize(serialize, new TestStudent().getClass());
        System.out.println(t3.getNo());
        System.out.println(t3.getName());
    }
}
