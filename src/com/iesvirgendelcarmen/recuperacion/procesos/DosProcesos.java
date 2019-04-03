package com.iesvirgendelcarmen.recuperacion.procesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;

//cat missfont.log | wc -w
//Primer proceso cat missfont.log
//Segundo proceso wc -w
public class DosProcesos {
	public static void main(String[] args) {
		//Primer proceso: cat missfont.log
		List<String> comandos1 = new ArrayList<>();
		//En windows
		// comandos.add("CMD");
		// comandos.add("/C");
		comandos1.add("cat");
		comandos1.add("missfont.log");
		ProcessBuilder pbBuilder = new ProcessBuilder(comandos1);
		pbBuilder.directory(new File("/home/profesor"));  //directorio trabajo
		
		//Segundo proceso wc -l
		Runtime runtime = Runtime.getRuntime();
		String[] comandos2 = {"wc", "-w"};
		
		BufferedReader in1 = null;
		BufferedReader in2 = null;
		PrintWriter   out = null;
		try {
			InputStream inStream1; //inputStream proceso 1
			InputStream inStream2; //inputStrean proceso 2
			
			Process proceso1 = pbBuilder.start(); //creamos el proceso
			Process proceso2 = runtime.exec(comandos2);
			if (proceso1.exitValue() == 0) { //proceso exitoso porque la salida es 0
				inStream1 = proceso1.getInputStream();
			}
			else {
				inStream1 = proceso1.getErrorStream();
			}
			
			in1 = new BufferedReader(
					new InputStreamReader(inStream1));
			out = new PrintWriter(proceso2.getOutputStream());
			//leemos la salida del proceso 1
			//la mostramos en pantalla
			//la volcamos al proceso 2
			String linea;
			while ((linea = in1.readLine()) != null) {
				System.out.println(linea);
				out.write(linea +"\n");
				out.flush();
			}
			
			proceso1.waitFor(); //esperamos a que acabe el proceso 1
			
			//recuperamos la salida del proceso 2
//			if (proceso2.exitValue() == 0) { //proceso exitoso porque la salida es 0
//				inStream2 = proceso2.getInputStream();
//			}
//			else {
//				inStream2 = proceso2.getErrorStream();
//			}
			inStream2 = proceso2.getInputStream();
			in2 = new BufferedReader(new InputStreamReader(
					inStream2));
			//mostramos la salida del proceso 2
			;
			while ((linea = in2.readLine()) != null) {
				System.out.println("Nº palabras " + linea);
			}
			proceso2.waitFor();
			
		} catch (IOException | InterruptedException  e) {
			e.printStackTrace();
		} finally {
			try {
				if (in1 != null)
					in1.close();
				if (out != null)
					out.close();
				if (in2 != null)
					in2.close();
			} catch (IOException e) {
				System.out.println("Error I/O");
			}
		}
	}


}
