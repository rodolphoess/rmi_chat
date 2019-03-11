package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.ChatClienteInterface;

public interface ChatServerInterface extends Remote {
	
	void registrarClienteChat(ChatClienteInterface chatCliente) throws RemoteException;
	
	void enviarMensagem(String mensagem) throws RemoteException;

}
