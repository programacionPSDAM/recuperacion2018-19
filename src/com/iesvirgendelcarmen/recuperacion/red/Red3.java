package com.iesvirgendelcarmen.recuperacion.red;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Red3 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://elpais.com/");
			HttpURLConnection conexion = 
					(HttpURLConnection) url.openConnection();
			System.out.println("Código conexión: " + 
					conexion.getResponseCode());
			System.out.println("Redirección a: " +
					conexion.getHeaderField("Location"));
			Scanner sc = new Scanner(conexion.getInputStream());
//			while (sc.hasNextLine())
//				System.out.println(sc.nextLine());
					} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
