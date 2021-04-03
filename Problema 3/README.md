Para la realizacion del problema 3 se realizaron las siguientes clases:

## Clase Bala                       
![image](https://user-images.githubusercontent.com/69942635/113466692-f1a28880-93fa-11eb-8437-d48eb67d1d47.png)

## Clase Nave                                  
![image](https://user-images.githubusercontent.com/69942635/113466795-b18fd580-93fb-11eb-8461-d456374d2529.png)

## Clase HiloGenerarNave
Es una clase Thread que consiste en generar Naves enemigas de manera random en lo alto de la pantalla del juego. esta clase se ejecuta de manera paralela.    
***
las variables globales estaticas:
* juegoEmpezado: la cual hace que el hilo pueda seguir transcuriendo de manera normal.
* totalNaves: la cantidad total de naves en el tablero.
* naves: arreglo donde se encuentran almacenadas todas las naves en el juego.
* navesVivas: la cantidad de naves vivas en el tablero del juego.
* velocidadAparicionNave: cantidad en la cual las naves aparecen con mayor velocidad.
![image](https://user-images.githubusercontent.com/69942635/113467019-84dcbd80-93fd-11eb-83d3-3c11bf0bf641.png)
## Clase HiloBalaJugador
es una clase Thread que consiste en mover todas las balas de los jugadores hacia las naves enemigas. esta clase se ejecuta de manera paralela y concurente.
***
se dio la situacion de un deadlocks debido a que se creaban al mismo tiempo 2 balas, se arreglo dando un limite de disparo entre disparos.
***
las variables globales estaticas:
* juegoEmpezado: la cual hace que el hilo pueda seguir transcuriendo de manera normal.
* totalNaves: la cantidad total de naves en el tablero.
* naves: arreglo donde se encuentran almacenadas todas las naves en el juego.
* navesVivas: la cantidad de naves vivas en el tablero del juego.
* balaJugador: arreglo de balas.
![image](https://user-images.githubusercontent.com/69942635/113467744-409fec00-9402-11eb-8ce4-a11114c4e97f.png)
## Clase HiloBalaNave
Es una clase Thread que consiste en mover todas las balas de las naves enemigas. esta clase se ejecuta de manera paralela y concurente.   
***
se dio la situacion de un deadlocks debido a que se creaban al mismo tiempo 2 balas, se arreglo dando un limite de disparo entre disparos.
***
las variables globales estaticas:
* juegoEmpezado: la cual hace que el hilo pueda seguir transcuriendo de manera normal.
* balaNave: arreglo de balas.
* jugador1: es el jugador 1.
* jugador2: es el jugador 2.
![image](https://user-images.githubusercontent.com/69942635/113468866-3122a200-9406-11eb-9819-a5a7bbdbcafc.png)
## Clase HiloJugador
Es una clase Thread que consiste en esperar las pulsaciones del teclado para mover los jugadores en la pantalla. esta clase se ejecuta de manera paralela.
***
las variables globales estaticas:
* juegoEmpezado: la cual hace que el hilo pueda seguir transcuriendo de manera normal.
* jugador1: es el jugador 1.
* jugador2: es el jugador 2.
***
![image](https://user-images.githubusercontent.com/69942635/113469146-895aa380-9408-11eb-9b83-50cd308462ce.png)
![image](https://user-images.githubusercontent.com/69942635/113469162-af804380-9408-11eb-80e5-74a5f173d82e.png)
## Clase HiloNave
Es una clase Thread que consiste en mover las naves enemigas de derecha a izquierda y hacia abajo. esta clase se ejecuta de manera paralela.
***
las variables globales estaticas:
* juegoEmpezado: la cual hace que el hilo pueda seguir transcuriendo de manera normal.
* naves: arreglo de las naves enemigas.
![image](https://user-images.githubusercontent.com/69942635/113469268-8b713200-9409-11eb-9306-6187ea3a6c99.png)
## Clase HiloTiempo
Es una clase Thread que consiste en espera 25 segundos y hacer que la velocidad de las naves y su aparicion se realice de manera mas rapida. esta clase se ejecuta de manera paralela.
las variables globales estaticas:
* juegoEmpezado: la cual hace que el hilo pueda seguir transcuriendo de manera normal.
* velocidadAparicionNave: velocidad con la cual las naves se mueven y aparecen mas rapido.
![image](https://user-images.githubusercontent.com/69942635/113469279-9f1c9880-9409-11eb-8b7f-b6b4f732355b.png)
## Clase Jugador
![image](https://user-images.githubusercontent.com/69942635/113469332-fb7fb800-9409-11eb-81ef-3ceb52e41ba1.png)
## Clase Nave
![image](https://user-images.githubusercontent.com/69942635/113469347-0e928800-940a-11eb-8165-2b9c58bfaf5f.png)
## Clase Panel
es una clase donde se realizan todas las instancias de las variables globales estaticas  y donde se inician los hilos de toda la aplicacion.
![image](https://user-images.githubusercontent.com/69942635/113469361-24a04880-940a-11eb-9cc2-84f70c10a6a2.png)
## Clase Ventana
es una clase donde se llenan los arreglos de las naves enemigas, se crean las instancias de los jugadores y tiene un metodo donde captura las pulsaciones del teclado para mover al jugador. esta clase actua en forma paralela con las demas.
![image](https://user-images.githubusercontent.com/69942635/113469392-5fa27c00-940a-11eb-9190-a3419f672620.png)


