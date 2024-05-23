package es.uma.informatica.rsd.chat.impl;


import java.io.IOException;

import java.net.DatagramPacket;

import java.net.DatagramSocket;

import java.net.InetAddress;

import java.net.InetSocketAddress;

import java.net.MulticastSocket;

import java.net.UnknownHostException;


import es.uma.informatica.rsd.chat.ifaces.Comunicacion;

import es.uma.informatica.rsd.chat.ifaces.Controlador;

import es.uma.informatica.rsd.chat.impl.DialogoPuerto.PuertoAlias;



// Clase a implementar 
public class ComunicacionImpl implements Comunicacion {

		
		DatagramSocket Socket;

				String alias;

				Controlador c;



	@Override

	public void crearSocket(PuertoAlias pa) {

		try {


			Socket = new DatagramSocket(pa.puerto);

			alias = pa.alias;


		} catch (Exception e) {

			System.out.print("No se ha podido abrir el socket: "+e.getMessage());

		}


	}


	@Override

	public void setControlador(Controlador c) {//Recibo el objeto controlador para mostrar la interfaz gráfica.

		this.c = c;

	}


	@Override

	public void runReceptor() {

		while(true) {

			
			DatagramPacket paquete = new DatagramPacket(buf, buf.length);//Declaro el socket UDP para la recepción de los paquetes

			try {		                                             //preparar respuesta

				Socket.receive(paquete);//recibir paquete por el socket.

			} catch (IOException e) {//recogo por si hay problemas

				System.out.println("Error al recibir el paquete: "+e.getMessage());

				e.printStackTrace();
		
			}


			String Mensaje = "";

			int tamNick;

			int tamDir=0;

			int i=1;

			byte[] nick,mensaje;

			byte[] buf = new byte[256];//Buffer para recoger segmentos


			//Leemos el tamaño del nick
	

			tamNick=(int)buf[i++];


			
			/* Leemos el nick */


			nick = new byte[tamNick];


			for(int j=0;j<tamNick;j++){

				nick[j] = buf[i++];

			}



			Mensaje="<"+new String(nick)+">";									

			System.out.println(Mensaje);


			//Leemos el mensaje
			mensaje = new byte[paquete.getLength()-tamDir-tamNick-2];

			for(int j=0;j<mensaje.length;j++){

				mensaje[j] = buf[i++];

				
			}

				Mensaje += new String(mensaje);

				c.mostrarMensaje(paquete.getSocketAddress(), alias,  Mensaje);


		}


			
	}

		

	@Override

	public void envia(InetSocketAddress sa, String mensaje) {

				
byte[] buffersalida;//Declaro una variable buffer para que pueda almacenar lo que vaya a enviar

				int i=1;

				int tamañoDireccion=0;

		
		buffersalida = new byte[2+tamañoDireccion+alias.length()+mensaje.length()];//Se almacena todo en el buffer para el envio


				buffersalida[0]=(byte)0;


		for(int j=0;j<tamañoDireccion;j++){// Se introduce la direccion del servidor en el Buffer

			buffersalida[i++]=sa.getAddress().getAddress()[j];

		}
	buffersalida[i++] = (byte) alias.length();//Se introduce el tamaño del nick en el Buffer


		for(byte auxiliar : alias.getBytes()){ // Se introduce el nick en el buffer

			buffersalida[i++] = auxiliar;//Se hace un "for each" en el cual el buffer mientras
																     //se va pasando caracter a caracter mientras se aumenta el buffer

		}


		for(byte auxiliar : mensaje.getBytes()){ //Se itnroduce el mensaje en el Buffer

			buffersalida[i++] = auxiliar;

		}


		DatagramPacket Paquetedeenvio = new DatagramPacket(buffersalida,buffersalida.length,sa.getAddress(),sa.getPort());//Para crear y enviar el datagrama


		try {


			Socket.send(Paquetedeenvio);


		} catch (IOException e) {


			System.out.print("Error enviando paquete: "+e.getMessage());


		}


	}


	@Override

	public void joinGroup(InetAddress multi) {

	}


	@Override

	public void leaveGroup(InetAddress multi) {
	}


}
