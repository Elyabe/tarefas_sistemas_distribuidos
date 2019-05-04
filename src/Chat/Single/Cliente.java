package Chat.Single;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    
	private String ip;
	private int porta;
	private Socket socket;
	
	public Cliente(String ip, int porta ) 
	{
		this.porta = porta;
		this.ip = ip;
		this.socket = null;
	}

	public static void main(String[] args) throws UnknownHostException, IOException 
    {
		 Cliente client = new Cliente("127.0.0.1", 8080 );
				 
		 client.conectarServidor();
    }
	
	public void conectarServidor() throws UnknownHostException, IOException
	{
		this.socket = new Socket(this.ip, this.porta);
		
		System.out.println("Cliente conseguiu se conectar!");

        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(socket.getOutputStream());

        while (teclado.hasNextLine()) {
            saida.println(teclado.nextLine());
        }

        saida.close();
        teclado.close();
        socket.close();

	}
	
	
	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public int getPorta() {
		return porta;
	}


	public void setPorta(int porta) {
		this.porta = porta;
	}


	public Socket getSocket() {
		return socket;
	}


	public void setSocket(Socket socket) {
		this.socket = socket;
	}


     }