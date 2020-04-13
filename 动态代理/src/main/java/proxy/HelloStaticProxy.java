package proxy;

/**
 * <p>Title: HelloStaticProxy</p>
 * <p>github </p>
 * <p>Description:
 * 描述：代理类
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-13 18:34
 */
public class HelloStaticProxy implements HelloService{

    HelloServiceImpl realHello;

    public HelloStaticProxy(HelloServiceImpl realHello) {
        this.realHello = realHello;
    }


    @Override
    public void say() {
        System.out.println("手动实现代理类: ");
        System.out.println("执行前操作-----------");
        realHello.say();
        System.out.println("执行后操作-----------");
    }

    @Override
    public void play() {
        System.out.println("手动实现代理类: ");
        System.out.println("执行前操作-----------");
        realHello.play();
        System.out.println("执行后操作-----------");

    }
}
