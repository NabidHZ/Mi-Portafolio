/* ================================
   SISTEMA DE AUTENTICACIÓN (Frontend)
   ================================ */

// Usuarios de ejemplo (dummy)
const usuarios = [
    { username: 'admin', password: 'admin123', rol: 'administrador' },
    { username: 'user', password: 'user123', rol: 'usuario' }
  ];
  
  const formLogin = document.getElementById('formLogin');
  const loginFormDiv = document.getElementById('loginForm');
  const logoutSection = document.getElementById('logoutSection');
  const nombreUsuarioSpan = document.getElementById('nombreUsuario');
  const rolUsuarioSpan = document.getElementById('rolUsuario');
  const btnLogout = document.getElementById('btnLogout');
  
  formLogin.addEventListener('submit', (e) => {
    e.preventDefault();
    const username = document.getElementById('usuario').value;
    const password = document.getElementById('password').value;
    const usuarioValido = usuarios.find(u => u.username === username && u.password === password);
    if (usuarioValido) {
      localStorage.setItem('usuario', JSON.stringify(usuarioValido));
      mostrarUsuarioLogueado(usuarioValido);
    } else {
      alert('Credenciales incorrectas');
    }
  });
  
  btnLogout.addEventListener('click', () => {
    localStorage.removeItem('usuario');
    loginFormDiv.style.display = 'block';
    logoutSection.style.display = 'none';
  });
  
  function mostrarUsuarioLogueado(usuario) {
    loginFormDiv.style.display = 'none';
    logoutSection.style.display = 'block';
    nombreUsuarioSpan.textContent = usuario.username;
    rolUsuarioSpan.textContent = usuario.rol;
  }
  
  window.addEventListener('load', () => {
    const usuarioGuardado = JSON.parse(localStorage.getItem('usuario'));
    if (usuarioGuardado) {
      mostrarUsuarioLogueado(usuarioGuardado);
    }
  });

// Variables
const muneco = document.getElementById("muneco");
const popup = document.getElementById("popup");
const popupTitle = document.getElementById("popup-title");
const popupChartCanvas = document.getElementById("popup-chart");
const closePopup = document.getElementById("close-popup");

let chartInstance = null; // Para almacenar el gráfico y evitar duplicados
let initialPosition = { x: muneco.offsetLeft, y: muneco.offsetTop };

// Datos de prueba para los gráficos por continente
const dataContinentes = {
    "america": {
        title: "Crecimiento de Población en América",
        data: [500, 600, 750, 800, 950],
        labels: ["2000", "2010", "2020", "2030", "2040"]
    },
    "europa": {
        title: "Escasez de Agua en Europa (%)",
        data: [20, 25, 30, 40, 50],
        labels: ["2000", "2010", "2020", "2030", "2040"]
    },
    "africa": {
        title: "Impacto del Cambio Climático en África",
        data: [10, 30, 50, 70, 90],
        labels: ["2000", "2010", "2020", "2030", "2040"]
    },
    "asia": {
        title: "Población en Asia (millones)",
        data: [3000, 3500, 4000, 4500, 5000],
        labels: ["2000", "2010", "2020", "2030", "2040"]
    },
    "oceania": {
        title: "Disponibilidad de Agua en Oceanía",
        data: [80, 75, 70, 60, 55],
        labels: ["2000", "2010", "2020", "2030", "2040"]
    }
};

// Habilitar Drag & Drop
muneco.addEventListener("dragstart", (event) => {
    event.dataTransfer.setData("text", "muneco");
    setTimeout(() => {
        muneco.style.visibility = "hidden";
    }, 0);
});

// Hacer que los continentes acepten el drop
document.querySelectorAll(".continente").forEach(continente => {
    continente.addEventListener("dragover", (event) => {
        event.preventDefault();
    });

    continente.addEventListener("drop", (event) => {
        event.preventDefault();
        muneco.style.visibility = "visible";

        const continenteID = event.target.id;
        if (dataContinentes[continenteID]) {
            const { title, data, labels } = dataContinentes[continenteID];
            popupTitle.innerText = title;

            // Si hay un gráfico previo, destruirlo para evitar duplicados
            if (chartInstance) {
                chartInstance.destroy();
            }

            // Crear gráfico en el pop-up
            const ctx = popupChartCanvas.getContext("2d");
            chartInstance = new Chart(ctx, {
                type: "line",
                data: {
                    labels: labels,
                    datasets: [{
                        label: title,
                        data: data,
                        borderColor: "blue",
                        fill: false
                    }]
                }
            });

            popup.style.display = "block";
        }
    });
});

// Cerrar pop-up y resetear muñeco
closePopup.addEventListener("click", () => {
    popup.style.display = "none";
    muneco.style.left = `${initialPosition.x}px`;
    muneco.style.top = `${initialPosition.y}px`;
    muneco.style.visibility = "visible";
});
/* ================================
   SIMULADOR DE ESCENARIOS CON WEB STORAGE
   ================================ */

const simuladorForm = document.getElementById('simuladorForm');
const resultadoSimulacion = document.getElementById('resultadoSimulacion');

simuladorForm.addEventListener('submit', (e) => {
  e.preventDefault();
  const temperatura = parseFloat(document.getElementById('temperatura').value);
  const precipitacion = parseFloat(document.getElementById('precipitacion').value);

  // Lógica de simulación sencilla (puedes mejorarla según datos científicos)
  const impacto = (temperatura * 0.3) - (precipitacion * 0.2);
  resultadoSimulacion.textContent = `Con un aumento de ${temperatura}°C y un cambio del ${precipitacion}% en precipitaciones, el impacto estimado es: ${impacto.toFixed(2)}`;

  // Creamos un objeto con los datos de la simulación
  const simulacion = {
      fecha: new Date().toISOString(),
      temperatura,
      precipitacion,
      impacto: impacto.toFixed(2)
  };

  // Recuperamos el array de simulaciones almacenado en localStorage (o inicializamos uno nuevo)
  let simulaciones = JSON.parse(localStorage.getItem('simulaciones')) || [];
  simulaciones.push(simulacion);

  // Guardamos el array actualizado en localStorage
  localStorage.setItem('simulaciones', JSON.stringify(simulaciones));

  // Mostramos en la consola el array de simulaciones almacenadas
  console.log("Simulaciones almacenadas:", simulaciones);
});
