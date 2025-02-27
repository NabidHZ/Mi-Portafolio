const mongoose = require('mongoose');

const PrediccionSchema = new mongoose.Schema({
  año: { type: Number, required: true },
  poblacion: { type: Number, required: true },
  disponibilidadAgua: { type: Number, required: true }, // Porcentaje o valor representativo
  descripcion: { type: String, default: '' }
});

// Exportamos el modelo "Prediccion"
module.exports = mongoose.model('Prediccion', PrediccionSchema);