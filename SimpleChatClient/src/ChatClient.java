import java.rmi.*;
import java.util.*;
 
public class ChatClient {
	
	String clientName;
	
	public static void main (String[] argv) {
	    try {

	    		List<ChatInterface> otherClients = new ArrayList<ChatInterface>();

		    	System.setSecurityManager(new RMISecurityManager());
		    	@SuppressWarnings("resource")
				Scanner s=new Scanner(System.in);
		    	System.out.println("Digite o nome:");
		    	String name=s.nextLine().trim();		    		    	
		    	ChatInterface client = new Chat(name);
 
		    	ChatInterface server = (ChatInterface)Naming.lookup("chat");
		    	String msg="";

		    	System.out.println("Chat aberto!");
		    	server.newClient(client);
 
		    	while(true){
		    		msg=s.nextLine().trim();
		    		msg="Mensagem "+server.getNumberMessage()+" - "+client.getName()+": "+msg;		    		
	    			server.send(msg);
	    			
	    			server.updateClients();
	    			
	    			otherClients = server.getClients();
	    			for(ChatInterface c:otherClients){
	    				if(!c.equals(client))
	    					c.send(msg);
	    			}
		    	}
 
	    	}catch (Exception e) {
	    		System.out.println("Chat Erro: " + e);
	    	}
		}

}