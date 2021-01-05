package com.ycic.practice;

public class AppSequence {

	public static void main(String[] args) {
		SequenceDemo sequence = new SequenceDemo();
		/*
		for (int i=0; i < 100; i++) {
			System.out.println(sequence.getNext());
		} */
		
		Worker worker1 = new Worker(sequence);
		worker1.start();
		
		Worker worker2 = new Worker(sequence);
		worker2.start();
	}
}

class Worker extends Thread {
	SequenceDemo sequence = null;
	
	public Worker(SequenceDemo sequence) {
		this.sequence = sequence;
	}
	
	@Override
	public void run() {
		for (int i=0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " - " + sequence.getNext());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}