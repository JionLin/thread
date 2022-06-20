package com.jiaolin.thread;

// 来进行测试线程优先级 NORM_PRIORITY
public class ThreadPriority {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        Thread a = new Thread(thread, "A");
        Thread b = new Thread(thread, "B");
        Thread c = new Thread(thread, "C");
        Thread d = new Thread(thread, "D");
        Thread e = new Thread(thread, "E");

        a.start();
        b.setPriority(1);
        b.start();
        c.setPriority(4);
        c.start();

        d.setPriority(8);
        d.start();

        e.setPriority(10);
        e.start();


    }

}

    class MyThread implements Runnable {

        public void run() {
            System.out.println(Thread.currentThread().getName()+"线程的优先级是"+Thread.currentThread().getPriority());
        }
    }
