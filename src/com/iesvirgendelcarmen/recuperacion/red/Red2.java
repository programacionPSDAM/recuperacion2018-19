package com.iesvirgendelcarmen.recuperacion.red;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Red2 {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("http://192.168.16.131");
			URLConnection conexion = url.openConnection();
			Map<String,List<String>> cabeceras = 
					conexion.getHeaderFields();
			Set<String> camposCabecera = cabeceras.keySet();
			for (String cabecera : camposCabecera) {
				System.out.println(cabecera + ": " +
						cabeceras.get(cabecera));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
