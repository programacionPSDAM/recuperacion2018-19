package com.iesvirgendelcarmen.recuperacion.red;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketCliente1 {

	public static void main(String[] args) {
		try (Socket socket = new Socket("time.nist.gov", 13);)
		{
			BufferedReader in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			String linea;
			while ((linea = in.readLine()) != null)
				System.out.println(linea);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fin de programa");
	}

}
