package com.iesvirgendelcarmen.recuperacion.procesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjemploConRuntime {

	public static void main(String[] args) {
		//Obtener el runtime
		Runtime runtime = Runtime.getRuntime();
		//creamos el comando como una cadena
		//String comando = "ls -l";
		//creamos el comando como una coleccion de cadenas
		String[] comando = {"ls", "-l",  };
		//Directorio de trabajo
		File directorio = new File("/home/profesor");
		//creo el proceso con el método exec de Runtime
		BufferedReader in = null;
		try {
			Process proceso = runtime.exec(comando, null, directorio );
			//obtengo el inputstream del proceso
			in = new BufferedReader(new InputStreamReader(
					proceso.getInputStream()));
			String linea;
			while ((linea = in.readLine()) != null)
				System.out.println(linea);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se puede ejecutar el comando");
		} finally {
			//cierre de flujos
			if (in != null) {  //evitamos nullPointerException
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}
