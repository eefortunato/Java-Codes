public class T_3 extends Thread    {
     int id = 1;
    static String  theValue  = "1";
    T_3(int id)       {
        this.id = id;
    }
    public void run () {
        if ( id == 1 )
                theValue = "3";
        else
                theValue = "2";
        
    }      
        
    public static void main (String args []) {
        T_3 t31 = new T_3(1);
        T_3 t32 = new T_3(2);
        t31.start();
        try{        	
        	t31.join();
        	}
        catch(Exception InterruptedThread){
        	InterruptedThread.getMessage();
        	} 
        t32.start();
        try{        	
        	t32.join();
        	}
        catch(Exception InterruptedThread){
        	InterruptedThread.getMessage();
        	}
          
        System.out.println("theValue = " + theValue );
        System.out.println("theValue = " + theValue );
    }       
}       
