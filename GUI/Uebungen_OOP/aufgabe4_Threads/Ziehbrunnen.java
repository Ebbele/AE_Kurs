package aufgabe4_Threads;

import java.util.concurrent.TimeUnit;

public class Ziehbrunnen {

	public static void main(String[] args) {
		Schoepfer schoepfer = new Schoepfer();
		System.out.println("Starte Ziehbrunnen");
		Thread pumpe = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						schoepfer.fill();
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		pumpe.start();

		Thread verteiler = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						schoepfer.remove();
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		verteiler.start();
	}

}
