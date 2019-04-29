# TP_2-Threads

# Diferencia entre Runnable y Thread

#Runnable (interfaz) Thread (clase)

Runnable es s�lo una interfaz que necesita para instanciar un hilo para contenerlo. 
Mientras que Thread contiene ya la capacidad de generar un hilo. 
Si se extiende de Thread no puede extender otra cosa (Java no admite la herencia m�ltiple). Puede tener m�ltiples interfaces en una clase, por lo tanto podr�a tener Runnable.

Adem�s, cuando extiende la clase Thread, cada subproceso crea un objeto �nico y se asocia con �l. Cuando implementa Runnable, comparte el mismo objeto con varios subprocesos.

Tambi�n puede utilizar Runnable en lugares no relacionados con hilos.

Un Thread es un hilo de ejecuci�n en un programa. La m�quina virtual de Java permite que una aplicaci�n tenga varios subprocesos de ejecuci�n ejecut�ndose simult�neamente.

Uno debe extender una clase Thread solo si tiene que anular o especializar algunos otros m�todos de la clase Thread. Debe implementar una interfaz Runnable si solo desea especializar el m�todo de ejecuci�n.

#Ciclo de vida de un Thread

Un thread puede presentar cuatro estados distintos:

1. Nuevo (New): El thread ha sido creado pero no inicializado, es decir, no se ha ejecutado todav�a el m�todo start(). Se producir� un mensaje de error (IllegalThreadStateException) si se intenta ejecutar cualquier m�todo de la clase Thread distinto de start().

2. Ejecutable (Runnable): El thread puede estar ejecut�ndose, siempre y cuando se le haya asignado un determinado tiempo de CPU. En la pr�ctica puede no estar siendo ejecutado en un instante determinado en beneficio de otro thread.

3. Bloqueado (Blocked o Not Runnable): El thread podr�a estar ejecut�ndose, pero hay alguna actividad interna suya que lo impide, como por ejemplo una espera producida por una operaci�n de escritura o lectura de datos por teclado (E/S). Si un thread est� en este estado, no se le asigna tiempo de CPU.

4. Muerto (Dead): La forma habitual de que un thread muera es finalizando el m�todo run(). Tambi�n puede llamarse al m�todo stop() de la clase Thread, aunque dicho m�todo es considerado �peligroso� y no se debe utilizar.

#Explique los metodos[start, sleep, yield, join]

start (): se usa para crear una pila de llamadas separada para el hilo. Se crea una pila de llamadas por separado y, a continuaci�n, JVM llama a run ().

yield(): significa que el Thread no est� haciendo nada particularmente importante y, si es necesario ejecutar otros threads o procesos, deber�an ejecutarse. De lo contrario, el thread actual continuar� ejecut�ndose.

sleep (): este m�todo hace que el thread que se est� ejecutando se duerma durante la cantidad especificada de milisegundos.

join(): se usa para unir el inicio de la ejecuci�n de un thread al final de la ejecuci�n de otro thread, de manera que un thread no comienza a ejecutarse hasta que otro thread finaliza. Si se llama a join () en una instancia de Thread, el hilo actualmente en ejecuci�n se bloquear� hasta que la instancia de Thread haya terminado de ejecutarse