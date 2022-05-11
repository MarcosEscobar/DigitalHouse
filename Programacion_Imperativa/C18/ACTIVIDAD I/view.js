const inmobiliaria = require('./inmobiliaria');
const v = "\x1b[32m%s\x1b[0m";
const o = "*".repeat(80) + "\n";
const oo = "*".repeat(25);

console.log(v, "\n" + oo + "   B. listarDepartamentos");
inmobiliaria.listarDepartamentos(inmobiliaria.departamentos);
console.log(o);

console.log(v, oo + "   C. departamentosDisponibles");
console.log(inmobiliaria.departamentosDisponibles());
console.log(o);

console.log(v, oo + " D. buscarPorId");
console.log(inmobiliaria.buscarPorId(3));
console.log(o);

console.log(v, oo + "  E. buscarPorPrecio");
console.log(inmobiliaria.buscarPorPrecio(1000));
console.log(o);

console.log(v, oo + " F. precioConImpuesto");
inmobiliaria.precioConImpuesto(30);
console.log(o);

console.log(v, oo + " G. simplificarPropietarios");
inmobiliaria.simplificarPropietarios();
console.log(o);

// MESAS DE TRABAJO

console.log(v, oo + " A. alquilarDepartamento");
console.log(inmobiliaria.alquilarDepartamento(4));
console.log(o);

console.log(v, oo + " B. filtrarPetFriendly");
console.log(inmobiliaria.filtrarPetFriendly());
console.log(o);

console.log(v, oo + " C. rebajasPorNoAlquiler");
console.log(inmobiliaria.rebajasPorNoAlquiler());
console.log(o);

console.log(v, oo + " D. buscarPorPropietarios");
console.log(inmobiliaria.buscarPorPropietarios("Luis Perez"));
console.log(o);
