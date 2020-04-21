package CH00.单例案例;

/**
 * <p>Title: Singleton</p>
 *
 * <p>Description:
 * 描述：
 * </p>
 *
 *
 * 假设有两个线程 A、B 同时调用 getInstance() 方法，他们会同时发现 instance ==
 * null ，于是同时对 Singleton.class 加锁，此时 JVM 保证只有一个线程能够加锁成功（假
 * 设是线程 A），另外一个线程则会处于等待状态（假设是线程 B）；线程 A 会创建一个
 * Singleton 实例，之后释放锁，锁释放后，线程 B 被唤醒，线程 B 再次尝试加锁，此时是
 *
 * 可以加锁成功的，加锁成功后，线程 B 检查 instance == null 时会发现，已经创建过
 * Singleton 实例了，所以线程 B 不会再创建一个 Singleton 实例。
 * 这看上去一切都很完美，无懈可击，但实际上这个 getInstance() 方法并不完美。问题出在
 * 哪里呢？出在 new 操作上，我们以为的 new 操作应该是：
 *
 * 1. 分配一块内存 M；
 * 2. 在内存 M 上初始化 Singleton 对象；
 * 3. 然后 M 的地址赋值给 instance 变量。
 * 但是实际上优化后的执行路径却是这样的：
 * 1. 分配一块内存 M；
 * 2. 将 M 的地址赋值给 instance 变量；
 * 3. 最后在内存 M 上初始化 Singleton 对象
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
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
