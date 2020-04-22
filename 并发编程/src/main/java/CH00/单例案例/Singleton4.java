package CH00.单例案例;

/**
 * <p>Title: Singleton4</p>
 * <p>Description: 静态内部类实现
 * 描述：实现延迟加载
 * <p>
 * <p>
 * 这种方式同样利用了类加载机制来保证只创建一个instance实例。它与饿汉模式一样，也是利用了类加载机制，因此不存在多线程并发的问题。
 * 不一样的是，它是在内部类里面去创建对象实例。这样的话，只要应用中不使用内部类，JVM就不会去加载这个单例类，也就不会创建单例对象，
 * 从而实现懒汉式的延迟加载。也就是说这种方式可以同时保证延迟加载和线程安全。
 *
 *
 *
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-22 09:52
 */
public class Singleton4 {

    /**
     * 外部类加载的时候, 静态内部类并不会被加载进去的
     * 只有在 Singleton4.newInstance 才会被加载
     *
     */
    private static class SingletonHolder {
        public static Singleton4 instance = new Singleton4();
    }

    private Singleton4() {
    }

    public static Singleton4 newInstance() {
        return SingletonHolder.instance;
    }

}
