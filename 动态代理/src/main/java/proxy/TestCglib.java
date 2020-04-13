package proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * <p>Title: TestCglib</p>
 * <p>github </p>
 * <p>Description:
 * 描述：
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-13 18:59
 */
public class TestCglib {
    public static void main(String[] args) {

        CglibMethodInterceptor cglibMethodInterceptor = new CglibMethodInterceptor();

        // 创建加强器，用来创建动态代理类
        Enhancer eh = new Enhancer();
        // 为代理类指定需要代理的类，也即是父类
        eh.setSuperclass(HelloServiceImpl.class);
        // 设置方法拦截器回调引用，对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept() 方法进行拦截
        eh.setCallback(cglibMethodInterceptor);

        HelloServiceImpl cglibProxy = (HelloServiceImpl)eh.create();

        // cglib 创建对象消耗时间比较多 > JDk代理方式, 但处理的性能>JDK代理方式
        // 一次创建 多次使用的对象 推荐使用cglib
        cglibProxy.say();


    }
}
