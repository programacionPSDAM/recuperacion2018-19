package com.iesvirgendelcarmen.recuperacion.hilos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Clase4 {

	public static void main(String[] args) {
		ExecutorService executor = 
				Executors.newFixedThreadPool(6);
		// TODO Auto-generated method stub
		for (int i = 0; i < 1000; i++) {
//			SumaNumeroPool hilo = new SumaNumeroPool();
//			Thread hiloEjecutable = new Thread(hilo);
//			hiloEjecutable.start();
			executor.submit(new SumaNumeroPool());
			
		}
		
		executor.shutdown();

	}

}

class SumaNumeroPool implements Runnable {
	private long resultado = 0;
	// Cada hilo debe sumar desde 0 a 100_000_000
	@Override
	public void run() {
		while (resultado < 100_000_000 ) {
			resultado++;
		}
		System.out.println();
		System.out.println(Thread.currentThread().getName()+"  " + resultado);
	}
	
}