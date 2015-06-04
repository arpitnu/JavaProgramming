/**
 * 
 */
package edu.threads.synchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author arpitm
 *
 */
public class MultiLock {

	private static Random random = new Random();

	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	private static List<Integer> l1 = new ArrayList<Integer>();
	private static List<Integer> l2 = new ArrayList<Integer>();

	public static void stageOne() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			l1.add(random.nextInt());
		}
	}

	public static void stageTwo() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			l2.add(random.nextInt());
		}
	}

	public static void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}

	public static void main(String[] args) {
		System.out.println("Starting...");

		long start = System.currentTimeMillis();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				process();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				process();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();

		System.out.println("Time taken = " + (end - start));
		System.out.println("List1 size: " + l1.size());
		System.out.println("List2 size: " + l2.size());
	}

}
