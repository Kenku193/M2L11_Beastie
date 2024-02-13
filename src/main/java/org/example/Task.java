package org.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Task {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new FileWriter().start();
        }
    }
}

class FileWriter extends Thread{
    @Override
    public void run() {
        byte[] b = new byte[500];
        new Random().nextBytes(b);
        try {
            FileOutputStream fileOutputStream
                    =
                    new FileOutputStream(new File("myFileFrom" + Thread.currentThread().getName() + ".txt"));
            fileOutputStream.write(b);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
