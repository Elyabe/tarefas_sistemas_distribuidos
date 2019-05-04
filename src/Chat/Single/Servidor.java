package Chat.Single;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	private int porta;
	private ServerSocket socket;
	
	public Servidor(int porta ) {
		this.porta = porta;
	}
	
     public static void main(String[] args) throws IOException {
         int porta = 8080;
    	 Servidor server = new Servidor(porta);
         server.iniciar();
     }
     
     public void iniciar() throws IOException
     {

    	 this.socket = new ServerSocket(this.porta);
         System.out.println("Ouvindo na porta " + this.porta );

         System.out.println("Servidor pronto:");
         Socket cliente = socket.accept( );                          
                          
//       Lendo do teclado
         BufferedReader leitorEntrada = new BufferedReader(new InputStreamReader(System.in));
   	                      
//       Enviando ao cliente
         OutputStream streamSaida = cliente.getOutputStream(); 
         PrintWriter saida = new PrintWriter(streamSaida, true);
    
//       Para receber mensagem do cliente  
         InputStream istream = cliente.getInputStream();
         BufferedReader leitorReceptor = new BufferedReader(new InputStreamReader(istream));
    
         String msgRecebida, msgEnviar;               
         while(true)
         {
           if((msgRecebida = leitorReceptor.readLine()) != null)  
              System.out.println(msgRecebida);         

           msgEnviar = leitorEntrada.readLine(); 
           saida.println(msgEnviar);             
           saida.flush();
         }               
       }   
     }