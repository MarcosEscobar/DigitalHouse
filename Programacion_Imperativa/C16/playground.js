// EJERCICIO 1
let dameCinco = () => [1,2,3,4,5];
let multiplicarPorDos = () =>  123 * 2 ;
let mostrarNombre = () => "Mi nombre es Hernán";

console.log(dameCinco());
console.log(multiplicarPorDos());
console.log(mostrarNombre());

// EJERCICIO 2
let saludar1 = nombre => 'Hola, ' + nombre + '!';

console.log(saludar1('Marcos'));

// EJERCICIO 3
let saludar2 = (nombre, apellido) => 'Hola, ' + nombre + ' ' +  apellido + '!';

console.log(saludar2('Marcos', 'Escobar'));

// EJERCICIO 4
let doble = numero => numero * 2;
let triple = numero => numero*3;
let aplicarCallback = (numero, operacion) => operacion(numero);

console.log(aplicarCallback(2, doble))
console.log(aplicarCallback(4, triple)); // 12

//EJERCICIO 5
let suma = (a , b) => a + b;
let resta = (a , b) => a - b;
let multiplicacion = (a , b) => a * b;
let division = (a , b) => a / b;
let calculadora = (a , b , operacion) => operacion(a , b);

console.log(calculadora(5 , 3 , suma));
console.log(calculadora(5 , 3 , resta));
console.log(calculadora(5 , 3 , multiplicacion));
console.log(calculadora(5 , 3 , division));

// EJERCICIO 6
// let agregarHttp = url => 'http://' + url;
// let largoString = url => url.length;

// function procesar(url, operacion) {
//     resultado = [];
//     for (let i = 0; i < url.length; i++) {
//         resultado.push(operacion(url[i]));
//     }
//     return resultado;
// }

// VALIDO EN PLAYGROUND
function agregarHttp(url) {
    return 'http://' + url;
}

function procesar(url,operacion){
    resultado = [];
    for (let i = 0; i < url.length; i++) {
        resultado.push(operacion(url[i]));
    }
    return resultado;
}
let urlCompletas = procesar(["www.google.com","www.yahoo.com"],agregarHttp)
console.log(urlCompletas); // imprime [ 'http://www.google.com', 'http://www.yahoo.com' ]
let largoDeElmentos = procesar(["www.google.com","www.yahoo.com"],largoString)
console.log(largoDeElmentos); // imprime [ 14, 13 ]

