'use strict'
//Clase para la implementacion de grafos.
 class DigraghAm

  var size;
  var matriz;
  /*Se crea y se inicializa la matriz; la  matriz es cuadrada
  su tamaño viene dado
  por el numero de vertices.*/
  function DigraghAm(size){
    this.size=size
   matriz =new Array(size);
    for(var i=0;i<matriz.length;i++){
      arr[i]=new Array(size);
    }
    return matriz;
  }

  }
  //Metodo addArc. Este metodo añade un arco al grafo en una matriz.
  function addArc(source,destination,weight){
    matriz[source][destination]=weight;
  }

  //Metodo getWeight. Este metodo retorna el peso de un arco en el grafo
   function getWeight(source,destination){
     return matriz[source][destination];
   }
   /*Metodo getSuccessors. Este metodo retorna un ArrayList con los sucesores
   de un nodo dado en el grafo.*/
  ArrayList<integer> getSucceessors(vertices){
    ArrayList<Integer> array = new ArrayList<>();
    for (var i = 0; i < matriz[vertex].length; i++) {
           if (matriz[vertex][i] != 0) {
               array.push(i);
           }
       }
       if (array.isEmpty()) {
           return null;
       }
       return array;
  }
