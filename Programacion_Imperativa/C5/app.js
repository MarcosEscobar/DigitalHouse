function round(number) {
    return Math.round(number * 100) / 100;
}
//Crear una función que convierta pulgadas en centímetros. Es decir, recibe por parámetro pulgadas y retorna su equivalente en centímetros.
function transform_inch_cm(number) {
    return number * 2.54;
}
//Crear una función que recibe un string y lo convierte en una URL.Ejemplo: “pepito” es devuelto como http://www.pepito.com”.
function transform_url(name) {
    return `http://www.${name}.com`;
}
//Crear una función que recibe un string y devuelve la misma frase, pero con admiración.
function add_exclamation(string) {
    return string+"!";
}
//Crear una función que calcule la edad de los perros, considerando que 1 año para nosotros son 7 de ellos.
function dog_age(age) {
    return age * 7;
}
//Crear una función que calcule el valor de tu hora de trabajo, introduciendo tu sueldo mensual como parámetro. Considera que tu mes de trabajo tiene 40 horas.
function hour_rate_calculator(salary) {
    return salary / 40;
}
//Crear la función calculadorIMC() que reciba la altura en metros y el peso en kilogramos y calcule el IMC de una persona. Luego, ejecutar la función probando diferentes valores.
function IMCcalculator(height, weight) {
    return round(weight / (height^2));
}
//Crear una función que recibe un string en minúscula, lo convierta a mayúsculas y lo retorne. 
function upperCase(string) {
    return string.toUpperCase();
}
//Crear una función que recibe un parámetro y devuelve qué tipo de dato es ese parámetro. 
function whatsThat(data) {
    return typeof(data);
}
//Crear una función a la que le pasamos el radio de un círculo y nos devuelve la circunferencia. 
function radiusToCircumference(radius) {
    return round(2 * Math.PI * radius);
}
console.log("========== EJERCICIOS CLASE 5 - GRUPO 9 =========")
console.log("")
console.log("==================== PARTE 1 ====================")
console.log("Ejercicio 1", transform_inch_cm(1));
console.log("Ejercicio 2", transform_url("name"));
console.log("Ejercicio 3", add_exclamation("Fraser de prueba"));
console.log("Ejercicio 4", dog_age(5));
console.log("Ejercicio 5", hour_rate_calculator(80000));
console.log("Ejercicio 6", IMCcalculator(1.8, 75)," | ",IMCcalculator(1.58, 49)," | ",IMCcalculator(1.6, 60));
console.log("")
console.log("==================== PARTE 2 ====================")
console.log("Ejercicio 1", upperCase("frase de prueba"));
console.log("Ejercicio 2", whatsThat(""), " | " ,whatsThat(1));
console.log("Ejercicio 3", radiusToCircumference(3));
