package cerveceria;


public class Cerveceria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//creamos hilos para 10 clientes y un cocinero
		int numHilos=11;
		Thread[] hilos=new Thread[numHilos];
		//recorremos los hilos
		for(int i=0;i<hilos.length;i++){
			Runnable runnable=null;//var runneable para almacenar lo q trae clase Principal
			if(i!=0)//si no arranco los hilos. es decir si es distinto del primer indice
			{
				runnable=new BeerConsumer(true);//creo la clase Principal y le digo q soy consumidor
			}
			else{
				//sino le digo q soy productor .es decir consumidor=false
				runnable=new BeerProducter(false);
			}
			//sigo dentro del for x q los hilos con el run se crea aca
			//almaceno en el arreglo de hilos un nuevo hilo con el run q trajo clase Principal
			hilos[i]=new Thread(runnable);
			hilos[i].start();//comenzar
		}
		for(int i=0;i<hilos.length;i++){
			//recorremos arreglo ya con hilos adentro 
			//pedimos q se vallan uniendo
			try{
				hilos[i].join();
			}catch(Exception e){}
		
		}
	}

}


