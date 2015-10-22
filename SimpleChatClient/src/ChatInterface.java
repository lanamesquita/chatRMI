import java.rmi.*;
import java.util.List;
 
public interface ChatInterface extends Remote{
	public String getName() throws RemoteException;
	public void send(String msg) throws RemoteException;
	public List<ChatInterface> getClients() throws RemoteException;
	public void newClient(ChatInterface client) throws RemoteException;
	public void removeClient(ChatInterface client) throws RemoteException;
	public int getNumberMessage() throws RemoteException;
	public void updateClients() throws RemoteException;
}