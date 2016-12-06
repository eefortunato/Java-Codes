package rmistock;

import java.rmi.*;

public interface StockInfo extends java.rmi.Remote {
  void register(StockUpdate o) throws RemoteException;
  void unregister(StockUpdate o) throws RemoteException;
}
