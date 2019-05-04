package Chat.Single;

import java.net.ServerSocket;

public class Servidor {

	private ServerSocket servidor;
	private int porta;
	
	public Servidor(int _porta) {
		this.porta = _porta;
	}
	
	public static void main(String[] args) {
		Servidor servidor_chat = new Servidor(465);
		
		System.out.println("Servidor Criado");
	}
}
