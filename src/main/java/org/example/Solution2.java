package org.example;

public class Solution2 {
    public static void main(String[] args) throws InterruptedException {

        ThreadyLady threadyLady = new ThreadyLady();
        threadyLady.start();

        Thread.sleep(3000);

        //threadyLady.stop();
        threadyLady.isStopped = true;

    }
}

class ThreadyLady extends Thread {

    boolean isStopped;

    @Override
    public void run() {

        while (true) {
            System.out.println("Tik");
            System.out.println("Tak");
            if (isStopped) {
                // ВСЕ НОРМАЛЬНО ЗАВЕРШИТЬ, А ПОТОМ
                break;
            }
        }

    }
}
