# TP_2-Threads

# Diferencia entre Runnable y Thread

Runnable (interfaz) Thread (clase)

Runnable es sólo una interfaz que necesita para instanciar un hilo para contenerlo. 
Mientras que Thread contiene ya la capacidad de generar un hilo. 
Si se extiende de Thread no puede extender otra cosa (Java no admite la herencia múltiple). Puede tener múltiples interfaces en una clase, por lo tanto podría tener Runnable.

Además, cuando extiende la clase Thread, cada subproceso crea un objeto único y se asocia con él. Cuando implementa Runnable, comparte el mismo objeto con varios subprocesos.

También puede utilizar Runnable en lugares no relacionados con hilos.

Un Thread es un hilo de ejecución en un programa. La máquina virtual de Java permite que una aplicación tenga varios subprocesos de ejecución ejecutándose simultáneamente.

Uno debe extender una clase Thread solo si tiene que anular o especializar algunos otros métodos de la clase Thread. Debe implementar una interfaz Runnable si solo desea especializar el método de ejecución.

# Ciclo de vida de un Thread

Un thread puede presentar cuatro estados distintos:

1. Nuevo (New): El thread ha sido creado pero no inicializado, es decir, no se ha ejecutado todavía el método start(). Se producirá un mensaje de error (IllegalThreadStateException) si se intenta ejecutar cualquier método de la clase Thread distinto de start().

2. Ejecutable (Runnable): El thread puede estar ejecutándose, siempre y cuando se le haya asignado un determinado tiempo de CPU. En la práctica puede no estar siendo ejecutado en un instante determinado en beneficio de otro thread.

3. Bloqueado (Blocked o Not Runnable): El thread podría estar ejecutándose, pero hay alguna actividad interna suya que lo impide, como por ejemplo una espera producida por una operación de escritura o lectura de datos por teclado (E/S). Si un thread está en este estado, no se le asigna tiempo de CPU.

4. Muerto (Dead): La forma habitual de que un thread muera es finalizando el método run(). También puede llamarse al método stop() de la clase Thread, aunque dicho método es considerado “peligroso” y no se debe utilizar.

# Explique los metodos[start, sleep, yield, join]

start (): se usa para crear una pila de llamadas separada para el hilo. Se crea una pila de llamadas por separado y, a continuación, JVM llama a run ().

sleep (): este método hace que el thread que se está ejecutando se duerma durante la cantidad especificada de milisegundos.

yield(): significa que el Thread no está haciendo nada particularmente importante y, si es necesario ejecutar otros threads o procesos, deberían ejecutarse. De lo contrario, el thread actual continuará ejecutándose.

join(): se usa para unir el inicio de la ejecución de un thread al final de la ejecución de otro thread, de manera que un thread no comienza a ejecutarse hasta que otro thread finaliza. Si se llama a join () en una instancia de Thread, el hilo actualmente en ejecución se bloqueará hasta que la instancia de Thread haya terminado de ejecutarse
