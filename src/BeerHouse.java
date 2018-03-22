package cerveceria;

import java.util.Random;

public abstract class BeerHouse implements Runnable{
//variable consumidor q si es true consumire y sino, si es false realizare produccion de producto
    private boolean consumidor;
	private static int stock=0;
	private static Object lock=new Object();
        Random aleatorio=new Random(System.currentTimeMillis());
	//constructor solo poner consumidor
	public BeerHouse(boolean consumidor){
		this.consumidor=consumidor;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//bucle que un consumidor siempre consuma o productor siempre produzca
		
		
		while(true){//si es true consumire y sino, si es false realizare produccion de producto
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
                            
                            
                            Thread.interrupted();
                         
                        }
                }
        }
	private void produciendo() {
		// TODO Auto-generated method stub
		synchronized (lock){
			//solo 1 hilo pueda escribir en variable stock
			stock=aleatorio.nextInt(100);
                        //si el stock es mayor a cero despierte a todos
                        if(stock>0){
                                System.out.println("soy productor y fabrique "+ stock);
                                lock.notifyAll();//despertemos a todos
                                try{
				lock.wait();// que espere para q entren mas hilos
                                }catch(Exception e){}
                        }else{
                            //si el estock es menos a 0 sera interrumpido
                                        Thread.interrupted();
                        }
	}
        }

}
