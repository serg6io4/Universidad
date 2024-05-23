import java.io.*;
import java.net.*;

class BasicServerTCP {

    public static void main(String[] args)
    {
        
        try(ServerSocket server = new ServerSocket(12345,1))//Número de puerto y número de personas
        {
        	
        	
            while (true) //Mantengo el servidor en espera de clientes
            {
            	
            	Socket client = server.accept();
            	
            	BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            	PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            
            	
            	
            	out.println("Bienvenido al servicio de modificacion de textos");
            	out.flush();

		String Letra;
            	String text;

            	while(true) {//establezco tiempo para el servidor y espero letra y texto
            		client.setSoTimeout(40000);//Para que espere 40 segundos
            		Letra = in.readLine();	//Leer la letra para saber identificar si es a minúsculas, mayúsuculas o finalizar
            		System.out.println(Letra);
                	if(letra.equals("m")) {
                		text=in.readLine();
                		out.println(text.toLowerCase());
                		out.flush();
                		}else if (Letra.charAt(0)=='M') {
                			text=in.readLine();
                			out.println(text.toUpperCase());
                			out.flush();
                			}else if(Letra.charAt(0) =='f') {
                				out.println("FINAL");
                				in.close();
                				out.close();
                				client.close();
                				break;
                			}else{
                				out.println("Letra incorrecta, suerte en la siguiente");
                				}
                	
            				} 
            			}
         
        }catch(SocketTimeoutException e) {//Excepción cuando se acaba el tiempo
        	System.out.println("Se te acabó el tiempo");//en caso de que se le acabe el tiempo al servidor
       
           
        } catch (IOException e) {
			
			e.printStackTrace();
		}


    }
    
}

