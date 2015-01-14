/**
 * DeadlockTest.java
 * Class DeadlockTest which implements runnable and is our test class for enforcing deadlock.
 * 
 *  @version   $Id: DeadlockTest.java,v 1.0 2014/03/12 6:00pm $
 * 
 * @author Sreeraj Paleri
 * @author Eric Fortunato
 * 
 *
 */
public class DeadlockTest implements Runnable {

	Object objA; //object A for resource sharing
	Object objB; //object B for resource sharing
	Object objC; //object C for awaking both threads
	
	/*
	 * Constructor
	 * 
	 * Description: It initializes our objects A and B and C
	 */
	DeadlockTest(Object newObject, Object anotherObject, Object lastObject){
		this.objA=newObject;
		this.objB=anotherObject;
		this.objC=lastObject;
	}
	
	/*
	 * This method uses synchronization for acquiring lock in object A while using C
	 */
	public  void  getResourceA(){
		System.out.println(Thread.currentThread().getName() + " before acquiring lock");
		synchronized(objA){
			System.out.println(Thread.currentThread().getName() + " inside block A Resource A");
			doSomething();
			synchronized(objC){
				System.out.println(Thread.currentThread().getName()+ " inside block C Resource A");
				doSomething();
				try{
					System.out.println("Before waiting in Resource A for C");
					if(!(Thread.currentThread().getName().equals("B"))){
						DeadlockTest testB = new DeadlockTest(objA, objB, objC);
						new Thread(testB, "B").start();
						
					}
					objC.wait();
					System.out.println(Thread.currentThread().getName() + " Awake!");
						
				}catch(InterruptedException ie){
					ie.getMessage();
				}
				
			}
			System.out.println(Thread.currentThread().getName() + " Awake and waiting for B!");
			synchronized(objB){
				System.out.println("Already in a deadlock");
			}
		}
	}
	
	/*
	 * This method uses synchronization for acquiring lock in object B while using C
	 */
public  void  getResourceB(){
	System.out.println(Thread.currentThread().getName() + " before acquiring lock");
	synchronized(objB){
		System.out.println(Thread.currentThread().getName() + " inside block B Resource B");
		doSomething();
		synchronized(objC){
			try{
			System.out.println(Thread.currentThread().getName() + " inside block C Resource B");
			doSomething();		
			System.out.println("Before notifying in Resource B for C");
			objC.notify();						
			}catch(Exception ie){
				ie.getMessage();
			}
		}
		System.out.println(Thread.currentThread().getName() + " waiting for A");
		synchronized(objA){
			System.out.println("Already in a deadlock");
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
		Object third = new Object();
		DeadlockTest test = new DeadlockTest(first, second, third);
		new Thread(test, "A").start();
	}
}
