'use strict'

class carro{

  const id; //Identificacion del nodo (inicializar constante)
  var t;
  var bateria_inicial; //Bateria con la que inicia cada carro.
  var x; //Posicion x (vetical) del carro
  var y; //POsicion y (Horizontal) del carro


  //Constructor de la clase carro
  constructor( bateria_inicial ,x ,y, t){
    this.t = t;
    this.bateria_inicial = bateria_inicial;
    this.x = x;
    this.y = y;
  }

}
