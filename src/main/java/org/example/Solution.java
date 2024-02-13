package org.example;

import java.io.OutputStream;

public class Solution {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();

        // НАИБОЛЕЕ КОРРЕКТНЫЙ
        Counter counter = new Counter(); // implements Runnable
        Thread thread1 = new Thread(counter);
        thread1.start();

        // ЧЕРЕЗ АНОНИМНЫЙ КЛАСС
        Runnable myRun = new Runnable() {
            @Override
            public void run() {
                for (int i = 301; i < 400; i++) {
                    System.out.println("Шаг цикла № " + i + " поток " + Thread.currentThread().getName());
                }
            }
        };
        new Thread(myRun).start();

        // ЧЕРЕЗ АНОНИМНЫЙ КЛАСС СРАЗУ ПОДАННЫЙ К КОНСТРУКТОР Thread
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 401; i < 500; i++) {
                            System.out.println("Шаг цикла № " + i + " поток " + Thread.currentThread().getName());
                        }
                    }
                }
        ).start();

        // ЧЕРЕЗ ЛЯМБДУ
        new Thread(
                () -> {
                    for (int i = 501; i < 600; i++) {
                        System.out.println("Шаг цикла № " + i + " поток " + Thread.currentThread().getName());
                    }
                }
        ).start();

        // new Thread(() -> System.out.println("I'am also a Thread")).start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Шаг цикла № " + i + " поток " + Thread.currentThread().getName());
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {

        for (int i = 101; i < 200; i++) {
            System.out.println("Шаг цикла № " + i + " поток " + Thread.currentThread().getName());
        }
    }
}

class Counter implements Runnable {
    @Override
    public void run() {
        for (int i = 201; i < 300; i++) {
            System.out.println("Шаг цикла № " + i + " поток " + Thread.currentThread().getName());
        }
    }
}
