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
    if(itTask.value != ''){ //Si itTask es diferente de un string vacio
        createTask(itTask.value);
        itTask.value='';//esto vacia el  input para la suiente tarea
        rederTask();//llama a la funcion
    }

});

//funcion crear la tarea
function createTask(){
    
    const newTask ={
        //id dinamico,math.ramdom me da un valor decimal, lo elimino con toString slice me quita los 3 caracteres inciales
        id: (Math.random() * 100).toString(36).slice(3), 
        title: value,
        completed: false,
    };

    //agrego newTask al arreglo task[]
    task.unshift(newTask);

}
