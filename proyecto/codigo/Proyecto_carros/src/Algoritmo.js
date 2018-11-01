  "use strict";

  class Algoritmo{
  /*var n; //Numero total de nodos
  var m; //Numero de clientes
  var u;  //Numero de estaciones de carga
  var breaks; //Numero de puntos de soporte de la funcion de la carga de la bateria
  var r;  //Tase de consumo en Watts hora por kilometro
  var speed; //Velocidad en kilometros por hora
  var Tmax;  //Tiempo maximo de duracion de la ruta de un vehiculo en horas
  var Smax; //Tiempo maximo de carga en horas en la estacion mas lenta.
  var st_customer; //Tiempo en horas que se demora visitando un cliente
  var q; //Capacidad de la bateria en watts horas
  const nodos = new Array();
  var clientes= new Array();
  var visited= new Array();
  var estaciones = new Array();
  var grafo;
  var ruta; //Recorrido total que se ha realizado
  */
  //Clase del algoritmo principal.


    constructor(text = Array()){
      this.way= 0.0;
      this.n = text[0];
      this.m = text[1];
      this.u = text[2];
      this.breaks = text[3];
      this.r = text[4];
      this.speed = text[5];
      this.Tmax = text[6];
      this.Smax = text[7];
      this.st_customer = text[8];
      this.q = text[9];
      this.nodos = new Array();
      this.clientes = new Array();
      this.estaciones = new Array();
      this.visited = new Array();
      this.grafo = new DigraphAM(text[0]);

      this.times = new Array();
      this.wat = new Array();
      this.info = new Array();

      for(var i= 0;i< this.m;i++){
        this.visited.push(false);
      }

      for(var i = 11 ; i< text.length; ++i){
        if(text[i] != ""){

          var info = text[i].split(" ");
          var id = parseInt(info[0])
          var aux = new Nodo(id, info[1], parseFloat(info[2]), parseFloat(info[3]), info[4], parseInt(info[5]), 0);
          this.nodos.push(aux);

          if(info[4]== "c"){
            this.clientes.push(aux);
          }
          if(info[4]== "s"){
            this.estaciones.push(aux);
          }

        }
        if(text[i]==""){
          break;
        }
      }
      for (var j = 0; j < this.grafo.matriz.length; j++) {
        for (var k = 0; k < this.grafo.matriz[j].length; k++) {
          this.grafo.matriz[j][k] = calcularDistancia(this.nodos[j].x, this.nodos[j].y, this.nodos[k].x, this.nodos[k].y);

        }
      }


      info = text[17].split(" ");
      this.times.push(parseFloat(info[3]));
      info = text[18].split(" ");
      this.times.push(parseFloat(info[3]));
      info = text[19].split(" ");
      this.times.push(parseFloat(info[3]));

      //console.log(this.times);

      info = text[21].split(" ");
      this.wat.push(parseFloat(info[3]));
      info = text[22].split(" ");
      this.wat.push(parseFloat(info[3]));
      info = text[23].split(" ");
      this.wat.push(parseFloat(info[3]));

      //console.log(this.wat);

      this.tipos = new Array();

      for(var aux = 0; aux < 3; aux++){
        this.tipos.push(this.wat[aux]/this.times[aux]);
      }
      //console.log(this.tipos);

      for(var aux = 0; aux< this.estaciones.length; aux++){
        if(this.estaciones[aux].tipoEstacion == 0){this.estaciones[aux].watts_estacion = this.tipos[0];}
        if(this.estaciones[aux].tipoEstacion == 1){this.estaciones[aux].watts_estacion = this.tipos[1];}
        if(this.estaciones[aux].tipoEstacion == 2){this.estaciones[aux].watts_estacion = this.tipos[2];}
      }
      //console.log(this.visited);
    }
}

function tiespi(a = Algoritmo){

    //console.log("nodos 0");
    //console.log(a.nodos[0]);

    a.visited[0]= true;
    var nodo = 0;
    var camiones = new LinkedList();

    var c = new Carro(a.q, a.nodos[0].x, a.nodos[0].y, a.Tmax);


    c.visited.insertAt(a.nodos[0],0);
    camiones.insertAt(c, camiones.size_of_list());

    while(!comprobar(a.visited)){
      var min = Number.MAX_VALUE;
      var nd = nodo;

      for (var i = 0; i < a.m; i++) {
        if (i != nodo && a.grafo.matriz[i][nodo] < min && a.visited[i] != true) {
          min = a.grafo.matriz[i][nodo];
          nd = i;
        }
      }
      nodo = nd;
      var v;
      if ((v = puedeVolver(c, a.clientes[nodo - 1], nodo, min, a)) == -1) {
        a.way += calcularDistancia(c.x, c.y, a.nodos[0].x, a.nodos[0].y);
        c.visited.insertAt(a.nodos[0], c.visited.size_of_list());
        c = new Carro(a.q, a.nodos[0].x, a.nodos[0].y, a.Tmax);
        c.visited.insertAt(a.nodos[0], 0);
        camiones.insertAt(c, camiones.size_of_list());
        nodo = 0;
      } else {
        nodo = v;
      }
    }

    c.visited.insertAt(a.nodos[0] ,c.visited.size_of_list());
    a.way += a.grafo.matriz[0][nodo];
    //console.log("rutas");

    for(var i = 0; i < camiones.size_of_list(); i++){
      var inicial = camiones.get(i).visited.get(0);
      //console.log(inicial);
      console.log("Ruta " + (i + 1) + ": " + inicial.id_0 + "(0 Horas), ");

      ////////////////////////

      for (var k = 1; k < camiones.get(i).visited.size_of_list(); k++) {
        var neo = camiones.get(i).visited.get(k);
        var tt = a.grafo.matriz[neo.id_0][camiones.get(i).visited.get(k - 1).id_0] / a.speed;
        if (k == camiones.get(i).visited.size_of_list() - 1) {
            console.log(neo.id_0 + " (" + tt + " Horas)");
        } else {
            console.log(neo.id_0 + " (" + tt + " Horas), ");
        }
      }
      ////////////////////////
    }

        console.log("\n - Datos generales: ");
        console.log("Número de camiones: " + camiones.size_of_list());
        console.log("Total horas: " + ((a.way / a.speed) + ((a.m - 1) * a.st_customer)) + " Horas");
        console.log("Total Kilometros recorridos: " + a.way + " Km");
}

function puedeVolver(c = Carro, target = Nodo, nodact, mi, a = Algoritmo) {
    var distanceD = a.grafo.getWeight(target.id_0, 0);
    var distanceN = mi;
    var distance = distanceD + distanceN;
    var time = (distance / a.speed) + a.st_customer;
    if (!(c.t >= time)) {
        var outlay = (distance / a.speed) * a.r;
        if (c.bateria_inicial >= outlay) {
            c.t -= (distanceN / a.speed) + a.st_customer;
            c.bateria_inicial -= (distanceN / a.speed) * a.r;
            c.x = target.x;
            c.y = target.y;
            c.visited.insertAt(target, c.visited.size_of_list());
            a.visited[target.id_0] = true;
            nodact = target.id_0;
            a.way += distanceN;
            return nodact;
        }
    }
    return -1;
}

function comprobar(a = Array()) {
  for (var i = 0; i < a.length; i++) {
      if (!a[i]) {
          return false;
      }
  }
  return true;
}

function calcularDistancia(x1, y1, x2, y2){
  return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1-y2, 2));
}
