package Chat.Single;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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

         Socket cliente = socket.accept();
         
         System.out.println("Cliente " + cliente.getInetAddress().getHostAddress() + " conectado");

        // Exibindo mensagem 
         Scanner entrada = new Scanner(cliente.getInputStream());
         while (entrada.hasNextLine()) {
             System.out.println(entrada.nextLine());
         }

         entrada.close();
         socket.close();

     }
     
     }