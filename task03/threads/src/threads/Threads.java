/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package threads;

import static java.lang.Thread.sleep;
import static threads.multithread.area;

/**
 *
 * @author nooor
 */
public class Threads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Thread hello = new Thread(new HelloThread());
            Thread count = new Thread(new CountThread());
            hello.start();
            count.start();
    }
    static class HelloThread implements Runnable {
        public void run() {
            int pause;
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("Hello!");
                    pause = (int) (Math.random() * 3000);
                    sleep(pause);
                } catch (InterruptedException ex) {
                    ex.getMessage();
                }
            }
        }
    }

    static class CountThread extends Thread {
        public void run() {
            int pause;
            for (int i = 1; i <= 5; i++) {
                try {
                    System.out.println(" "+i);
                    pause = (int) (Math.random() * 3000);
                    sleep(pause);
                } catch (InterruptedException ex) {
                    ex.getMessage();
                }
            }
        }
    }
}
