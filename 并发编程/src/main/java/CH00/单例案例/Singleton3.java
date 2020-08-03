package CH00.单例案例;

/**
 * <p>Title: Singleton3</p>
 * <p>Description:
 * 描述：双重校验 + 可见volatile
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-22 09:57
 */
public final class Singleton3 {
    /** 可见volatile */
    private static volatile Singleton3 instance = null;
    private Singleton3() {
    }
    /** 双重校验 */
    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
