// let numero = 10;
// console.log(++numero)
// console.log(numero++)
// console.log(numero)
// console.log("10" - 7)

// console.log(10=="10", 10==="10")

// console.log(!(1>3) && 3>=3 && !(-12 < -3));

// let num1 = 9;
// let num2 = 7;

// let total = (7 * (num1 + num2)) / 2;

// if (total <= 70) {
//     console.log("1")
// } else if (total >= 70) {
//     console.log("2")
// } else {
//     console.log("3")
// }

function esPar(num) {
    if (num % 2 === 0) {
        return "El numero " + num + " es par";
    } else{
        return "El numero " + num + " es impar";
    }
}
console.log(esPar(10 / 2));

// Desarrollar una función llamada cuadradoDeUnNumero, que reciba un parámetro, la misma deberá verificar que el tipo de dato sea number, en caso de ser así retornará ese numero elevado al cuadrado, caso contrario retornar un mensaje "No es posible operar con el tipo de dato" + <tipo de dato>.

function cuadradoDeUnNumero(num) {
    if (!isNaN(num)) {
        return Math.pow(num , 2);
    } else {
        return "No es posible operar con el tipo de dato " + typeof(num)
    }
}
console.log(cuadradoDeUnNumero(4))
console.log(cuadradoDeUnNumero("hola"))
console.log(cuadradoDeUnNumero(false))