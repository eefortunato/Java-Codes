
public class ProducerConsumer implements Runnable {

		  static int itemCounter = 0;
		  static boolean itemStatus = false;
		  String info;
		  static int producerCounter = 0;
		  static int consumerCounter = 0;
		 
		 
		 

		  
		  public ProducerConsumer(String objectName )  {
		        this.info = objectName;
		  }


		  public  void producedElement() {
			 synchronized (info){
			  		/*try{
		        		info.notify();	
		        	}catch(Exception ie){
		        		ie.getMessage();
		        	}*/
		        	if (this.info=="Producer" && producerCounter == consumerCounter){
		        		itemStatus=true;
		        		itemCounter++;
		        		producerCounter++;
		        		
		        		System.out.print("P/" + itemCounter + "  ");
		        	}
		        	else if (this.info=="Producer" && producerCounter < consumerCounter){
		        		itemStatus=true;
		        		itemCounter++;
		        		
		        		System.out.print("P/" + itemCounter + "  ");
		        	}
		        	
		        	else if(this.info=="Consumer" && itemStatus==true && consumerCounter < producerCounter){
		        		consumerCounter++;
		        		System.out.print("C/" + itemCounter + "  ");
		        	}
		        	
		        	/*try{
		        		info.wait();	
		        	}catch(InterruptedException ie){
		        		ie.getMessage();
		        	} 
		        	*/       	
			  }
		        
		  }
		  

		  public void run()     {
		        producedElement();
		  }

		  public static void main(String args[] )       {
		            
			  ProducerConsumer newProducer = new ProducerConsumer("Producer");			 
			  ProducerConsumer newConsumer = new ProducerConsumer("Consumer");
			  
			  while(true){
				  new Thread(newProducer).start();
				  new Thread(newConsumer).start();  
			  }
			
			  
		        
		  }
		 

}
