const express = require('express');
const https = require('https');
const fs = require('fs');
const path = require('path');
const mongoose = require('mongoose');

const app = express();
const PORT = process.env.PORT || 3000;

// Configuración de Pug como motor de vistas (aunque este ejemplo sirve contenido estático)
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');

// Middleware para parsear el cuerpo de las solicitudes
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// Servir archivos estáticos desde la carpeta public
app.use(express.static(path.join(__dirname, '../public')));

// Ruta principal
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, '../public/index.html'));
});

// Conexión a MongoDB con Mongoose
const mongoURI = 'mongodb://127.0.0.1:27017/proyectoEvolucion';
mongoose.connect(mongoURI, {
  useNewUrlParser: true,
  useUnifiedTopology: true
})
  .then(() => console.log('Conectado a MongoDB con Mongoose'))
  .catch(err => console.error('Error de conexión a MongoDB', err));

/* 
  ========================
  CRUD CON MONGOOSE
  ========================
*/

// Definición del esquema y modelo "Item"
const itemSchema = new mongoose.Schema({
  name: { type: String, required: true },
  description: String,
  createdAt: { type: Date, default: Date.now }
});

const Item = mongoose.model('Item', itemSchema);

// Crear un nuevo ítem (Create)
app.post('/items', async (req, res) => {
  try {
    const newItem = new Item(req.body);
    const savedItem = await newItem.save();
    res.status(201).json(savedItem);
  } catch (err) {
    res.status(400).json({ error: err.message });
  }
});

// Obtener todos los ítems (Read)
app.get('/items', async (req, res) => {
  try {
    const items = await Item.find();
    res.status(200).json(items);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// Obtener un ítem por su ID (Read)
app.get('/items/:id', async (req, res) => {
  try {
    const item = await Item.findById(req.params.id);
    if (!item) {
      return res.status(404).json({ error: 'Ítem no encontrado' });
    }
    res.status(200).json(item);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// Actualizar un ítem por su ID (Update)
app.put('/items/:id', async (req, res) => {
  try {
    const updatedItem = await Item.findByIdAndUpdate(
      req.params.id,
      req.body,
      { new: true }
    );
    if (!updatedItem) {
      return res.status(404).json({ error: 'Ítem no encontrado' });
    }
    res.status(200).json(updatedItem);
  } catch (err) {
    res.status(400).json({ error: err.message });
  }
});

// Eliminar un ítem por su ID (Delete)
app.delete('/items/:id', async (req, res) => {
  try {
    const deletedItem = await Item.findByIdAndDelete(req.params.id);
    if (!deletedItem) {
      return res.status(404).json({ error: 'Ítem no encontrado' });
    }
    res.status(200).json({ message: 'Ítem eliminado correctamente' });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

/* 
  ========================
  FIN DE CRUD
  ========================
*/

// Configuración de HTTPS
const sslOptions = {
  key: fs.readFileSync(path.join(__dirname, 'cert', 'key.pem')),
  cert: fs.readFileSync(path.join(__dirname, 'cert', 'cert.pem'))
};

https.createServer(sslOptions, app).listen(PORT, () => {
  console.log(`Servidor HTTPS corriendo en el puerto ${PORT}`);
});

/* 
// Si prefieres usar HTTP para pruebas, comenta el bloque anterior y descomenta el siguiente:
// app.listen(PORT, () => {
//   console.log(`Servidor HTTP corriendo en el puerto ${PORT}`);
// });
*/
