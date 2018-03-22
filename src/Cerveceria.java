package cerveceria;


public class Cerveceria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//creamos hilos para 100 clientes y un productor
		int numHilos=101;
		Thread[] hilos=new Thread[numHilos];
		//recorremos los hilos
		for(int i=0;i<hilos.length;i++){
			Runnable runnable=null;//variable runneable para almacenar lo q trae clase 
			if(i!=0)//si no arranco los hilos. es decir si es distinto del primer indice
			{
				runnable=new BeerConsumer();//creo la clase consumidor
			}
			else{
				//sino le digo q soy productor .es decir consumidor=false
				runnable=new BeerProducter();
			}
			//dentro de este for creo los hilos
			//almaceno en el arreglo de hilos un nuevo hilo con el runnable q trajo la clase mas arriba
			hilos[i]=new Thread(runnable);
			hilos[i].start();//comenzar
		}
           
                
                
	}

}


