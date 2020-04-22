package CH00.单例案例;

/**
 * <p>Title: Singleton</p>
 *
 * <p>Description:
 * 描述：编译优化带来的有序性问题
 * </p>
 *
 * 编译器为了优化性能，有时候会改变
 * 程序中语句的先后顺序，例如程序中：“a=6；b=7；”编译器优化后可能变成“b=7；
 * a=6；”，在这个例子中，编译器调整了语句的顺序，但是不影响程序的最终结果。不过有
 * 时候编译器及解释器的优化可能导致意想不到的 Bug
 *
 * 比如如下的经典案例就是利用双重检查创建单例对象
 *
 *
 *
 * 优化后会导致什么问题呢？我们假设线程 A 先执行 getInstance() 方法，当执行完指令 2
 * 时恰好发生了线程切换，切换到了线程 B 上；如果此时线程 B 也执行 getInstance() 方
 * 法，那么线程 B 在执行第一个判断时会发现 instance != null ，所以直接返回
 * instance，而此时的 instance 是没有初始化过的，如果我们这个时候访问 instance 的成
 * 员变量就可能触发空指针异常。
 *
 *
 *
 * 对于双重锁的问题，我觉得任大鹏分析的蛮有道理，线程A进入第二个判空条件，进行初始
 * 化时，发生了时间片切换，即使没有释放锁，线程B刚要进入第一个判空条件时，发现条件
 * 不成立，直接返回instance引用，不用去获取锁。如果对instance进行volatile语义声明，
 * 就可以禁止指令重排序，避免该情况发生。
 * 对于有些同学对CPU缓存和内存的疑问，CPU缓存不存在于内存中的，它是一块比内存快的缓存
 *
 *
 *
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-21 16:53
 */
public class Singleton {
    static Singleton instance;

    static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    /**
                     *
                     *
                     * 注意此处实际的的执行路径:
                     * 1. 分配一块内存
                     * 2. 将M的地址赋值给instance变量  *******(内存先指向引用的变量, 再实例化对象)
                     * 3. 最后将内存M上初始化Singleton对象
                     *
                     * 而不是我们以为的:
                     * 1. 分配一块内存
                     * 2. 在内存 M 上初始化 Singleton 对象； *******(内存例化对象, 再指向引用变量)
                     * 3. 然后 M 的地址赋值给 instance 变量。
                     *
                     *
                     * 这就可能造成空指针问题:
                     * 比如当线程 A 先执行getInstance(), 当执行到第二步时 正好发生线程切换
                     * 切换到 B 上; 如果此时 B 也在执行getInstance(), 那么在执行第一个判断是
                     * 会发现 instance != null, 所以直接返回 instance
                     * 而此时的instance是没有初始化过的, 如果此时我们访问instance的成员变量就可能触发
                     * 空指针异常了
                     *
                     * 如果对instance进行volatile语义声明 ，就可以禁止指令重排序，避免该情况发生。
                     */
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
