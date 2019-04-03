package com.iesvirgendelcarmen.recuperacion.procesos;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EjemploConProcessBuilder {

	public static void main(String[] args) {
		//Generamos los comandos
		List<String> comandos = new ArrayList<>();
		comandos.add("ping");
		comandos.add("-c3");
		comandos.add("www.google.es");
		//creamos el ProcessBuilder
		ProcessBuilder pbBuilder = new ProcessBuilder(comandos);
		pbBuilder.directory(new File("."));
		//obtener el objeto Process
		BufferedInputStream in = null;
		try {
			Process proceso = pbBuilder.start();
			//trabajamos en flujo de bytes (no recomendable)
			in = new BufferedInputStream(
					proceso.getInputStream());
			int byteLeido;
			while ((byteLeido = in.read()) != -1)
				System.out.print((char) byteLeido);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

















	}

}
