package com.caojian.dao.test;

public class TestThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestThread().run();
	}

	private void run() {
		Thread t1 = new Thread(new Thread1());
		Thread t2 = new Thread(new Thread2());
		t1.start();
		t2.start();
	}

}
