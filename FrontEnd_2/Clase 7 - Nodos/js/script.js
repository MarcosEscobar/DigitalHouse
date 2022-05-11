/*************************** VERSION 1 ***************************/
const urlImagen1 = prompt('Ingrese la url de la imagen 1 por favor');
console.log(urlImagen1);
const imagen1 = document.querySelector('#imagen-1');
imagen1.setAttribute('src', urlImagen1);
imagen1.setAttribute('width', '500px');

const urlImagen2 = prompt('Ingrese la url de la imagen 2 por favor');
console.log(urlImagen2);
const imagen2 = document.querySelector('#imagen-2');
imagen2.setAttribute('src', urlImagen2);
imagen2.setAttribute('width', '500px');



const urlImagen3 = prompt('Ingrese la url de la imagen 3 por favor');
console.log(urlImagen2);
const imagen3 = document.querySelector('#imagen-3');
imagen3.setAttribute('src', urlImagen3);
imagen3.setAttribute('width', '500px');


/*************************** VERSION 2 ***************************/
const imagenes = document.querySelectorAll('.imagen');
const tarjetas = document.querySelectorAll(".tarjeta");

tarjetas.forEach((tarjeta, i) => {
  const urlImagen = prompt('Ingrese la url de la imagen ' + (i + 1) + ' por favor');
  const imagen = imagenes[i];
  const tagAnchor = document.createElement("a");
  
  imagen.setAttribute('src', urlImagen);
  imagen.setAttribute('width', '500px');
  tagAnchor.setAttribute("href", urlImagen);
  tagAnchor.appendChild(imagen);
  tarjeta.appendChild(tagAnchor);
});


/*************************** VERSION 3 ***************************/
/*
ETAPA 3
    - Nodo padre: contenedor
    - Nodo hijo repetitivo: tarjeta
    - Explicación:
        1. Determinar la cantidad de tarjetas que se van a crear
        2. Obtener el nodo padre
        3. Crear la función que agregará el template. Va a recibir el url de la imágen, y el nro de la imágen
        4. Crear el template:
            const template = `
                  <div class="tarjeta">
                      <a href="${urlImg}" class="rutas-img">
                        <img src="${urlImg}" class="imagen" alt="imagen-${nroImg}" id="imagen-${nroImg}">
                      </a>
                  </div>
              `;
        5. Comenzar un bucle hasta la cantidad determinada de tarjetas
        6. En cada iteración llamar a la funcion que crea el template y lo agrega al nodo padre
*/
const cdadImagenes = prompt('Ingrese la cantidad de imágenes que desea agregar por favor:');
const contenedor = document.querySelector(".contenedor");

for (let i = 1; i <= cdadImagenes; i++) {
  const urlImagen = prompt('Ingrese la url de la imagen ' + i + ' por favor');
  crearTarjeta(urlImagen, i);
}

function crearTarjeta(urlImg, nroImg) {
  const template = `
                <div class="tarjeta">
                    <a href="${urlImg}" class="rutas-img">
                      <img src="${urlImg}" class="imagen" alt="imagen-${nroImg}" id="imagen-${nroImg}">
                    </a>
                </div>
            `;
  contenedor.innerHTML += template;
}