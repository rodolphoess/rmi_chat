package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import server.ChatServerInterface;

public class ChatCliente extends UnicastRemoteObject implements ChatClienteInterface, Runnable {

	private static final long serialVersionUID = 1L;
	
	private ChatServerInterface chatServer;
	private String name = null;
	
	protected ChatCliente(String name, ChatServerInterface chatServer) throws RemoteException {
		this.name = name;
		this.chatServer = chatServer;
		
		chatServer.registrarClienteChat(this);
	}

	@Override
	public void retrieveMessage(String mensagem) throws RemoteException {
		System.out.println(mensagem);
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		String mensagem;
		while (true) {
			mensagem = scanner.nextLine();
			
			try {
				chatServer.enviarMensagem(name + ": " + mensagem);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
		}
	}
	

}
