"use strict";
import LinkedList from 'src/LinkedList';

var n; //Numero total de nodos
var m; //Numero de clientes
var u;  //Numero de estaciones de carga
var breaks; //Numero de puntos de soporte de la funcion de la carga de la bateria
var r;  //Tase de consumo en Watts hora por kilometro
var speed; //Velocidad en kilometros por hora
var Tmax;  //Tiempo maximo de duracion de la ruta de un vehiculo en horas
var Smax; //Tiempo maximo de carga en horas en la estacion mas lenta.
var st_customer; //Tiempo en horas que se demora visitando un cliente
var q; //Capacidad de la bateria en watts horas
var nodos = new Array();
var clientes= new Array();
var visited= new Array();
var estaciones = new Array();
var grafo;
var ruta; //Recorrido total que se ha realizado

//Clase del algoritmo principal.
function algoritmo(){


  this.putInfo = function(text){
    n = text[0];
    m = text[1];
    u = text[2];
    breaks = text[3];
    r = text[4];
    speed = text[5];
    Tmax = text[6];
    Smax = text[7];
    st_customer = text[8];
    q = text[9];

    //grafo = new DigraphAM(N);

    var times = new Array();
    var wat = new Array();
    var info = new Array();

    for(var i = 11 ; i< text.length; ++i){
      if(text[i] != ""){

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


/**
    for (int j = 0; j < g.matriz.length; j++) {
      for (int k = 0; k < g.matriz[j].length; k++) {
        //System.out.println(nodes[j].x+" "+ nodes[j].y+" "+ nodes[k].x+" "+ nodes[k].y);
        grafo.matriz[j][k] = calcularDistancia(nodes[j].x, nodes[j].y, nodes[k].x, nodes[k].y);
      }
    }
*/

    info = text[17].split(" ");
    times.push(parseFloat(info[3]));
    info = text[18].split(" ");
    times.push(parseFloat(info[3]));
    info = text[19].split(" ");
    times.push(parseFloat(info[3]));

    console.log(times);

    info = text[21].split(" ");
    wat.push(parseFloat(info[3]));
    info = text[22].split(" ");
    wat.push(parseFloat(info[3]));
    info = text[23].split(" ");
    wat.push(parseFloat(info[3]));

    console.log(wat);

    var tipos = new Array();

    for(var aux = 0; aux < 3; aux++){
      tipos.push(wat[aux]/times[aux]);
    }
    console.log(tipos);

    for(var aux = 0; aux< estaciones.length; aux++){
      if(estaciones[aux].tipoEstacion == 0){estaciones[aux].watts_estacion = tipos[0];}
      if(estaciones[aux].tipoEstacion == 1){estaciones[aux].watts_estacion = tipos[1];}
      if(estaciones[aux].tipoEstacion == 2){estaciones[aux].watts_estacion = tipos[2];}
    }
    console.log(estaciones);
  }

  tiespi();
}

function tiespi(){
  visited[0]= true;
  var nodo = 0;
  var camiones = new LinkedList();


}

function calcularDistancia(x1, y1, x2, y2){
  return Math.sqrt(Math.pow(x1 + y1, 2) + Math.pow(x2+y2, 2));
}
