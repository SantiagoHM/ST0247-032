"use strict";
var N; //Numero total de nodos
var M; //Numero de clientes
var u;  //Numero de estaciones de carga
var breaks; //Numero de puntos de soporte de la funcion de la carga de la bateria
var r;  //Tase de consumo en Watts hora por kilometro
var speed; //Velocidad en kilometros por hora
var Tmax;  //Tiempo maximo de duracion de la ruta de un vehiculo en horas
var Smax; //Tiempo maximo de carga en horas en la estacion mas lenta.
var st_customer; //Tiempo en horas que se demora visitando un cliente
var Q; //Capacidad de la bateria en watts horas
var nodos = new Array();
var clientes= new Array();
var visited;
var estaciones = new Array();
var g;
var ruta; //Recorrido total que se ha realizado

//Clase del algoritmo principal.
function algoritmo(){
  this.name = "hola";

  this.putInfo = function(text){
    N = text[0];
    M = text[1];
    u = text[2];
    breaks = text[3];
    r = text[4];
    speed = text[5];
    Tmax = text[6];
    Smax = text[7];
    st_customer = text[8];
    Q = text[9];

    for(var i = 11 ; i< text.length; ++i){
      if(text[i] != ""){
        var info = new Array();
        info = text[i].split(" ");
        var id = parseInt(info[0])
        var aux = new Nodo(id, info[1], parseFloat(info[2]), parseFloat(info[3]), info[4], parseInt(info[5]), 0);
        nodos[id] = aux;

        if(info[4]== "c"){
          clientes.push(aux);
        }
        if(info[4]== "s"){
          estaciones.push(aux);
        }

      }
      if(text[i]==""){
        break;
      }
    }
    console.log(nodos);
    console.log(estaciones);
    console.log(clientes);
  }
}
