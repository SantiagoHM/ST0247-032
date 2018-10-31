'use strict'

  class Nodo{

    //Atributos
      var id; //Identificador de cada nodo del grafo
      var x; //Posicion x (vertical) del nodo.
      var y; //Posicion y (Horizontal) del nodo.
      var tipoNodo; // Tipo de nodo
      var tipoEstacion; //Tipo de estacion.
      var watts_estacion; //Watts que se cargan por estacion
      var nombre_Nodo; //Nombre de cada nodo

    //Constructor de clase nodo
      constructor(id, nombre_Nodo, x, y, tipoNodo, tipoEstacion, watts_estacion){
        this.id = id;
        this.nombre_Nodo = nombre_Nodo;
        this.x = x;
        this.y = y;
        this.tipoNodo = tipoNodo;
        this.tipoEstacion = tipoEstacion;
        this.watts_estacion = watts_estacion;
      }
