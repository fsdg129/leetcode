package multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class FizzBuzzMultithreaded1195 {

	private String name = "1195. Fizz Buzz Multithreaded";
	private String url = "https://leetcode.com/problems/fizz-buzz-multithreaded/";
	
	public static void main(String[] args) {
		
		FizzBuzz fizzBuzz = new FizzBuzz(15);
		
		PrintFizz printFizz = new PrintFizz();
		PrintBuzz printBuzz = new PrintBuzz();
		PrintFizzBuzz printFizzBuzz = new PrintFizzBuzz();
		PrintNumber printNumber = new PrintNumber();

		
		Thread t1 = new Thread( () -> {
			try {
				fizzBuzz.fizz(printFizz);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread( () -> {
			try {
				fizzBuzz.buzz(printBuzz);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t3 = new Thread( () -> {
			try {
				fizzBuzz.fizzbuzz(printFizzBuzz);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t4 = new Thread( () -> {
			try {
				fizzBuzz.number(printNumber);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
	
	
	private static class PrintFizz implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("fizz");
		}
		
	}
	
	private static class PrintBuzz implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("buzz");
		}
		
	}
	
	private static class PrintFizzBuzz implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("fizzbuzz");
		}
		
	}
	
	private static class PrintNumber implements IntConsumer {

		@Override
		public void accept(int value) {
			// TODO Auto-generated method stub
			System.out.println(value);
			
		}
		
	}
	
	private static class FizzBuzz {
		
	    private int n;
	    private int threashold;
	    private final Lock lock = new ReentrantLock();
	    private final Condition condition = lock.newCondition();

	    public FizzBuzz(int n) {
	        this.n = 1;
	        this.threashold = n;
	    }

	    // printFizz.run() outputs "fizz".
	    public void fizz(Runnable printFizz) throws InterruptedException {
	        
	    	lock.lock();
	    	try {
		    	while( !(this.n % 3 == 0 && this.n % 5 != 0) && this.n <= this.threashold ) {
	    			condition.await();
	    		}
		    	if(this.n > this.threashold) {
		    		//System.out.println("Buzz End");
		    		condition.signalAll();
		    		return;
		    	} 
	    		printFizz.run();
	    		this.n++;
	    		condition.signalAll();

	    	} finally {
	    		lock.unlock();
	    	}
	    	
	    	this.fizz(printFizz);

	    	return;
	    }

	    // printBuzz.run() outputs "buzz".
	    public void buzz(Runnable printBuzz) throws InterruptedException {
	        
	    	lock.lock();
	    	try {

		    	while( !(this.n % 3 != 0 && this.n % 5 == 0) && this.n <= this.threashold ) {
	    			condition.await();
	    		}
		    	if(this.n > this.threashold) {
		    		//System.out.println("Fizz End");
		    		condition.signalAll();
		    		return;
		    	} 
	    		printBuzz.run();
	    		this.n++;
	    		condition.signalAll();

	    	} finally {
	    		lock.unlock();
	    	}
	    	
	    	this.buzz(printBuzz);

	    	return;
	    }

	    // printFizzBuzz.run() outputs "fizzbuzz".
	    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
	    	lock.lock();
	    	try {

	    		while( !(this.n % 3 == 0 && this.n % 5 == 0) && this.n <= this.threashold ) {
	    			condition.await();
	    		}
		    	if(this.n > this.threashold) {
		    		//System.out.println("FizzBuzz End");
		    		condition.signalAll();
		    		return;
		    	} 
	    		printFizzBuzz.run();
	    		this.n++;
	    		condition.signalAll();

	    	} finally {
	    		lock.unlock();
	    	}
	    	
	    	this.fizzbuzz(printFizzBuzz);

	    	return;
	    }

	    // printNumber.accept(x) outputs "x", where x is an integer.
	    public void number(IntConsumer printNumber) throws InterruptedException {
	    	lock.lock();
	    	try {

		    	
		    	while( !(this.n % 3 != 0 && this.n % 5 != 0) && this.n <= this.threashold ) {
	    			condition.await();
	    		}
		    	if(this.n > this.threashold) {
		    		//System.out.println("Number End");
		    		condition.signalAll();
		    		return;
		    	} 
	    		printNumber.accept(this.n);
	    		this.n++;
	    		condition.signalAll();

	    	} finally {
	    		lock.unlock();
	    	}
	    	
	    	this.number(printNumber);

	    	return;        
	    }
	}
	
	
}
