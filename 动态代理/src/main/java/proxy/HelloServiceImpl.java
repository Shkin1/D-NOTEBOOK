package proxy;

/**
 * <p>Title: HelloServiceImpl</p>
 * <p>github </p>
 * <p>Description:
 * 描述：委托类, 真实实现类
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-13 18:31
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void say() {
        System.out.println("i am real object, say hello");

    }

    @Override
    public void play() {
        System.out.println("i am real object, i'm play game");
    }
}
