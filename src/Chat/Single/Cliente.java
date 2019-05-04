package Chat.Single;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

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

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

//		Enviando para cliente
		OutputStream streamSaida = socket.getOutputStream(); 
		PrintWriter saida = new PrintWriter(streamSaida, true);
		
//		Para receber msg do servidor
		InputStream streamEntrada = socket.getInputStream();
		BufferedReader leitorReceptor = new BufferedReader(new InputStreamReader(streamEntrada));
		
		System.out.println("Cliente pronto.");
		
		String msgRecebida;
		String msgEnviar;     
		
		boolean escutar = true;
		
		while(escutar)
		{
			msgEnviar = entrada.readLine();  
			saida.println(msgEnviar);       
			saida.flush();                    
			if((msgRecebida = leitorReceptor.readLine()) != null) 
			{
				System.out.println(msgRecebida); 
			}
			
			if ( msgEnviar.length() == 0 )
				escutar = false;
		}   
		
		System.out.println("Cliente saiu da conversa.");
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