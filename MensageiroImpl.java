import java.rmi.RemoteException;  
import java.rmi.server.UnicastRemoteObject;  
  
public class MensageiroImpl extends UnicastRemoteObject implements Mensageiro {

	String msg;  

    public MensageiroImpl() throws RemoteException {
        super(); 
        msg = new String(); 
    }  
  
    public void enviarMensagem( String msg ) throws RemoteException {  
        System.out.println(msg); 
        this.msg = msg; 
    }   

    public void receberMensagem( ) throws RemoteException {  
        System.out.println(this.msg);  
    } 
}  