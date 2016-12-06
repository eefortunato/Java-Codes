public class T_1 extends Thread	{
	static int x = 0;
	String info = "";

	public T_1 (String info) {
		this.info = info;
	}

	public void run () {
		x++;
		System.out.println(info + ": " + x);
		x++;
	}

	public static void main (String args []) {
		
		new T_1("x").start();
		new T_1("y").start();
		try{
			//x.join();
			}catch(Exception InterruptedThread){
				InterruptedThread.getMessage();
			}
			
	}
}
