// GRUPO 9
// marcos javier escobar martin
// diego andres yepes celis
// milo hernández ramírez
// juan manuel araque ballesteros
// sorany pulgarin villa

const alicia = [23, 69, 32];
const bob = [12, 67, 43];
const participantes = ['Alicia', 'Bob'];


function encontrarGanador(a , b) {
    let ganador = [];
    let puntosPrimerParticipante  = 0;
    let puntosSegundoParticipante = 0;
    for (let i = 0; i < 3; i++) {
        if (a[i] > b[i]) {
            puntosPrimerParticipante++;
        } else {
            puntosSegundoParticipante++;
        }
    }
    return ganador = (puntosPrimerParticipante > puntosSegundoParticipante) ? 1 : 2;
}

console.log('El ganador es: ' + participantes[encontrarGanador(alicia , bob)]);

function digitalHouse(a , b) {
    for (let i = 1; i <= 100; i++) {
        if (i % a) {// si es múltiplo de a verifica si también es múltiplo de b
            if (i % b) { // si es múltiplo de b imprime Digital House.
                console.log('Digital House');
            } else { // si no es múltiplo de b es sólo múltiplo de "a" e imprime Dígital
                console.log('Digital');
            }
        } else if(i % b) { // si es múltiplo solo de b imprime House.
            console.log('House');
        }
    }
}
digitalHouse(7,12);

function sumaArray(array) {
    let suma = 0;
    for (let i = 0; i < array.length; i++) {
        suma = suma + array[i];
    }
    return suma;
}
console.log(sumaArray([1, 2, 3, 4, 5, 6]));

function concatenar(array) {
    let concatenado = "";
    for (let i = 0; i < array.length; i++) {
        concatenado = concatenado + array[i];
    }
    return concatenado;
}
let frase = ['h', 'o', 'l', 'a'];
console.log(concatenar(frase));