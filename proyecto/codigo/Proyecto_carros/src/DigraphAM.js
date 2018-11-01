'use strict'
//Clase para la implementacion de grafos.
 class DigraphAM{

  /*Se crea y se inicializa la matriz; la  matriz es cuadrada
  su tamaño viene dado
  por el numero de vertices.*/
  constructor(size){
   this.size=size;
   this.matriz = new Array();
      for(var i=0; i< size; i++){
        var aux = new Array(size);
        this.matriz[i]= aux;
      }
      for(var i=0; i< size; i++){
        for(var j=0; j< size; j++){
          this.matriz[i][j]= 0;
        }
      }

   }


  //Metodo addArc. Este metodo añade un arco al grafo en una matriz.
  addArc(source,destination,weight){
    this.matriz[source][destination]=weight;
  }

  //Metodo getWeight. Este metodo retorna el peso de un arco en el grafo
  getWeight(source,destination){
     return this.matriz[source][destination];
   }
   /*Metodo getSuccessors. Este metodo retorna un ArrayList con los sucesores
   de un nodo dado en el grafo.*/
  getSucceessors(vertice){
    var array = new Array();
    for (var i = 0; i < matriz[vertice].length; i++) {
           if (matriz[vertice][i] > 0) {
               array.push(i);
           }
    }
     return array;
   }
}
