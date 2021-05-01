package multithread;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ProducerConsumer {
	
	public static void main(String[] args) {
		
		int coreNum = 4;
		ExecutorService executor = new ThreadPoolExecutor(coreNum * 2, coreNum * 15, 1, 
				TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
		
		File f = new File("./");
		File[] files = f.listFiles();
		CountDownLatch finishSignal = new CountDownLatch(files.length);
		for(File file : files) {
			executor.submit(new FileTask(file, finishSignal));
		}
		
		try {
			finishSignal.await();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		return;
	}
	
	private static class FileTask implements Runnable {

		private final File f;
		private final CountDownLatch finishSignal;
		
		public FileTask(File f, CountDownLatch finishSignal) {
			super();
			this.f = f;
			this.finishSignal = finishSignal;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(f.getAbsolutePath());
			this.finishSignal.countDown();
		}
		
		
		
	}

}
