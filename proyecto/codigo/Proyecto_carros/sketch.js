var txt;
var alg;

function preload(){
  txt = loadStrings("informacion.txt");
}

function setup() {
  // put setup code here
  createCanvas(windowWidth, windowHeight);
  //console.log(txt);
  alg = new Algoritmo(txt);
  tiespi(alg);

}

function draw() {

}
