package com.ycic.practice;

public class Application1 {

	public static void main(String[] args) {
		System.out.println("Start thread 1");
		
		// call a runner in a thread
		//NewTaskRunner tr1 = new NewTaskRunner("Runner-A");
		//Thread t1 = new Thread(tr1);
		Thread t1 = new Thread(new NewTaskRunner("Runner-A"));
		t1.start();
		
		System.out.println("Start thread 2");
		
		// call a runner in a thread
		//NewTaskRunner tr2 = new NewTaskRunner("Runner-B");
		//Thread t2 = new Thread(tr2);
		Thread t2 = new Thread(new NewTaskRunner("Runner-B"));
		t2.start();	
		
		System.out.println("Start thread 3");
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				//Thread.currentThread().setName(this.name);
				for (int i = 0; i <  10; i++) {
					System.out.println("number " + i + " - " + Thread.currentThread().getName());
					try {
						Thread.sleep(10);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}		
		});
		t3.start();
		
		System.out.println("Start thread 4 with lambda");
		Thread t4 = new Thread(() -> {
				//Thread.currentThread().setName(this.name);
				for (int i = 0; i <  10; i++) {
					System.out.println("number " + i + " - " + Thread.currentThread().getName());
					try {
						Thread.sleep(10);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}		
		);
		t4.start();

	}
}

class NewTask extends Thread {
	String name;
	
	public NewTask(String name) {
		this.name = name;
	}
	
	public void run() {
		Thread.currentThread().setName(this.name);
		for (int i = 0; i <  10; i++) {
			System.out.println("number " + i + " - " + Thread.currentThread().getName());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}

class NewTaskRunner implements Runnable {
	String name;
	
	public NewTaskRunner(String name) {
		this.name = name;
	}
	
	public void run() {
		Thread.currentThread().setName(this.name);
		for (int i = 0; i <  10; i++) {
			System.out.println("number " + i + " - " + Thread.currentThread().getName());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
