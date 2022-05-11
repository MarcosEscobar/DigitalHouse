// !true es false
// !false  es true
// !!false es false
// !!true es true
// !1 es false
// !!1 es true
// !0 es true
// !!0 es false
// !!"" es false

// let x = 5 ; let y = 9;
// x < 10 && x!==5 es false
// x>9 || x===5 es true
// !(x===y) es true

// let x=10
// let y ="a"
// y==="b" || x >= 10

// es true


// let x=3
// let y=8
// !(x == "3" || x === y) && !(y !== 8 && x <= y)

// es false

// let str = ""
// let msj = "jaja!"
// let esGracioso = "false"
// !((str || msj) && esGracioso)

// es false

// 1. Para subir a una montaña rusa la edad debe ser mayor a 12 años y la altura
// debe ser mayor a 1,30 m.
let age = 12;
let height = 130;

function paseMontanaRusa(a = 0 , h = 0) {
    return a > 12 && h > 130;
}
console.log("EJERCICIO 1");
console.log(paseMontanaRusa(13 , 145));
console.log(paseMontanaRusa());

// 2. Si no hay suficiente luz o el objeto se mueve rápidamente, la cámara de fotos
// debe usar el flash.
function usarFlash(a=false, b=true) {
    return !a || b;
}
console.log("EJERCICIO 2");
console.log(usarFlash(false,true));

// 3. Un estudiante pasa de nivel si su nota es mayor a 7 en sus dos evaluaciones
// parciales, o si obtiene un 4 en el examen final.
function aprobar(a, b , c) {
    return (a >= 7 && b >= 7) || c >= 4;
}
console.log("EJERCICIO 3")
console.log(aprobar(5,6,4));
console.log(aprobar(7,7,1));


// 4. Dejamos ver la TV a nuestro hijo si realizó la tarea pero además, si tocó sus
// prácticas de piano y lo hizo de memoria.
function mirarTv(a , b , c) {
    return a && b && c;
}
console.log("EJERCICIO 4");
console.log(mirarTv(1,1,1));
console.log(mirarTv(1,1,0));

let dato = false;
if (dato == false) {
    console.log("es true");
} else {
    console.log("es false");
}