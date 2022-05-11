// let numbers =[22, 33, 54, 66, 72];
// console.log(numbers[numbers.length]);
// //Devuelve "Undefined" ya que numbers.length = 5 y no existe el elemento numbers[5]

// let grupoDeAmigos = [ ["Harry", "Ron", "Hermione"], ["Spiderman", "Hulk","Ironman"], ["Penélope Glamour","Pierre Nodoyuna","Patán"] ];

// console.log(grupoDeAmigos[1][0]);
// // El valor devuelto es "Spiderman" ya que es el array [1] elemento [0]

// let str = "un string cualquiera";
// let grupoDeAmigos = [ [45, 89, 0], ["Digital", "House", true], ["string","123","false", 54, true, str] ]
// console.log(grupoDeAmigos[2][grupoDeAmigos[2].length - 1]);
// //Devuelve "un String Cualquiera" porque se ubica en el array [2] elemento [5] = str

//PUNTO 1
let movies = ['star wars' , 'totoro', 'rocky' , 'pulp fiction' , 'la vida es bella'];

//PUNTO 2
let auxA = []; //variable auxiliar para función recursiva
function arrayToUpperCase(array) {
    if (array.length != 1){ //si el array original tiene más de un elemento :
        auxA.push(array.shift().toUpperCase());//muevo el primer elemento en mayus al último lugar del array auxiliar.
        arrayToUpperCase(array);//vuelvo a llamar a la función con el array al que le saqué un elemento.
    } else { //cuando al array le quede un solo elemento:
        auxA.push(array.shift().toUpperCase());//inserto el último elemento al array auxiliar.
    }
    return auxA;//devuelvo el array completo en mayúscula.
}
movies = arrayToUpperCase(movies);

//PUNTO 3
let movies2 = ['toy story' , 'finding Nemo' , 'kung-fu panda' , 'wally' , 'fornite'];
//PUNTO 4

let deletedItems = movies2.pop();//sacamos el último elemento del array.

movies2 = arrayToUpperCase(movies2);//Pasamos las películas infantiles

function arrayConcatenate(arrayA , arrayB) {
    return arrayA.concat(arrayB);//contatenamos los 2 arrays.
}

//PUNTO 5
const asiaScores = [8, 10, 6, 9, 10, 6, 6, 8, 4];
const euroScores = [8, 10, 6, 8, 10, 6, 7, 9, 5];


console.log("movies", movies);
console.log("concatenated", arrayConcatenate(movies2,movies2))
