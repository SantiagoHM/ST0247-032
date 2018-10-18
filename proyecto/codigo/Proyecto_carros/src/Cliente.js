"use strict";

function Cliente(posMA, posXY, id, duracionVis){
  Nodo.call(this, posMA, posXY, id);
  this.duracionVis = duracionVis;
}
