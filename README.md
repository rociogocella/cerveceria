En este proyecto el recurso compartido es la clase BeerHouse

Recordemos que todos los hilos se ejecutan en la misma 
m�quina virtual 
Por tanto comparten recursos, 
como la memoria
. En realidad s�lo puede haber un hilo ejecut�ndose 
a la vez 
(se alternan, gracias a la concurrencia)

Existen 2 formas de crear hilos:

1 Implementaci�n del interfaz Runnable ej: class NewThread implements Runnable

2 Extensi�n de la clase Thread ej: class NewThread extends Thread
sincronizaci�n de hilos.
Yo utilice la primer forma(implements runnable)

La palabra zyncronized se usa para indicar que ciertas partes del codigo estan sincronizadas,es decir que solamente un subproceso puede acceder a dicho metodo a la vez
Aqui se implemento zyncroniced en metodos consumiendo y produciendo.

Y con respecto a la cantidad de consumidores es uno solo que se ha implementado, y ese mismo consumidor consume distintas cantidades de productos cada vez.