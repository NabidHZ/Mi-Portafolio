// public/js/clases/Mapa.js

export class Mapa {
    constructor(divId) {
      this.divId = divId;
      this.map = null;
    }
  
    inicializar() {
      // Crea el mapa centrado en coordenadas globales (por ejemplo, [20, 0]) con un zoom inicial
      this.map = L.map(this.divId).setView([20, 0], 2);
  
      // Agrega la capa de tiles de OpenStreetMap
      L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; OpenStreetMap contributors',
        maxZoom: 19
      }).addTo(this.map);
    }
  
    agregarMarcador(lat, lng, popupText = '') {
      if (this.map) {
        L.marker([lat, lng])
          .addTo(this.map)
          .bindPopup(popupText)
          .openPopup();
      }
    }
  }
  