odos los hilos se ejecutan en la misma 
m�quina virtual (mismo proceso)
�
Por tanto comparten recursos, como la memoria
�
En realidad s�lo puede haber un hilo ejecut�ndose 
a la vez 
(se alternan, gracias a la concurrencia) 
La exclusi�n mutua no permite que dos threads tengan acceso simult�neo un recurso compartido 
La secuencializaci�ne es cuando cada thread debe esperar a que el otro termine de usar el recurso compartido. 
existen 3 formas de crear hilos:
1 Implementaci�n del interfaz Runnable ej: class NewThread implements Runnable
2 Extensi�n de la clase Thread ej: class NewThread extends Thread
sincronizaci�n de hilos:
Cuando un hilo escribe en el fichero, debe marcar de alguna manera que el fichero est� ocupado. El otro hilo, al intentar escribir, lo ver� ocupado y deber� esperar a que est� libre