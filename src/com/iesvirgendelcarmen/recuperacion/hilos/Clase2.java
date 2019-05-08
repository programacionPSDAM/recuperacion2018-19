package com.iesvirgendelcarmen.recuperacion.hilos;

public class Clase2 {

	public static void main(String[] args) {
		// Crear cuatro hilos
		SumaNumero hilo1 = new SumaNumero();
		hilo1.start();
		SumaNumero hilo2 = new SumaNumero();
		hilo2.start();
		SumaNumero hilo3 = new SumaNumero();
		hilo3.start();
		SumaNumero hilo4 = new SumaNumero();
		hilo4.start(); 
		try {
			hilo1.join(); hilo2.join();
			hilo3.join(); hilo4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// el hilo principal suma los cuatro valores
		long resultado = hilo1.getResultado() + hilo2.getResultado() 
		+ hilo3.getResultado() + hilo4.getResultado();
		System.out.println("RESULTADO: " + resultado);

	}

}

class SumaNumero extends Thread{
	private long resultado = 0;
	// Cada hilo debe sumar desde 0 a 100_000_000
	@Override
	public void run() {
		while (resultado < 100_000_000 ) {
			resultado++;
		}
	}
	// debe devolver esa suma
	public long getResultado() {
		return resultado;
	}
	








}