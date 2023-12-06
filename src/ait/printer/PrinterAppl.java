package ait.printer;

import ait.printer.task.Printer;

public class PrinterAppl {

    static final int COUNT_OF_THREADS = 10;

    public static void main(String[] args) {

        Printer.countOfSymbols = 10; // Count of numbers
        Printer.countOfIterations = 2; // Count of iterations


        Thread[] threads = new Thread[COUNT_OF_THREADS];
        Printer[] printers = new Printer[COUNT_OF_THREADS];

        int counter = 0;
        while (counter < COUNT_OF_THREADS) {
            printers[counter] = new Printer(String.valueOf(counter));
            threads[counter] = new Thread(printers[counter]);

            if (counter != 0) {
                printers[counter - 1].setNextThread(threads[counter]);
                if ((counter + 1) == COUNT_OF_THREADS) { // if last one
                    printers[counter].setNextThread(threads[0]);
                }
            }
            threads[counter].start();
            counter++;
        }

        threads[0].interrupt(); // for starting work

    }
}
