"use strict";

function Estacion_Carga(posMA, posXY, id, tipoEstacion, relacionCarga){
    Nodo.call(this, posMA, posXY, id);

    this.tipoEstacion = tipoEstacion;
    this.relacionCarga = relacionCarga;
}
