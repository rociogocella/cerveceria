odos los hilos se ejecutan en la misma 
máquina virtual (mismo proceso)
•
Por tanto comparten recursos, como la memoria
•
En realidad sólo puede haber un hilo ejecutándose 
a la vez 
(se alternan, gracias a la concurrencia) 
La exclusión mutua no permite que dos threads tengan acceso simultáneo un recurso compartido 
La secuencializacióne es cuando cada thread debe esperar a que el otro termine de usar el recurso compartido. 
existen 3 formas de crear hilos:
1 Implementación del interfaz Runnable ej: class NewThread implements Runnable
2 Extensión de la clase Thread ej: class NewThread extends Thread
sincronización de hilos:
Cuando un hilo escribe en el fichero, debe marcar de alguna manera que el fichero está ocupado. El otro hilo, al intentar escribir, lo verá ocupado y deberá esperar a que esté libre