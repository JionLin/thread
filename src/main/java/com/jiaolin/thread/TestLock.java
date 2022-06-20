package com.jiaolin.thread;

// 模拟死锁 2 ok
// 1. 互斥性  一个资源一次只能给一个进程 使用
// 2. 请求和保持 请求一个资源阻塞的情况下,自己手上的资源 不释放
// 3. 不可剥夺性 进程获得的资源,未使用完之前,不可以被剥夺
// 4. 循环等待   形成首位相连,资源释放不了
public class TestLock {

    public static void main(String[] args) {
        MakeUp makeUp = new MakeUp(0, "白雪公主");
        MakeUp makeUp2 = new MakeUp(1, "灰菇凉");
        makeUp.start();
        makeUp2.start();
    }
}

// 口红
class Mirror {

}

// 镜子
class Lipstick {

}

class MakeUp extends Thread {

    // 需要镜子和口红
    static Lipstick lipstick = new Lipstick();

    static Mirror mirror = new Mirror();

    // 选择  名字
    int choice;

    String girlName;

    public MakeUp(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }


    @Override
    public void run() {
        try {
            makeUp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void makeUp() throws InterruptedException {
        if (choice == 0) {
            // 想获得镜子
            synchronized (mirror) {
                System.out.println(this.girlName + "获得镜子的锁");
                sleep(100);

                synchronized (lipstick) {
                    System.out.println(this.girlName + "获得口红的锁");
                    sleep(200);
                }
            }
        } else {
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得口红的锁");
                sleep(100);

                synchronized (mirror) {
                    System.out.println(this.girlName + "获得镜子的锁");
                    sleep(200);
                }
            }
        }

    }

}
