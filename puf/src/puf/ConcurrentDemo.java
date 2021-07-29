package puf;

public class ConcurrentDemo {

	public static void main(String[] args) {
/*
		Runnable runnable = () -> {				//was soll der Thread tun?
			String threadName = Thread.currentThread().getName();
			while(true) {
				sleep(1000);									//Methode der einbettenden Klasse (ConcurrentDemo)
				System.out.println(threadName + " running");
			}
		};
*/
		Runnable runnable1 = new MyRunnable();
		Runnable runnable2 = new MyRunnable();
		
		Thread thread1 = new Thread(runnable1, "My Thread 1");	//Thread mit Name erzeugen
		thread1.setDaemon(true);								//Thread endet (undefiniert), wenn main-Thread endet
		thread1.start();										//Thread starten
		Thread thread2 = new Thread(runnable2, "My Thread 2");
		thread2.setDaemon(true);
		thread2.start();
		sleep(3100);											//nach 3.1 sek endet der main-Thread
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
