package proxy;

import proxy.util.MonitorUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * <p>Title: HelloinvocationHandler</p>
 * <p>github </p>
 * <p>Description:
 * 描述：
 * </p>
 * 实现InvocationHandler接口，这个类中持有一个被代理对象(委托类)的实例target。
 * 该类别JDK Proxy类回调
 *
 * InvocationHandler 接口中有一个invoke方法，当一个代理实例的方法被调用时，
 * 代理方法将被编码并分发到 InvocationHandler接口的invoke方法执行。
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-13 18:42
 */
public class HelloInvocationHandler<T> implements InvocationHandler {

    /**
     * 被代理对象引用，invoke 方法里面method 需要使用这个被代理对象
     */
    private T target;

    public HelloInvocationHandler(T target) {
        this.target = target;
    }

    /**
     * InvocationHandler这个接口 是被动态代理类回调的接口，
     * 我们所有需要增加的针对委托类的统一处理逻辑都增加到invoke 方法里面
     * 在调用委托类接口方法之前或之后 结束战斗。
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("被动态代理类回调执行, 代理类 proxyClass ="+proxy.getClass()+" 方法名: " + method.getName() + "方法. 方法返回类型："+method.getReturnType()
                +" 接口方法入参数组: "+(args ==null ? "null" : Arrays.toString(args)));

        System.out.println("执行前操作-----------");
        MonitorUtil.start();
//        Thread.sleep(1000);
        /** 调用被代理的真实对象*/
        Object result = method.invoke(target, args);
        System.out.println("执行后操作-----------");
        MonitorUtil.finish(method.getName());
        return result;
    }
}