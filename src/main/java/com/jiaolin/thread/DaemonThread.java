package com.jiaolin.thread;

// 守护线程
public class DaemonThread {

    public static void main(String[] args) {
        // 把上帝弄成守护线程
        God god=new God();
        Thread thread = new Thread(god);
        thread.setDaemon(true);
        thread.start();

        You you=new You();
        new Thread(you).start();


    }


}

class God implements Runnable{

    public void run() {
        while (true){
            System.out.println("上帝");
        }
    }
}

class You implements Runnable{

    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.println("人生这么多天"+i);
        }
    }
}
