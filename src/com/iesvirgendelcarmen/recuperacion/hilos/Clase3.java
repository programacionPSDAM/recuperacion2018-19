package com.iesvirgendelcarmen.recuperacion.hilos;

public class Clase3 {

	public static void main(String[] args) {
		Thread hilo1 = new Thread(new HiloSecundario(100));
		hilo1.setDaemon(true);
		hilo1.start();
		Thread hilo2 = new Thread(new HiloSecundario(100));
		hilo2.setDaemon(true);
		hilo2.start();
		try {
			Thread.sleep((long) (10_000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + 
				" --- FIN DE PROGRAMA");
	}

}
class HiloSecundario implements Runnable{
	//mostrar 0 1 2 3 .... numero
		private long numero;
		
		public HiloSecundario(long numero) {
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