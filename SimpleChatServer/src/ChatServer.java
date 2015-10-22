import java.rmi.*;
import java.util.*;
 
public class ChatServer {
public static void main (String[] argv) {
    try {
	    	System.setSecurityManager(new RMISecurityManager());
	    	@SuppressWarnings("resource")
			Scanner s=new Scanner(System.in);
	    	System.out.println("Digite o nome:");
	    	String name=s.nextLine().trim();

	    	List<ChatInterface> clients = new ArrayList<ChatInterface>();

 
	    	Chat server = new Chat(name);	
 
	    	Naming.rebind("chat", server);
 
	    	System.out.println("Chat aberto!");
 
	    	while(true){
	    		String msg=s.nextLine().trim();
	    		server.updateClients();
	    		if (!server.getClients().isEmpty()){
	    			msg="Mensagem - " + server.getName() + ": " + msg;

	    			clients = server.getClients();
	    			for(ChatInterface c:clients){
	    				c.send(msg);
	    			}
	    		}	
	    	}
 
    	}catch (Exception e) {
    		System.out.println("Chat Erro: " + e);
    	}
	}
}