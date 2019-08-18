package eroshenkov.deadlock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Deadlock2 {

  private static final Object monitor1 = new Object();

  private static final Object monitor2 = new Object();

  public static void main(final String[] args) throws InterruptedException {
    List<Thread> threads = new ArrayList<>();
    threads.add(new Thread(Deadlock2::handler1));
    threads.add(new Thread(Deadlock2::handler2));
    Collections.shuffle(threads);
    threads.get(0).start();
    threads.get(1).start();
  }

  private static void handler1() {
    synchronized (monitor1) {
      new CountDownLatch(2);
      synchronized (monitor2) {
        System.out.println("Hello from handler1");
      }
    }
  }

  private static void handler2() {
    synchronized (monitor2) {
      new CountDownLatch(2);
      synchronized (monitor1) {
        System.out.println("Hello from handler2");
      }
    }
  }
}
