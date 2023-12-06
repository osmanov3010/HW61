package ait.printer.task;

import java.time.Instant;

public class Printer implements Runnable {

    public static int countOfSymbols;
    public static int countOfIterations;
    private Thread nextThread;
    private String text;

    public Printer(String text) {
        int t = 0;
        StringBuilder res = new StringBuilder(); // using StringBuilder just for concat in loop
        while (countOfSymbols > t) {
            res.append(text);
            t++;
        }
        this.text = res.toString();
    }

    public void setNextThread(Thread nextThread) {
        this.nextThread = nextThread;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < countOfIterations) {
            try {
                Thread.sleep(1_000_000);
            } catch (InterruptedException e) {
                // System.out.println(text + " = " + System.currentTimeMillis());
                System.out.println(text);
                nextThread.interrupt();
            }
            i++;
        }
    }
}