'use strict'

class Carro{
  //Constructor de la clase carro
  constructor(bateria_inicial ,x ,y, t){
    this.t = t;
    this.bateria_inicial = bateria_inicial;
    this.x = x;
    this.y = y;
    this.visited = new LinkedList();
  }
}
