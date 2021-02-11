package multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrder1114 {

	private String name = "1114. Print in Order";
	private String url = "https://leetcode.com/problems/print-in-order/";
	
	public static void main(String[] args) {
		
		Foo3 foo = new Foo3();
		PrintFirst printFirst = new PrintFirst();
		PrintSecond printSecond = new PrintSecond();
		PrintThird printThird = new PrintThird();
		
		Thread t1 = new Thread( () -> {
			try {
				foo.first(printFirst);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread( () -> {
			try {
				foo.second(printSecond);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t3 = new Thread( () -> {
			try {
				foo.third(printThird);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	
	public static class PrintFirst implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.print("first");
		}
		
	}
	
	public static class PrintSecond implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.print("second");
		}
		
	}
	
	public static class PrintThird implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.print("third");
		}
		
	}
	
	public static class Foo {

		private volatile boolean first = false;
		private volatile boolean second = false;
		
	    public Foo() {
	        
	    }

	    public void first(Runnable printFirst) throws InterruptedException {
	        
	        // printFirst.run() outputs "first". Do not change or remove this line.
	        printFirst.run();
	        this.first = true;
	    }

	    public void second(Runnable printSecond) throws InterruptedException {
	        
	    	while(this.first == false) {
	    		
	    	}
	        // printSecond.run() outputs "second". Do not change or remove this line.
	        printSecond.run();
	        this.second = true;
	    }

	    public void third(Runnable printThird) throws InterruptedException {
	        
	    	while(this.second == false) {
	    		
	    	}
	        // printThird.run() outputs "third". Do not change or remove this line.
	        printThird.run();
	    }
	    
	}
	
	public static class Foo2 {

		private int value = 1;
		
	    public Foo2() {
	        
	    }

	    public synchronized void first(Runnable printFirst) throws InterruptedException {
	        
	        // printFirst.run() outputs "first". Do not change or remove this line.
	        printFirst.run();
	        this.value = 2;
	        this.notifyAll();
	        
	        return;
	    }

	    public synchronized void second(Runnable printSecond) throws InterruptedException {
	        
	    	while(this.value != 2) {
	    		this.wait();
	    	}
	        // printSecond.run() outputs "second". Do not change or remove this line.
	        printSecond.run();
	        this.value = 3;
	        this.notifyAll();
	    }

	    public synchronized void third(Runnable printThird) throws InterruptedException {
	        
	    	while(this.value != 3) {
	    		this.wait();
	    	}
	        // printThird.run() outputs "third". Do not change or remove this line.
	        printThird.run();
	    }
	    
	}
	
	public static class Foo3 {

		private volatile int value = 1;
		private final Lock lock = new ReentrantLock();
		private final Condition condition = lock.newCondition();
		
	    public Foo3() {
	        
	    }

	    public void first(Runnable printFirst) throws InterruptedException {
	        
	    	lock.lock();
	    	try {
		        // printFirst.run() outputs "first". Do not change or remove this line.
		        printFirst.run();
		        this.value = 2;
		        condition.signalAll();
	    	} finally {
	    		lock.unlock();
	    	}
	        
	        return;
	    }

	    public void second(Runnable printSecond) throws InterruptedException {
	        
	    	lock.lock();
	    	try {
		    	while(this.value != 2) {
		    		condition.await();
		    	}
		        // printSecond.run() outputs "second". Do not change or remove this line.
		        printSecond.run();
		        this.value = 3;
		        condition.signalAll();
	    	} finally {
	    		lock.unlock();
	    	}
	    }

	    public void third(Runnable printThird) throws InterruptedException {
	        
	    	lock.lock();
	    	try {
		    	while(this.value != 3) {
		    		condition.await();
		    	}
		        // printThird.run() outputs "third". Do not change or remove this line.
		        printThird.run();
	    	} finally {
	    		lock.unlock();
	    	}
	    }
	    
	}
}
