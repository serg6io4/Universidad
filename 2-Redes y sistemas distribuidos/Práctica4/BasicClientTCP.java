import java.io.*;
import java.util.*;
import java.net.*;
public class BasicClientTCP 
{
    public static void main(String[] args) throws IOException 
    {
        try 
        {
        	Socket Socket = new Socket("192.168.43.159", 12345);

        	
        	BufferedReader in = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
		PrintWriter out = new PrintWriter(Socket.getOutputStream(),true);
        	Scanner scan= new Scanner(System.in);
        	if(Socket.isConnected()) {
        		System.out.println("Se ha iniciado la conexion al servidor");
        		System.out.println(in.readLine());//Recibo la bienvenida del Servidor
        		System.out.println("El servidor te ha permitido el acceso");

			String Letra;
        		String Text;
        		while(true) {
        		
        		System.out.println("Introduce letra: ");
        		Letra = scan.nextLine();
        		char comp = Letra.charAt(0);//paso a char porque tiene que leer una letra
        		out.print(comp + "\r\n");//envio una letra
        		out.flush();//limpio el buffer de envio
        		if(comp == 'f') {//Comparo el char con f ,una vez enviada la letra al servidor, para finalizar el socket cliente
        				System.out.println(in.readLine());
        					out.close();
        					in.close();
						scan.close();
        					Socket.close();
        					System.out.println("Cerrando conexion");
        				
        		}else {
        		
        		System.out.println("Introduce texto: ");
        		texto = scan.nextLine();//Escaneo la entrada de texto para el  envio
        		out.println(texto);
        		out.flush();
        		}
        		System.out.println("Conectado a "+ Socket.getLocalAddress()+":"+ Socket.getLocalPort()+ ", Esperando respuesta...");        		
        		System.out.println("Respuesta del servidor: "+ in.readLine());
        		
        		}
        		
        	}else {
        		out.close();
                	in.close();
			scan.close();      
                	Socket.close();
        	}
        	
 

            

        } 
        catch (Exception e) 
        {
            System.err.println("Conexion cerrada con el servidor");
            System.exit(1);
        }         
    }
}
