package cerveceria;

public class BeerHouse implements Runnable{
	private boolean consumidor;
	private static int stock=0;
	private static Object lock=new Object();
	//constructor solo poner consumidor
	public BeerHouse(boolean consumidor){
		this.consumidor=consumidor;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//bucle que un consumidor siempre consuma o productor siempre produzca
		
		
		while(true){
			if(consumidor){
				consumiendo();
			}else{
				produciendo();
			}
		}
	}
	private void consumiendo() {
		// TODO Auto-generated method stub
		synchronized(lock){
			if(stock>0)//si hay stock
			{
				stock--;//consume uno
				System.out.println("quedan : "+ stock+" productos");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//cada vez q consuma me voy a dormir un segundo
			}
			else{
				lock.notifyAll();//despertamos a todos por que no podemos decir a un solo hilo productor q se despierte
				try {
					lock.wait();//sino eres productor no se ejecuta el hilo
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	private void produciendo() {
		// TODO Auto-generated method stub
		synchronized (lock){
			//solo 1 hilo pueda escribir en variable stock
			stock=10;
			System.out.println("soy productor y quedan "+ stock);
			lock.notifyAll();//despertemos a todos
			try{
				lock.wait();// que espere para q entren mas hilos
			}catch(Exception e){}
		}
	}

}
