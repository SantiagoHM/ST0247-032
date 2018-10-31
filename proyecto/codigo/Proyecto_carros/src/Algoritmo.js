'use strict'

//Clase del algoritmo principal.

/*Atributos (Una constante debe de declararse e inicializarse a la vez)
            mirar el archivo informacion.txt*/
const N; //Numero total de nodos
const M; //Numero de clientes
const u;  //Numero de estaciones de carga
const breaks; //Numero de puntos de soporte de la funcion de la carga de la bateria
const r;  //Tase de consumo en Watts hora por kilometro
const speed; //Velocidad en kilometros por hora
const Tmax;  //Tiempo maximo de duracion de la ruta de un vehiculo en horas
const Smax; //Tiempo maximo de carga en horas en la estacion mas lenta.
const st_customer; //Tiempo en horas que se demora visitando un cliente
const Q; //Capacidad de la bateria en watts horas
const ruta; //Recorrido total que se ha realizado



/*
    Metodo para leer los datos suministrados (informacion.txt)
*/
