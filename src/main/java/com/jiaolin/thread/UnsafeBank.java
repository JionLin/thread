package com.jiaolin.thread;

// 模拟取款 1
// 账户
// 测试类

public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account("结婚基金", 100);

        new DrawMoney(account, 50, "you").start();
        new DrawMoney(account, 100, "girlFriend").start();
    }
}

class Account {

    String name;

    int money;

    public Account(String name, int money) {
        this.name = name;
        this.money = money;
    }
}

class DrawMoney extends Thread {

    Account account;

    int nowMoney;

    int drawMoney;

    public DrawMoney(Account account, int drawMoney, String name) {
        super(name);
        this.account = account;
        this.drawMoney = drawMoney;
    }

    @Override
    public void run() {
        synchronized (account){

            if (account.money - drawMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "卡内余额不足");
                return;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 卡内余额
            account.money = account.money - drawMoney;

            // 手上的钱
            nowMoney = drawMoney + nowMoney;

            System.out.println("卡内的余额" + account.money);

            System.out.println(this.getName() + "的钱为：" + nowMoney);
        }

    }
}
