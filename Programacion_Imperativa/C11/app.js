// CLASE 11
// Marcos Escobar
// Joseph Jimenez Mendoza
// Cristian Navarro Leon
// Juan Araque Ballesteros
// Jhon Caicedo

let peliculas = ["star wars", "totoro", "rocky", "pulp fiction", "lavida es bella"];
let peliculas2 = ['toy story' , 'finding Nemo' , 'kung-fu panda' , 'wally' , 'fornite'];

// PUNTO 1
// function convertirAMayusculas(array){
//     array[0] = array[0].toUpperCase()
//     array[1] = array[1].toUpperCase()
//     array[2] = array[2].toUpperCase()
//     array[3] = array[3].toUpperCase()
//     array[4] = array[4].toUpperCase()
//     return array
//     }
    
function convertirAMayusculas(array = []){
    for (let i = 0; i < array.length; i++) {
        array.splice(i, 1 , array[i].toUpperCase())
    }
    return array
    }
console.log();
console.log('PUNTO 1');
console.log(convertirAMayusculas(peliculas));

// PUNTO 2
// function pasajeDeElementos(array1, array2) {
//     array1.push(array2.pop().toUpperCase())
//     array1.push(array2.pop().toUpperCase())
//     array1.push(array2.pop().toUpperCase())
//     array1.push(array2.pop().toUpperCase())
//     array1.push(array2.pop().toUpperCase())
//     return array
// }

function pasajeDeElementos(array1 = [], array2 = []) {
    while (array2.length >= 1) {
        array1.push(array2.pop().toUpperCase());
    }
    return array1;
}
console.log();
console.log('PUNTO 2');
console.log(pasajeDeElementos(peliculas,peliculas2));

// PUNTO 3

const asiaScores = [8, 10, 6, 9, 10, 6, 6, 8, 4];
const euroScores = [8, 10, 6, 8, 10, 6, 7, 9, 5];

// function compararCalificaciones(asia, europa) {
// let comparacionesAsiaEuropa = []
// comparacionesAsiaEuropa[0] = asia[0] === europa[0]
// comparacionesAsiaEuropa[1] = asia[1] === europa[1]
// comparacionesAsiaEuropa[2] = asia[2] === europa[2]
// comparacionesAsiaEuropa[3] = asia[3] === europa[3]
// comparacionesAsiaEuropa[4] = asia[4] === europa[4]
// comparacionesAsiaEuropa[5] = asia[5] === europa[5]
// comparacionesAsiaEuropa[6] = asia[6] === europa[6]
// comparacionesAsiaEuropa[7] = asia[7] === europa[7]
// comparacionesAsiaEuropa[8] = asia[8] === europa[8]
// return comparacionesAsiaEuropa
// }

function compararCalificaciones(asia, europa) {
    let comparacionesAsiaEuropa = [];
    for (let i = 0; i < asia.length; i++) {
        switch (asia[i] === europa[i]) {
            case true:
                comparacionesAsiaEuropa.push(true)
                break;
            default:
                comparacionesAsiaEuropa.push(false)
                break;
        }
    }
    return comparacionesAsiaEuropa
}
console.log();
console.log('PUNTO 3');
console.log(compararCalificaciones(asiaScores,euroScores));

// EXTRA BONUS
// CONCURSO DE CLAVADOS

// PUNTO 1

const participanteA = [5, 8, 4, 9, 5];
const participanteB = [8, 7, 8, 6, 8];
const participanteC = [7, 5, 10, 8, 3];

// PUNTO 2
// Mejor promedio (el mayor puntaje promedio entre los competidores).

function puntajePromedio(participante) {
    let sumaPuntajes = 0;
    for (let i = 0; i < participante.length; i++) {
        sumaPuntajes = sumaPuntajes + participante[i];
    }
    return sumaPuntajes / participante.length;
}
console.log();
console.log('Promedios:')
console.log('Participante A: ' + puntajePromedio(participanteA) + ' | Participante B: ' + puntajePromedio(participanteB)+ ' | Participante C: ' + puntajePromedio(participanteC));

// Mayor puntaje (el mayor puntaje de entre los 5 clavados de cada participante).

function puntajeMayor(participante) {
    let mayor = 0;
    for (let i = 0; i < participante.length; i++) {
        if (mayor < participante[i]) {
            mayor = participante[i];
        }
    }
    return mayor;
}
console.log();
console.log('Mayor Puntaje:')
console.log();
console.log('Participante A: ' + puntajeMayor(participanteA) + ' | Participante B: ' + puntajeMayor(participanteB)+ ' | Participante C: ' + puntajeMayor(participanteC));

function competencia(A, B, C) {

    let competenciaPuntaje = [puntajeMayor(A), puntajeMayor(B), puntajeMayor(C)];
    let competenciaPromedio = [puntajePromedio(A), puntajePromedio(B), puntajePromedio(C)];
    
    let ganadorPuntaje = 0;
    let puntajeGanador = 0;
    for (let i = 0; i < competenciaPuntaje.length; i++) {
        if (puntajeGanador < competenciaPuntaje[i]) {
            puntajeGanador = competenciaPuntaje[i];
            ganadorPuntaje = i;
        }
    }
    console.log();
    console.log('El ganador por puntaje es el participante ' + ganadorPuntaje + ' con el puntaje: ' + puntajeGanador);

    let ganadorPromedio = 0;
    let promedioGanador = 0;
    for (let i = 0; i < competenciaPromedio.length; i++) {
        if (promedioGanador < competenciaPromedio[i]) {
            promedioGanador = competenciaPromedio[i];
            ganadorPromedio = i;
        }
    }
    console.log();
    console.log('El ganador por Promedio es el participante ' + ganadorPromedio + ' con el puntaje: ' + promedioGanador);
}
console.log();
competencia(participanteA, participanteB, participanteC);