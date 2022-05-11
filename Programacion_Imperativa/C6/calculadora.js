// Crear un archivo calculadora.js que contendrá las distintas operaciones a realizar de nuestra calculadora.

// Crear una función sumar, esta deberá recibir dos parámetros y retornar la suma de los mismos.
function sum(a , b){
    return a + b;
}
// Crear una función restar, la cual deberá recibir dos parámetros y retornar la resta del primero menos el segundo.
function substract(a , b) {
    return a - b;
}
// Crear una función multiplicar, la misma deberá recibir dos parámetros y retornar el resultado de su multiplicación
function product(a , b) {
    return a * b;
}
// Crear una función dividir, la cual recibirá dos parámetros y retorna el resultado de la división del primero sobre el segundo.
function divide(a , b) {
    return a / b;
}
// Crear una función que se llame cuadradoDeUnNumero, la cual recibe un número como parámetro y deberá retornar ese número elevado al cuadrado.
// Importante: cuadradoDeUnNumero() deberá utilizar la función multiplicar() para calcular el cuadrado del parámetro ingresado a cuadradoDeUnNumero()
function cuadradoDeUnNumero(number) {
    return product(number, number);
}
// Crear la función promedioDeTresNumeros, la misma deberá calcular el promedio de 3 números, que serán ingresados por parámetro.
// Importante: promedioDeTresNumeros() deberá utilizar algunas funciones previamente creadas de nuestra calculadora.
function promedioDeTresNumeros(a , b , c) {
    return divide(sum(sum( a , b), c) , 3);
}
// Crear la función calcularPorcentaje. Esta recibirá dos parámetros: el número total y el porcentaje que se le quiere calcular. Deberá retornar el x% del total.
// Ejemplo: calcularPorcentaje(300, 15) debe retornar 45, ya que es el 15% de 300.
// Importante: calcularPorcentaje() deberá utilizar algunas funciones previamente creadas de nuestra calculadora.
function calcularPorcentaje(a , b) {
    // return divide(product(a , b) , 100);
    // return Math.round(product(a, divide(b,100)));
    return Math.round(product(a , divide(b , 100)));
}
// Crear una función GeneradorDePorcentaje que recibe dos parámetros y deberá retornar el porcentaje del primero con respecto al segundo.
// Ejemplo: GeneradorDePorcentaje(2, 200) deberá retornar 1, ya que 2 es el 1% de 200.
function GeneradorDePorcentaje(a , b) {
    // return Math.round(divide(product(a, 100), b));
    return Math.round(product(divide(a , b), 100))
}
// En el archivo calculadora.js —debajo de nuestras 4 funciones hechas con anterioridad— creá un console.log en el cual vas a poner un string para indicar que debajo de él comenzarás a probar las funciones. Por ejemplo:

// console.log(“-------------- Testeo de Operaciones / Calculadora --------------”)
console.log('-------------- Testeo de Operaciones / Calculadora --------------');
// Ejecutar la función que permite sumar y la función que permite restar pasando como argumentos dos números cualesquiera. Mostrar en consola los resultados.
console.log("EJERCICIO 1 ", sum(1 , 2));
console.log("EJERCICIO 2 ", substract(1 , 2));
// Ejecutar la función que permite multiplicar pasando como argumentos dos números cualesquiera. Mostrar en consola el resultado.
console.log("EJERCICIO 3 ", product(1 , 2));
// Ejecutar la función que permite dividir pasando como argumentos dos números cualesquiera. Mostrar en consola el resultado.
console.log("EJERCICIO 4 ", divide(1 , 2));
// Ejecutar la función que permite dividir pasando ahora, como uno de los dos argumentos, el número cero. Mostrar en consola el resultado.
console.log("EJERCICIO 5 ", divide(1 , 0)," | ", divide(0 , 2));
console.log("---------------------------- PARTE 3 ----------------------------")
console.log("EJERCICIO", cuadradoDeUnNumero(2))
console.log("EJERCICIO", promedioDeTresNumeros(1 , 2 , 3))
console.log("EJERCICIO", calcularPorcentaje(300, 15))
console.log("EJERCICIO", GeneradorDePorcentaje(2, 200))
