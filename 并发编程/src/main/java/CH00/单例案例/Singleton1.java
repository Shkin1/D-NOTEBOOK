package CH00.单例案例;

/**
 * <p>Title: Singleton1</p>
 * <p>Description: 懒汉
 * 描述：
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-22 10:12
 */
public class Singleton1 {

    /**
     * 在类加载的时候创建实例
     * 只会在类加载时创建一次,不会存在多个线程创建多个实例的情况, 避免多线程同步问题
     * 修饰该成员必须不可变
     *
     *
     */
    private static final Singleton1 instance = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 newInstance() {
        return instance;
    }

}
