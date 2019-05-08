package com.iesvirgendelcarmen.recuperacion.hilos;

public class Clase1 {

	public static void main(String[] args) {
		Thread hilo1 = new Numero(100);
		hilo1.start();
		Thread hilo2 = new Numero(100);
		hilo2.start();
		Thread hilo3 = new Numero(100);
		hilo3.start();
		Thread hilo4 = new Numero(100);
		hilo4.start();
		System.out.println(Thread.currentThread().getName() + 
				" --- FIN DE PROGRAMA");

	}

}
class Numero extends Thread {
	//mostrar 0 1 2 3 .... numero
	private long numero;
	
	public Numero(long numero) {
		this.numero = numero;
	}

	//código que se ejecuta en paralelo
	@Override
	public void run() {
		for(long i = 0; i <= numero; i++) {
			try {
				Thread.sleep((long) (Math.random() * 2_000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() +
					" --- " + i);
		}
		System.out.println("FIN DE HILO");

	}
	
}