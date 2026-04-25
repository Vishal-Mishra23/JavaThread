package threads.ThreadsPractice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, ExecutionException
    {
//    	AtomicInteger value = new AtomicInteger(5);
//    	Threds task = new Threds(value);
//    	Threds task1 = new Threds(value);
//    	Threds task2 = new Threds(value);
//    	Threds task3 = new Threds(value);
//    	Threds task4 = new Threds(value);
    	
//    	Thread th = new Thread(task);
//    	Thread th1 = new Thread(task);
//    	Thread th2 = new Thread(task);
//    	Thread th3 = new Thread(task);
//    	Thread th4 = new Thread(task);
//    	
//    	th.start();
//    	th1.start();
//    	th3.start();
//    	th2.start();
//    	th4.start();
//    	
//    	th.join();
//    	th1.join();
//    	th3.join();
//    	th2.join();
//    	th4.join();
//    	Thread th4 = new Thread(task);
    	
//    	final int Num_Core = Runtime.getRuntime().availableProcessors();
//    	System.out.println(Num_Core);
    	//Integer sum =0;
//    	ExecutorService executor= Executors.newCachedThreadPool(); 
//    	for(int i=0 ; i<100000 ; i++) {
//    		executor.execute(()->{
//    			int result = performComputation();
//    			System.out.println(Thread.currentThread().getName()+"result"+result);
//    		});
//    	}
//    	executor.shutdown();
//    	Thread th  = new Thread(new Threds());
//    	Future <String> ft = executor.submit(th);
//    	ft.get();
//    	th.start();
//    	th.join();
//    	Thread.sleep(1000);
//    	executor.wait(100000000);
//    	ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, 
//    								new ArrayBlockingQueue<Runnable>(10),new ThreadPoolExecutor.AbortPolicy());
//    	for(int i=0 ; i<10 ; i++) {
//    		executor.execute(()->{
//    			int result = performComputation();
//    			try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {
//					Thread.currentThread().interrupt();
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//    			System.out.println(Thread.currentThread().getName()+"result"+result);
//    		});
//    	}
//    	executor.shutdown();
//        System.out.println( "Hello World!");
//        ReentrantLock lock = new ReentrantLock();
//        final int Num_Core = Runtime.getRuntime().availableProcessors();
//    	System.out.println(Num_Core);
//    	 AtomicInteger num = new AtomicInteger(5);
//    	ExecutorService executor= Executors.newCachedThreadPool(); 
//    	for(int i=0 ; i<5 ; i++) {
//    	executor.submit(new threadWithLock(num, lock));
////    	 System.out.println(num);
//    	}
//    	
//    	executor.shutdown();
//    	Thread.sleep(10000);
//    	System.out.println(Thread.currentThread().getName()+" "+num);
//        executor.shutdown();
        
        
        //Read-Write Lock
        
        ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
        ReadLock relock = rwlock.readLock();
        WriteLock wrlock = rwlock.writeLock();
        
        
    }
    private static int performComputation() {
    	int sum=0;
    	for(int i=0;i<100000;i++) {
    		
    		sum+=Math.sqrt(i);
    	}
    	return sum;
    }
}
