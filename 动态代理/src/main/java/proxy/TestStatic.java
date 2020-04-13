package proxy;

/**
 * <p>Title: TestStatic</p>
 * <p>github </p>
 * <p>Description:
 * 描述：
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-13 18:44
 */
public class TestStatic {
    public static void main(String[] args) {
        HelloStaticProxy helloStaticProxy = new HelloStaticProxy(new HelloServiceImpl());
        helloStaticProxy.say();
    }
}
