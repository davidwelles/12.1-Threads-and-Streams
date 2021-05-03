package com.tts;
import java.util.ArrayList;
import java.util.List;
public class Main {
    // this main method is known as our entry point
    // but in fact, it's also known as our main thread
    // the main thread
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world, I'm in a main thread!");
        // we create a new thread instance and we pass a runnable object into that instance
        // thread as a class has a method called start, which invokes to begin the execution of our runnable
        (new Thread(new HelloRunnable())).start();
        /* this is another way to invoke a thread
        Thread th = new Thread(new HelloRunnable());
        th.start(); */
        Runnable task = () -> System.out.println("Hello from a lambda! Here is the thread's ID: " + Thread.currentThread().getId());
        // currentThread().getID() will access the id of the thread below
        (new Thread(task)).start();

        String[] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };
        List<Integer> myList = new ArrayList<>();
        // below is an anonymous inner class
        Runnable messageTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < importantInfo.length; i++) {
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                    System.out.println(importantInfo[i]);
                }
            }
        };
        for (int i = 0; i < importantInfo.length; i++) {
            // I want to pause the executing thread for 4 seconds
            Thread.sleep(4000);
            // print out message after the pause
            System.out.println(importantInfo[i]);
        }
        (new Thread(messageTask)).start();
    }
}
