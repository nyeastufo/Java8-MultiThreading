package com.ycic.practice;

public class SequenceDemo {
	
	private int value = 0;

	public int getNext() {
		//value++;
		// return value;
		// sync means do it all or nothing, no pausing, it is a lock
		synchronized(this) {
			value = value + 1;
			return value;
		}
	}	
}
