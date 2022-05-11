// Pedir domicilio de pizza por telefono

let saborPizza = "napolitana";
let tamañoPizza = "grande";
let cantidadPizzas = 6;

const DIRECCION_ENTREGA = "Avenida Siempre viva 720";
const TELEFONO_PIZZERIA = 123789456;

let metodoPago = "tarjeta credito";
let valorPizzaUSD = 1000;
let valorCervezaUSD = 250;
let cantidadCervezas = 40;

let totalDomicilio = ( valorPizzaUSD * cantidadPizzas ) + ( valorCervezaUSD * cantidadCervezas);

console.log(cantidadPizzas + " Pizzas de", saborPizza, tamañoPizza);
console.log("Entregar en " + DIRECCION_ENTREGA);
console.log("Método de pago: "+ metodoPago);
console.log("Valor total: $ " + totalDomicilio + " USD");

// Hacer un asado

let ingredientes = "";
