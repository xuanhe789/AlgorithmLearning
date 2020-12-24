package 多线程;

import java.util.concurrent.atomic.AtomicInteger;

//三个不同的线程将会共用一个 Foo 实例。
//
//        线程 A 将会调用 first() 方法
//        线程 B 将会调用 second() 方法
//        线程 C 将会调用 third() 方法
//        请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
//
//         
//
//        示例 1:
//
//        输入: [1,2,3]
//        输出: "firstsecondthird"
//        解释:
//        有三个线程会被异步启动。
//        输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
//        正确的输出是 "firstsecondthird"。
//        示例 2:
//
//        输入: [1,3,2]
//        输出: "firstsecondthird"
//        解释:
//        输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。
//        正确的输出是 "firstsecondthird"。
public class 按序打印 {
    public 按序打印() {

    }
    Object lock=new Object();
    boolean booleanFirst=false;
    boolean booleanSecond=false;

    //sychronized+wait解决问题
    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock){
            printFirst.run();
            booleanFirst=true;
            notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock){
            while (!booleanFirst){
                lock.wait();
            }
            printSecond.run();
            booleanSecond=true;
            notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock){
            while (!booleanSecond){
                lock.wait();
            }
            printThird.run();
        }
    }
}

class 按序打印1{
    public 按序打印1() {

    }
    //使用volatile来解决
    volatile boolean booleanFirst=false;
    volatile boolean booleanSecond=false;
    //使用CAS算法来解决
    AtomicInteger atomicInteger1=new AtomicInteger(0);
    AtomicInteger atomicInteger2=new AtomicInteger(0);

    public void first(Runnable printFirst) throws InterruptedException {

        printFirst.run();
//        booleanFirst=true;
        atomicInteger1.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (atomicInteger1.get()!=1){
            continue;
        }
        printSecond.run();
//        booleanSecond=true;
        atomicInteger2.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (atomicInteger2.get()!=1){
            continue;
        }
        printThird.run();
    }
}
