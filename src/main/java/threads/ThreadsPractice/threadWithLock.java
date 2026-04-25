package threads.ThreadsPractice;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class threadWithLock implements Runnable {
	AtomicInteger value;
	Lock lock;

	public threadWithLock(AtomicInteger value, Lock lock) {
		super();
		this.lock = lock;
		this.value = value;
	}

//
//	@Override
//	public void run() {
//		try {
//			Thread.sleep(1000);
//			sqrt(value);
//		} catch (InterruptedException e) {
//			Thread.currentThread().interrupt();
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		// TODO Auto-generated method stub
//		
//	}
	@Override
	public void run() {
		try {
			lock.lock();
			try {

				Thread.sleep(1000);
				value.addAndGet(5);
				System.out.println(value.toString());
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {
			lock.unlock();
		}

		// TODO Auto-generated method stub

	}

	public int sqrt(int val) {

		lock.lock();
		try {
			val += 5;
		} finally {
			lock.unlock();
		}
		// System.out.println(Thread.currentThread().getName() + " " + Math.sqrt(val));

		return val;

	}

//	@Override
//	public Integer call() throws Exception {
//		//Thread.sleep(1000);
//		return sqrt(value);
//		//return 0;
//
//		// TODO Auto-generated method stub
//
//	}

}
