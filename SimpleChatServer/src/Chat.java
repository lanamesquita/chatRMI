import java.rmi.*;
import java.rmi.server.*;
import java.util.List;
import java.util.ArrayList;
 
public class Chat extends UnicastRemoteObject implements ChatInterface  {
 
	private static final long serialVersionUID = 5179276649815567504L;
	public String name;
	public ChatInterface client=null;
	public int numberMessage=-1;

	private List<ChatInterface> clients = new ArrayList<ChatInterface>();
 
	public Chat(String n)  throws RemoteException { 
		this.name=n;   
	}
	public String getName() throws RemoteException {
		return this.name;
	}

	public List<ChatInterface> getClients() throws RemoteException{
		return clients;
	}

	public int getNumberMessage() throws RemoteException{
		return numberMessage;
	}
 
	public void send(String s) throws RemoteException{
		System.out.println(s);
		numberMessage = numberMessage+1;
	}	

	public void newClient(ChatInterface client) throws RemoteException {
		send("["+client.getName()+"] entá no chat!");
		clients.add(client);
	}

	public void removeClient(ChatInterface client) throws RemoteException{
		send("["+client.getName()+"] saiu do chat!");
		clients.remove(client);
	}

	public void updateClients() throws RemoteException{
		List<ChatInterface> aux = clients;
		for(ChatInterface c:aux){
			if(c.equals(null)){
		    	removeClient(c);				
		    }
		 }
	}
}