package com.iesvirgendelcarmen.recuperacion.red;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketCliente2 {

	public static void main(String[] args) {
		final int PORT = 2628;
		final String HOST = "dict.org";
		final String DICCIONARIO =" fd-spa-eng ";
		final String PALABRA ="coche";
		try (Socket socket = new Socket(HOST, PORT);) {
			//le pasamos la palabra a traducir
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.println("define" + DICCIONARIO + PALABRA);
			out.flush();
			//recepcionamos la salida del socket
			BufferedReader in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			String linea;
			while ((linea = in.readLine()) != null)
				System.out.println(linea);
			String salida = "quit";
			out.println(salida );
			out.println();
			out.flush();
//			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
