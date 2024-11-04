/*Quiero hacer un metodo pomodoro, este tendra que ir añadiendo la tareas que yo ingrese
a traves de un imput, despues con un boton lo podre poner en cuenta atras.*/


//Array bacio que se llenara que las tareas que tenga que hacer
const task =[];
let time = 0;
let timer = null;
let timerBreak= null;
let current = null;

//referencias a mis elementos del html
const bAdd = document.querySelector('#bAdd');
const itTask = document.querySelector('#itTask');
const form = document.querySelector('#form');

//eventos
//se ejecuta una funcion cuendo se activa submit
form.addEventListener('submit', e =>{
    e.preventDefault(); //para que no se envie directamente
    
});