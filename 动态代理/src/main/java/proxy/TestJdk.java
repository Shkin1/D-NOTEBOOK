package proxy;

import java.lang.reflect.Proxy;

/**
 * <p>Title: TestJdk</p>
 * <p>github </p>
 * <p>Description:
 * 描述：
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-13 18:44
 */
public class TestJdk {
    public static void main(String[] args) {
        System.out.println("-------------------第一种创建代理类方法--------------");
        System.out.println("-------------------通过Proxy.newProxyInstance 方法 获取代理对象--------------");

        // 1. 委托类
        HelloServiceImpl helloService = new HelloServiceImpl();

        // 2. 委托类的统一处理逻辑Handler  (回调InvocationHandler接口的invoke方法执行)
        HelloInvocationHandler<HelloServiceImpl> helloServiceHelloInvocationHandler = new HelloInvocationHandler<>(helloService);

        // 3. 创建一个代理对象 [动态创建- 代码运行期创建代理]
        HelloService jdkProxy = (HelloService)Proxy.newProxyInstance(HelloService.class.getClassLoader(),
                new Class<?>[]{HelloService.class}, helloServiceHelloInvocationHandler);
        // 4. 调用
        jdkProxy.say();


    }
}
