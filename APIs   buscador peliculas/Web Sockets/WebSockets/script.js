const ws = new WebSocket('ws://' + window.location.host);

ws.onmessage = event => {
    const data = JSON.parse(event.data);
    const resultadoDiv = document.getElementById('resultado');
    resultadoDiv.innerHTML = '';

    if (data.Search) {
        data.Search.forEach(item => {
            const elemento = document.createElement('p');
            elemento.textContent = `${item.Title} (${item.Year})`;
            resultadoDiv.appendChild(elemento);
        });
    } else {
        resultadoDiv.textContent = 'No se encontraron resultados.';
    }
};

function buscar() {
    const titulo = document.getElementById('titulo').value;
    const tipo = document.getElementById('tipo').value;
    ws.send(JSON.stringify({ titulo, tipo }));
}
