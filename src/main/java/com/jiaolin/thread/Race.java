package com.jiaolin.thread;

// 龟兔赛跑
public class Race implements Runnable {

    private static String winner;

    // 进行跑步
    public void run() {

        for (int i = 0; i <=100; i++) {
            if ((i % 10 == 0) && Thread.currentThread().getName().equals("兔子")) {
                // 模拟兔子休眠
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 来判断比赛是否结束
            Boolean flag = gameover(i);
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");

        }

    }

    // 来判断是否结束
    private Boolean gameover(int i) {
        if (winner != null) {
            return true;
        } else {
            if (i >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner is" + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        Thread value1 = new Thread(race, "兔子");
        Thread value2 = new Thread(race, "乌龟");
        value1.start();
        value2.start();


    }
}
