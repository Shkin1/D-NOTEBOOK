package lockandconfition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Title: BlockedQueue</p>
 * <p>Description:
 * 描述：
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-28 20:51
 */
public class BlockedQueue {

    // notFull  不满锁,  如果队列已满, 就释放锁, 等到队列不满(信号) [出队的话 就不满];   入队 通知notEmpty线程不用阻塞 可以取数(信号)了
    // notEmpty 不空锁,  如果队列已空, 就释放锁, 等到队列不空(信号) [入队的话 就不空];   出队 通知notFull线程不用阻塞  可以装数(信号)了

    // 核心就是:  阻塞(释放锁) + 通知信号
    // 用同一把锁, 锁同一个不共享变量 的不同操作!


    final ReentrantLock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            // 当数组满了
            while (count == items.length) {
                // 释放锁，等待
                notFull.await();
            }
            // 放入数据
            items[putptr] = x;
            // 如果到最后一个位置了,下标从头开始,防止下标越界
            if (++putptr == items.length) {
                // 从头开始
                putptr = 0;
            }
            // 对 count ++ 加加
            ++count;
            // 通知 take 线程,可以取数据了,不必继续阻塞
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            // 如果数组没有数据,则等待
            while (count == 0) {
                notEmpty.await();
            }
            // 取数据
            Object x = items[takeptr];
            // 如果到数组尽头了,就从头开始
            if (++takeptr == items.length) {
                // 从头开始
                takeptr = 0;
            }
            // 将数量减1
            --count;
            // 通知阻塞的 put 线程可以装填数据了
            notFull.signal();
            return x;
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockedQueue blockedQueue = new BlockedQueue();

        for (int j = 0; j < 10; j++) {
            new Thread(()->{

                for (int i = 0; i < 10; i++) {
                    try {
                        blockedQueue.put(i);
                        System.out.println(Thread.currentThread().getName()+"入队: "+i);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            new Thread(()-> {
                for (int i = 0; i < 10; i++) {
                    try {
                        Object take = blockedQueue.take();
                        System.out.println(Thread.currentThread().getName()+"出队: "+take);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }).start();


        }



    }

}
