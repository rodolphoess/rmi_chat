package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import client.ChatClienteInterface;

public class ChatServer extends UnicastRemoteObject implements ChatServerInterface {

	private static final long serialVersionUID = 1L;
	
	private List<ChatClienteInterface> clientesChat;
	
	protected ChatServer() throws RemoteException {
		clientesChat = new ArrayList<ChatClienteInterface>();
	}

	public synchronized void registrarClienteChat(ChatClienteInterface chatCliente) throws RemoteException {
		this.clientesChat.add(chatCliente);
	}

	public synchronized void enviarMensagem(String mensagem) throws RemoteException {
		int i = 0;
		while (i < clientesChat.size()) {
			clientesChat.get(i++).retrieveMessage(mensagem);
		}
	}

}
