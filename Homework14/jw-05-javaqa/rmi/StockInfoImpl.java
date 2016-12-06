package rmistock;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.LocateRegistry;
import java.util.*;

public class StockInfoImpl extends UnicastRemoteObject
                           implements StockInfo, Runnable {
  private Vector clients = new Vector();
  private String[] stocks = { "SUNW", "IBM" };

  public StockInfoImpl() throws RemoteException { }

  public void run() {
    double price = 5.0;

    while (true) {
      // send an updated price for all stocks to each client
      for (int i = 0; i < stocks.length; i++) {
        String symbol = stocks[i];
        for (Enumeration e = clients.elements() ; e.hasMoreElements() ;) {
          StockUpdate client = (StockUpdate) e.nextElement();
          try {
            client.update(symbol, "" + price);
          }
          catch (RemoteException ex) {
            System.out.println("update to client " + client + " failed.");
            try {
              unregister(client);
            }
            catch (RemoteException rex) {
              System.err.println("Big trouble.");
              rex.printStackTrace();
              System.exit(3);
            }
          }
        }
      }
      // set new price for next iteration
      if (price < 25.0)
        price += 0.25;
      else price = 5.0;
      // sleep for one second        
      try {
        Thread.sleep(1000);
      }
      catch (InterruptedException iex) { }
    }
  }
  
  public synchronized void register(StockUpdate o) throws RemoteException {
    if (!(clients.contains(o))) {
      clients.addElement(o);
      System.out.println("Registered new client " + o);
    }
  }
  
  public synchronized void unregister(StockUpdate o) throws RemoteException {
    if (clients.removeElement(o)) {
      System.out.println("Unregistered client " + o);
    } else {
      System.out.println("unregister: client " + o + "wasn't registered.");
    }
  }

  public static void main(String args[]) {
    System.setSecurityManager(new RMISecurityManager());
    try {
	    LocateRegistry.createRegistry(5001);
      StockInfoImpl sii = new StockInfoImpl();
	    Naming.rebind("//:5001/rmistock.StockInfo", sii);
      System.out.println("StockInfoImpl registered and ready");
      Thread updateThread = new Thread(sii, "StockInfoUpdate");
      updateThread.start();
    } catch (Exception e) {
       e.printStackTrace();
    }
  }
}
