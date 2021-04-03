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

