/*Quiero hacer un metodo pomodoro, este tendra que ir añadiendo la tareas que yo ingrese
a traves de un imput, despues con un boton lo podre poner en cuenta atras.*/

//16:42

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
        renderTask();//llama a la funcion
    }

});

//funcion crear la tarea
function createTask(value){
    
    const newTask ={
        //id dinamico,math.ramdom me da un valor decimal, lo elimino con toString slice me quita los 3 caracteres inciales
        id: (Math.random() * 100).toString(36).slice(3), 
        title: value,
        completed: false,
    };

    //agrego newTask al arreglo task[]
    task.unshift(newTask);

}

//esta funcion permite cada elemento de la tereas  y inyectarlo en el html
function renderTask(){
    const html = task.map(task =>{ //map puedo iterra por cada elemento del array
        //cada elemento de task va a tener este  html
        return  `
        <div class="task">
        <div class="completed">${
          task.completed
            ? "<span class='done'>Done</span>"
            : `<button class="start-button" data-id="${task.id}">Start</button></div>`
        }
            <div class="title">${task.title}</div>
        </div>`;
    }); 

    //Referencia a los html
    const taskContainer = document.querySelector('#task');
    taskContainer.innerHTML = html.join("");//con map ed arriba recibire un array de string, con Join los convierto en uno solo
}