'use strict'
//Clase para la implementacion de grafos.
 class DigraghAm

  var size;
  var matriz;
  /*Se crea y se inicializa la matriz; la  matriz es cuadrada
  su tamaño viene dado
  por el numero de vertices.*/
  function constructor(size){
   this.size=size
   this.matriz =new Array(size);
      for(var i=0;i<matriz.length;i++){
        this.matriz[i]=new Array(size);
      }
  }

  }
  //Metodo addArc. Este metodo añade un arco al grafo en una matriz.
  function addArc(source,destination,weight){
    this.matriz[source][destination]=weight;
  }

  //Metodo getWeight. Este metodo retorna el peso de un arco en el grafo
   function getWeight(source,destination){
     return this.matriz[source][destination];
   }
   /*Metodo getSuccessors. Este metodo retorna un ArrayList con los sucesores
   de un nodo dado en el grafo.*/
  function getSucceessors(vertice){
    var array = new Array();
    for (var i = 0; i < matriz[vertice].length; i++) {
           if (matriz[vertice][i] > 0) {
               array.push(i);
           }
    }
     return array;
  }
