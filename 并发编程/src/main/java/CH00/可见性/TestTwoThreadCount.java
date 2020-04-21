package CH00.可见性;

/**
 * <p>Title: TestTwoThreadCount</p>
 *
 * <p>Description:
 * 描述：可见性问题测试
 *
 * CPU缓存速度 > 内存
 *
 * 缓存导致的可见性问题, 原因多核时代,每颗CPU都有自己的缓存,这时缓存与内存的数据一致性就没那么容易解决
 *
 * 当多个线程在不同的CPU上执行时, 这些线程操作的是不同的CPU缓存
 *
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-21 16:36
 */
public class TestTwoThreadCount {
    private long count = 0;

    private void add() {
        int i = 0;
        while (i++ < 10000) {
            count += 1;
        }
    }


    public static void main(String[] args) throws InterruptedException {

        TestTwoThreadCount test = new TestTwoThreadCount();

        Thread t1 = new Thread(() -> test.add());
        Thread t2 = new Thread(() -> test.add());

        t1.start();
        t2.start();
        t1.join();
        System.out.println("完成T1");
        t2.join();
        System.out.println("完成T2");
        System.out.println();

        /**
         * 结果为10000 - 20000 之间
         *
         * 缓存可见性问题
         *
         */
        System.out.println(test.count);

    }

}
