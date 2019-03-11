package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatClienteInterface extends Remote {
	
	void retrieveMessage(String mensagem) throws RemoteException;

}
