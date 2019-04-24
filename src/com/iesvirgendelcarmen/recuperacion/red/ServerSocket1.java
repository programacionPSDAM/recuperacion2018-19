package com.iesvirgendelcarmen.recuperacion.red;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class ServerSocket1 {

	public static void main(String[] args) {
		System.out.println("Arrancado servidor en puerto 3300");
		while (true) {
			try (ServerSocket server = new ServerSocket(3300);){
				Socket socket = server.accept();
				PrintWriter out = new PrintWriter(
						socket.getOutputStream());
				out.println(LocalDateTime.now());
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
