package com.ycic.practice;

public class Application {

	public static void main(String[] args) {
		System.out.println("Start thread 1");

		// call a thread in separate thread
		Task task1 = new Task("Thread-A");
		task1.start();
		
		// call a runner
		TaskRunner tr1 = new TaskRunner("Runner-A");
		tr1.run();
		
		System.out.println("Start thread 2");
		
		//taskRunner.start();	// it is illegal to start same thread more than once
		Task task2 = new Task("Thread-B");
		task2.start();
		
		// call a runner
		TaskRunner tr2 = new TaskRunner("Runner-B");
		tr2.run();
	}
}

class Task extends Thread {
	String name;
	
	public Task(String name) {
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

class TaskRunner implements Runnable {
	String name;
	
	public TaskRunner(String name) {
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
