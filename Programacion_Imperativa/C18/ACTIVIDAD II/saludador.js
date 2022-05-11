
let esp = a => 'Hola ' + a + ', ¿Cómo estás hoy?';
let eng = a => 'Hi ' + a + ', how are you?';
let br = a => 'Oi ' + a + ', com você está hoje?';
let ger = a => 'Hallo ' + a + ', wie geht es dir heute?';
let saludar = (nombre, idioma) => console.log(idioma(nombre));

module.exports =  { saludar , esp , eng , br , ger};
saludar('Marcos', br);