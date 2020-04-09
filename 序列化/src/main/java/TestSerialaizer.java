import impl.JdkSerialaizerImpl;

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
        JdkSerialaizerImpl jdkSerialaizer = new JdkSerialaizerImpl();

        byte[] serialize = jdkSerialaizer.serialize(t1);

        TestStudent t2 = new TestStudent();
        TestStudent t3 = jdkSerialaizer.deserialize(serialize, t2.getClass());

        System.out.println(t3.getNo());
        System.out.println(t3.getName());

    }
}
