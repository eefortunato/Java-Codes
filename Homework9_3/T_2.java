public class T_2 extends Thread	{
	static int x = 1;
	String info = "";

	public T_2 (String info) {
		this.info = info;
		x++;
	}

	public void run () {
		System.out.println(info + ": " + ++x);
	}

	public static void main (String args []) {
		
		new T_2("a").start();
		new T_2("b").start();
		try{
			//a.join();
		}catch(Exception InterruptedThread){
			InterruptedThread.getMessage();
		}
		
		//t2.start();
		//t3.start();
		
	}
}
