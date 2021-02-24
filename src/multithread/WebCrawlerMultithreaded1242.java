package multithread;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class WebCrawlerMultithreaded1242 {

	private String name = "1195. Fizz Buzz Multithreaded";
	private String url = "https://leetcode.com/problems/fizz-buzz-multithreaded/";
	
	public static void main(String[] args) {
	
		String startUrl = "http://news.yahoo.com/news/topics/";
		WebCrawlerMultithreaded1242 webCrawler = new WebCrawlerMultithreaded1242();
		List<String> urls = webCrawler.crawlConcurrent(startUrl, new HtmlParser());
		
		for(String url : urls) {
			System.out.println(url);
		}
		
		return;
	}
	
	
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        
    	String hostname = getHostname(startUrl);
    	String currentUrl;
    	Set<String> result = new HashSet<>();
    	result.add(startUrl);
    	List<String> returnUrls;
    	
    	Queue<String> q = new LinkedList<>();
    	q.add(startUrl);
    	while(!q.isEmpty()) {
    		currentUrl = q.poll();
    		returnUrls = htmlParser.getUrls(currentUrl);
    		for(String url : returnUrls) {
    			if(result.contains(url)) {
    				continue;
    			}
    			if(getHostname(url).equals(hostname)) {
    				q.add(url);
    				result.add(url);
    			}
    		}
    	}
    	
    	return result.stream().collect(Collectors.toList());
    }
    
    public List<String> crawlConcurrent(String startUrl, HtmlParser htmlParser) {
        
    	String hostname = getHostname(startUrl);
    	
    	Set<String> result = new CopyOnWriteArraySet<>();   	  	
    	AtomicInteger threadNumber = new AtomicInteger(0);
       	ExecutorService executor = Executors.newFixedThreadPool(100);
    	
    	ParseContext context = new ParseContext(htmlParser, hostname, executor, result, threadNumber);
    	
		executor.submit(new ParseTask(startUrl, context));
		threadNumber.incrementAndGet();
		result.add(startUrl);  
    	
    	while(threadNumber.get() > 0 ) {
    		try {
    			Thread.sleep(2);
    		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	executor.shutdown();
    	
    	return result.stream().collect(Collectors.toList());
    }
    
    private static class ParseTask implements Runnable {
    	
    	private ParseContext context;
    	private String currentUrl;
    	
    	public ParseTask(String currentUrl, ParseContext context) {
    		this.context = context;
    		this.currentUrl = currentUrl;
    	}
    	
    	@Override
        public void run() {
			List<String> returnUrls = context.htmlParser.getUrls(currentUrl);
    		for(String url : returnUrls) {
    			if(context.result.contains(url)) {
    				continue;
    			}
    			if(getHostname(url).equals(context.hostname)) {
    				context.executor.submit(new ParseTask(url, context));
    				context.threadNumber.incrementAndGet();
    				context.result.add(url);
    			}
    		}
    		context.threadNumber.decrementAndGet();
    		//System.out.println(currentUrl);
        }
    	
    }
    
    private static class ParseContext {
    	
    	public HtmlParser htmlParser;
    	public String hostname;
		public ExecutorService executor;
    	public Set<String> result;
    	public AtomicInteger threadNumber;
    	
    	/**
		 * @param htmlParser
		 * @param hostname
		 * @param executor
		 * @param result
		 * @param threadNumber
		 */
		public ParseContext(HtmlParser htmlParser, String hostname, ExecutorService executor, Set<String> result,
				AtomicInteger threadNumber) {
			super();
			this.htmlParser = htmlParser;
			this.hostname = hostname;
			this.executor = executor;
			this.result = result;
			this.threadNumber = threadNumber;
		}

    }
    
    private static String getHostname(String url) {
    	
    	
    	return url.strip().split("//")[1].split("/")[0];
    }
	
	private static class HtmlParser {
		
		private String[] urls = new String[] {
			  "http://news.yahoo.com",
			  "http://news.yahoo.com/news",
			  "http://news.yahoo.com/news/topics/",
			  "http://news.google.com",
			  "http://news.yahoo.com/us"
		};
		
		private int index = 0;
		
		public List<String> getUrls(String url) {
			
			List<String> urlList = new ArrayList<>();
			for(int i = 0; i < 2; i++) {
				if(index + i >= this.urls.length) {
					break;
				}
				urlList.add(this.urls[this.index + i]);
			}
			this.index = this.index + 2;
			
			return urlList;
		}
		
	}
	
	
}
