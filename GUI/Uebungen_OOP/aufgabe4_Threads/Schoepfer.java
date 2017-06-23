package aufgabe4_Threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Schoepfer {

	private static final Lock lock = new ReentrantLock();
	private static final Condition condFill = lock.newCondition();

	private static int wassertrog = 0;

	private static int randomInt() {
		return (int) (Math.random() * 20.0);
	}

	public void getTrogStand(String what, int c) {
		System.out.println(what +" "+ c + "\tF\u00fcllstand: " + wassertrog);
	}

	public void fill() {
		lock.lock();
		try {
			int fill = randomInt();
			wassertrog += fill;
			condFill.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public void remove() {
		lock.lock();
		try {
			int remove = randomInt();
			if (wassertrog < remove) {
				try {
					System.out.println(remove + " nicht entnehmbar");
					condFill.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				wassertrog -= remove;
			}

		} finally {
			lock.unlock();
		}
	}
}
