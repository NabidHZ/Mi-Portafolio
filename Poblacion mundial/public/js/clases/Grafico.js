// Clase Grafico: gestión de la representación de datos en el canvas
export class Grafico {
    constructor(canvasId) {
      this.canvas = document.getElementById(canvasId);
      if (!this.canvas) {
        console.error(`No se encontró el canvas con id "${canvasId}"`);
        return;
      }
      this.ctx = this.canvas.getContext('2d');
      this.padding = 50;
    }
  
    // Método para dibujar los ejes X e Y
    dibujarEjes() {
      const { ctx, canvas, padding } = this;
      ctx.clearRect(0, 0, canvas.width, canvas.height);
      
      // Eje X
      ctx.beginPath();
      ctx.moveTo(padding, canvas.height - padding);
      ctx.lineTo(canvas.width - padding, canvas.height - padding);
      ctx.strokeStyle = '#333';
      ctx.stroke();
  
      // Eje Y
      ctx.beginPath();
      ctx.moveTo(padding, canvas.height - padding);
      ctx.lineTo(padding, padding);
      ctx.stroke();
    }
  
    // Método para dibujar datos (por ejemplo, en un gráfico de líneas)
    dibujarDatos(datos = []) {
      const { ctx, canvas, padding } = this;
      if (datos.length === 0) return;
  
      // Calculamos el ancho entre cada dato
      const espacio = (canvas.width - 2 * padding) / (datos.length - 1);
      ctx.beginPath();
      ctx.strokeStyle = 'blue';
      ctx.lineWidth = 2;
  
      datos.forEach((valor, i) => {
        const x = padding + (espacio * i);
        // Suponemos que el valor máximo es 500 para escalar en el canvas
        const y = canvas.height - padding - (valor / 500) * (canvas.height - 2 * padding);
        if (i === 0) {
          ctx.moveTo(x, y);
        } else {
          ctx.lineTo(x, y);
        }
      });
      ctx.stroke();
    }
  }
  