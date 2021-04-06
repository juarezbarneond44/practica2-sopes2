# Centro de Acopio

## Partes del programa en donde existieron múltiples procesos trabajando de forma concurrente y/o paralela.

#### Concurrente
Al iniciarse los hilos dentro del for puede llegar a existir una cola de pendientes y el otro proceso manda un signalAll(), estos hilos pendientes quieren ser los dueños del bloqueo proporcionado por el reentrantlock pero solo 1 hilo puede ser dueño a la vez.

## Cómo se realizó la comunicación y sincronización entre procesos.
Ambos procesos interactuan con la bódega, en este proceso se lleva de forma armonioza de la siguiente manera:

**Productor:**
*Si* encuentra un lugar vacío en la bódega, realiza su donación y se retira
*Sino*, espera a que se encuentre un espacio vacío.

**Consumidor:**
*Si* encuentra una donación en la bódega entonces toma una donación por lo que vacía el espacio y luego se retira.
*Sino*, espera a que haya una donación en la bódega.

**Sincronización**
Al inicio, se genera una cantidad de hilos determinada, en nuestro caso en especifico 100 hilos, cada hilo ejecutará una función, esta puede ser de tipo "Productor" (Agrgando una donación a la bódega) o "Consumidor" (Retirando una doncación de la bódega) según la probabilidad indicada la cual es por defecto 0.5 y 0.5.

Estos 100 procesos tratan de interactuar con la "bódega", la sincronización sucede dado que un proceso ya sea el de agregar o retirar de la bódega se ejecuta, al iniciarse este proceso se bloquea la posibilidad de que algo acceda a los metodos donde este lock este presente, en nuestro programa esto bloqueará la interacción en el "insertarBodega" y "sacarDeBodega".

Entonces, al entrar en "insertarBodega" o "sacarDeBodega", los demás no podrán ni insertar, ni eliminar hasta que el proceso termine, antes de terminar, en "insertarBodega" el productor avisa a los consumidores por medio del signalAll(), por lo que estos hilos se despiertan y uno de ellos procede a ejecutarse, esto mismo sucede hacia los productores en el "sacarDeBodega", antes de finalizar se le avisa a los productores para que estos puedan insertar en la bódega.


## Situaciones en las cuáles era posible que se dieran: deadlocks, livelocks, condiciones de carrera
### Livelocks

### Deadlocks
#### Solo productores o solo consumidores
Si la probabilidad de que salgan solo productores o solo consumidores es muy alta. En caso que la cantidad de productores sea muy alta la estructura podría llenarse dejando a los productores incapaces de donar y esperando a que se vacie algún espacio de la bodega. Lo mismo pasaría con los consumidores, si esta probabilidad es muy alta la bódega se vaciaría, entonces los consumidores se quedarían esperando a que haya algo en la bódega. En ambos casos los procesos de un tipo quedarían a la espera de ser despertados por el otro tipo de proceso.
#### Solución
Tener una probabilidad equilibrada.

#### Si el productor quiere despertar a los consumidores mientras estos no estan esperando.

#### Muchos de un tipo, pocos de otro
En este caso el tipo que tenga pocas probabilidades de aparecer se quedaría esperando a que aparezcan del otro tipo, lo cual sería posible pero poco probable, por lo que sería un livelock, el sistema no esta totalmente bloqueado pero no se puede tener ningún progreso significativo.
#### Solución
Tener una probabilidad equilibrada.



## Variables o datos que era necesario compartir entre procesos.
### La bódega
El arreglo donde se iba a recibir lo que los productores traían y de donde los consumidores iban a obtener sus donaciones era algo que debía ser consistente, esta variable sería operada por ambos.

### Indicadores
El contador de la cantidad total de personas que acuden al centro de acopio también sería afectada por la interacción de los procesos, sin embargo, estos se modifican como consecuencia, es decir, no estan sujetos a problemas dado que los hilos ya interactuan de forma ordenada desde antes.



