package proxy.util;

/**
 * <p>Title: MonitorUtil</p>
 * <p>github </p>
 * <p>Description:
 * 描述：方法用时监控类
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-13 15:31
 */
public class MonitorUtil {
    private static ThreadLocal<Long> tl = new ThreadLocal<>();

    public static void start() {
        tl.set(System.currentTimeMillis());
    }

    /**
     * 结束时打印耗时
     *
     * @param methodName 方法名
     */
    public static void finish(String methodName) {
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName + "方法执行耗时" + (finishTime - tl.get()) + "ms");
    }
}
