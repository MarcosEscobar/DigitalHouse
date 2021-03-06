const v = "\x1b[32m%s\x1b[0m"; // NO TOCAR
const o = "*".repeat(80) + "\n"; // NO TOCAR
const oo = "*".repeat(25); // NO TOCAR
// Te proveemos la siguiente plantilla que tiene dos partes:
// - Desarrollo de las consignas, donde escribirás el código que responda a los enunciados
// - Ejecución de las consignas, donde ejecutarás los métodos correspondientes mostrando por consola sus resultados
const nombre = "MARCOS JAVIER ESCOBAR";
const tema = "TEMA 1";
const jsonHelper = require('./jsonHelper')
/*******************************/
/* Desarrollo de las consignas */
/*******************************/
// A
const gestionDePeliculas = {
// B
    peliculas : jsonHelper.leerJson('peliculas'),
// C
    listarPeliculas : function (arrayPpeliculas) {
        arrayPpeliculas.forEach(pelicula => {
            let premiada = pelicula.fuePremiada ? "Premiada" : "Sin premios";
        console.log(
            `${pelicula.titulo}, de ${pelicula.director}. Duración de ${pelicula.duracion} minutos, ${premiada} (${pelicula.calificacionIMDB}) en IMDB`
        );
        });       
    },
// D
    buscarPorTitulo : function(titulo) {
       return this.peliculas.find((pelicula)=> pelicula.titulo === titulo);
    },
// E
    peliculasPremiadas : function () {
       return this.peliculas.filter((pelicula) => pelicula.fuePremiada);
    },
// F
    filtrarPorDuracion : function (min , max) {
        return this.peliculas.filter((pelicula) => pelicula.duracion >= min && pelicula.duracion <= max);
    },
// G
    ordenarPorCalificacion : function () {
        return this.peliculas.sort((a , b) => a.calificacionIMDB - b.calificacionIMDB);
    },
// H
    duracionTotal : function () {
        let total = this.peliculas.reduce((tiempoTotal, pelicula) => tiempoTotal + pelicula.duracion, 0); 
        return `La duración de todas las películas sumadas es de ${total} minutos`;
    },
// I
    premiarPeliculaPorTitulo : function (titulo) {
        let peliculaEncontrada = this.buscarPorTitulo(titulo);
        if (peliculaEncontrada){
            peliculaEncontrada.fuePremiada = true;
            jsonHelper.escribirJson("peliculas" , this.peliculas);
        }
    }
};
/******************************/
/* Ejecución de las consignas */
/******************************/
console.table([{ alumno: nombre, tema: tema }]); // NO MODIFICAR NADA DE ESTA LINEA

console.log(v, "\n" + oo + " .C. Listar");
gestionDePeliculas.listarPeliculas(gestionDePeliculas.peliculas);
console.log(o);

console.log(v, oo + " .D. Buscar");
console.log(gestionDePeliculas.buscarPorTitulo("Career Girls"));
console.log(o);

console.log(v, oo + " .E. Filtrar 1");
gestionDePeliculas.listarPeliculas(gestionDePeliculas.peliculasPremiadas());
console.log(o);

console.log(v, oo + " .F. Filtrar 2");
gestionDePeliculas.listarPeliculas(gestionDePeliculas.filtrarPorDuracion(90 , 120));
console.log(o);

console.log(v, oo + " .G. Ordenar");
gestionDePeliculas.listarPeliculas(gestionDePeliculas.ordenarPorCalificacion());
console.log(o);

console.log(v, oo + " .H. Duracion");
console.log(gestionDePeliculas.duracionTotal());
console.log(o);

console.log(v, oo + " .I. Modificar Propiedad");
console.log(gestionDePeliculas.buscarPorTitulo("Career Girls"));
gestionDePeliculas.premiarPeliculaPorTitulo("Career Girls");
console.log(gestionDePeliculas.buscarPorTitulo("Career Girls"));
console.log(o);