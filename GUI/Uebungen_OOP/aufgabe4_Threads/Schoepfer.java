package aufgabe4_Threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Schoepfer extends Thread {

	private static final Lock lock = new ReentrantLock();
	private static final Condition condFill = lock.newCondition();

	private static int wassertrog = 0;

	private int state = -1;

	public Schoepfer(int state) {
		this.state = state;
	}

	private static int randomInt() {
		return (int) (Math.random() * 20.0);
	}

	public void getTrogStand(String what, int c) {
		System.out.println(what + " " + c + "\tF\u00fcllstand: " + wassertrog);
	}

	@Override
	public void run() {
		while (true) {
			try {
				switch (state) {
				case 0:
					fill();
					break;
				case 1:
					remove();
					break;

				}
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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
			while (wassertrog < remove) {
				try {
					System.out.println(remove + " nicht entnehmbar F\u00fcllstand: " + wassertrog);
					condFill.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			wassertrog -= remove;

		} finally {
			lock.unlock();
		}
	}
}
