/**
ALGORITMO TOTALMENTE TOMADO DE: https://github.com/trekhleb/javascript-algorithms/tree/master/src/data-structures/linked-list
NO ES DE MI AUTORIA NI DE LA DE NINGUNO DE LOS DE NUESTRO EQUIPO.
NO COPYRIGHT INFRINGEMENT INTENDED.
TODO EL CREDITO DE LA REALIZACION A SU RESPECTIVO AUTOR.
*/
export default class LinkedListNode{
  constructor(value, next = null) {
    this.value = value;
    this.next = next;
  }

  toString(callback) {
    return callback ? callback(this.value) : `${this.value}`;
  }
}
