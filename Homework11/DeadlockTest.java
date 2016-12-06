/**
 * DeadlockTest.java
 * Class DeadlockTest which implements runnable and is our test class for enforcing deadlock.
 * 
 *  @version   $Id: DeadlockTest.java,v 1.0 2013/11/11 10:00am $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 * 
 *
 */
public class DeadlockTest implements Runnable {

	private Object objA; //object A for resource sharing
	private Object objB; //object B for resource sharing
	
	/*
	 * Constructor
	 * 
	 * Description: It initializes our objects A and B 
	 */
	DeadlockTest(Object newObject, Object anotherObject){
		this.objA=newObject;
		this.objB=anotherObject;
	}
	
	/*
	 * This method uses synchronization for acquiring lock in object A while using B
	 */
	public  void  getResourceA(){
		System.out.println(Thread.currentThread().getName() + " before acquiring lock");
		synchronized(objB){
			System.out.println(Thread.currentThread().getName() + " inside block B Resource A");
			doSomething();
			synchronized(objA){
				objB.notify();
				System.out.println(Thread.currentThread().getName() + " inside block A Resource A");
				doSomething();
				try{
					System.out.println("Before waiting in Resource A for B");
					objB.wait();	
				}catch(InterruptedException ie){
					ie.getMessage();
				}
				
			}
		}
	}
	
	/*
	 * This method uses synchronization for acquiring lock in object B while using A
	 */
public  void  getResourceB(){
	System.out.println(Thread.currentThread().getName() + " before acquiring lock");
	synchronized(objA){
		System.out.println(Thread.currentThread().getName() + " inside block A Resource B");
		doSomething();
		synchronized(objB){
			objA.notify();
			System.out.println(Thread.currentThread().getName() + " inside block B Resource B");
			doSomething();
			try{
				System.out.println("Before waiting in Resource B for A");
				objA.wait();	
			}catch(InterruptedException ie){
				ie.getMessage();
			}
		}
	}
	}

/*
 * This method prints the current thread working inside the synchronized blocks
 */
public void doSomething(){
	System.out.println("working in this block with object " + Thread.currentThread().getName());
}
	
	public void run (){
		if(Thread.currentThread().getName().equals("A")) {
			getResourceA();
		}
		else{
			getResourceB();
		}
	}
	
	/*
	 * This is our main method in which we create and test our object for the deadlock
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object first = new Object();
		Object second = new Object();
		DeadlockTest test = new DeadlockTest(first, second);
		DeadlockTest test2 = new DeadlockTest(first, second);
		Thread firstThread = new Thread(test, "A");
		Thread secondThread = new Thread(test2, "B");
		firstThread.start();
		secondThread.start();
	}
}
