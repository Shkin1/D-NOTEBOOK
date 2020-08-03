package lockandconfition;

/**
 * <p>Title: test06</p>
 * <p>Company:浩鲸云计算科技股份有限公司 </p>
 * <p>Description:
 * 描述：
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-07-30 21:05
 */
public class Test06 {

    public Object lock = new Object();

    public static void main(String[] args) {
        Test06 test06 = new Test06();
        // 创建线程对象
        Thread t = new Thread(new MyRun06(test06));
        t.setName("t");
        t.start();

//        try {
//            // 问题：这行代码会让t线程睡眠5秒钟吗？
//            t.sleep(5 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("hello world");

    }

    public void doSleep() throws InterruptedException {
        synchronized (lock) {
            System.out.println("开始sleep");
            Thread.sleep(10000);
            System.out.println("结束sleep");
        }
    }
}

class MyRun06 implements Runnable {
    private Test06 t;
    public MyRun06(Test06 t) {
        this.t = t;
    }

    @Override
    public void run() {
        try {
            t.doSleep();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }
}
