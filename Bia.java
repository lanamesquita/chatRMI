import java.rmi.Naming;
import java.rmi.RemoteException;  
import java.rmi.NotBoundException;  
import java.net.MalformedURLException;   
import java.util.Scanner; 
  
public class Bia {  
  // servidor

    public static void main(String[] args) {  
        try {
            String identity = "[Bia] ";
            System.out.println(identity + " Iniciando o Chat...");  
            
            // seta o servidor para enviar mensagem  
            Mensageiro server = new MensageiroImpl();
            Naming.rebind("rmi://localhost/MensageiroBia", server);

            // seta o cliente para receber a mensagem
            Mensageiro client = (Mensageiro) Naming.lookup("rmi://localhost/MensageiroCarlos" );
            
            Scanner input = new Scanner(System.in);
            String line = new String();
            while(true){
                if(input.hasNext()){
                    line = identity + input.nextLine().trim();
                    client.enviarMensagem(line);
                }
            }  
        }  
        catch( MalformedURLException e ) {  
            System.out.println();  
            System.out.println( "MalformedURLException: " + e.toString() );  
        }  
        catch( RemoteException e ) {  
            System.out.println();  
            System.out.println( "RemoteException: " + e.toString() );  
        }  
        catch( Exception e ) {  
            System.out.println();  
            System.out.println( "Exception: " + e.toString() );  
        }  
    }  
}  