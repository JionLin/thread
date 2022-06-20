package com.jiaolin.thread;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

// 测试生产者和消费者  缓存区 3
// 生产者
// 消费者
// 产品
// 缓存区
// 测试类
public class TestPC {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        new Producer(synContainer).start();
        new Consumer(synContainer).start();
    }
}


// 生产者
class Producer extends Thread {
    private SynContainer synContainer;

    public Producer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    // 生产
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            synContainer.push(new Chiken(i));
            System.out.println("生产了" + i + "只鸡");

        }
    }
}

// 消费者
class Consumer extends Thread {
    private SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    // 消费
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            Chiken pop = synContainer.pop();
            System.out.println("消费了" + pop.id + "只鸡");

        }
    }
}

// 产品
class Chiken {
     int id;

    public Chiken(int id) {
        this.id = id;
    }
}

// 缓冲区
class SynContainer {

    // 一个容器大小
    Chiken[] chikens = new Chiken[10];
    // 计数
    int count = 0;

    // 如果生产者没有就生产 否则就通知消费者消费
    public synchronized void push(Chiken chiken) {
        // 如果容器满了 就通知消费者消费
        if (count == chikens.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 没满 就自己生产
        chikens[count] = chiken;
        // count++
        count++;
        // 通知消费者消费
        this.notifyAll();
    }

    // 消费者进行消费
    public synchronized Chiken pop() {
        // 如果没有就进行等待
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 消费
        count--;
        // 吃完了 通知生产者生产
        Chiken chiken = chikens[count];
        this.notifyAll();
        return chiken;
    }

}
