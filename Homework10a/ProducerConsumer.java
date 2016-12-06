
public class ProducerConsumer implements Runnable {

		  static int itemCounter = 0;
		  final static String factory = "o";
		  static String itemStatus = "false";
		  String info;
		  
		  public ProducerConsumer(String objectName )  {
		        this.info = objectName;
		  }
		  
		  void producerFactory(String producerInfo){
			  if(producerInfo=="Producer" && itemStatus=="true"){
	        		System.out.print("P/0" + " ");
	        	}
			  else if(this.info=="Producer" && itemStatus=="false"){
	        		itemStatus="true";
	        		itemCounter++;
	        		System.out.print("P/" + itemCounter + "  ");	        		
	        	}
		  }
		  void consumerShop(String consumerInfo){
		 
			  if(this.info=="Consumer" && itemStatus=="true"){
	        		itemStatus="false";
	        		System.out.print("C/" + itemCounter + "  ");
	        	}			  
			  else if(this.info=="Consumer" && itemStatus=="false"){
	        		System.out.print("C/0" + "  ");
	        	}
		  }

		  public  void producedElement() {
			 
			  synchronized (factory){
			  		
				  if(this.info == "Producer"){
					  producerFactory(this.info);
				  }
				  else if(this.info == "Consumer"){
					  consumerShop(this.info);
				  }				 
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
