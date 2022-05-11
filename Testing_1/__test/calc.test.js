
const { not } = require("expect");
const funciones = require("../calc");

describe("operaciones matematicas",() =>{

    test("suma", () =>{
        expect (funciones.suma(2,2)).toBe(4);
    })

    test("resta", () =>{
        expect (funciones.resta("r",2)).toBe(0);
    })

    test("multiplicacion", () =>{
        expect (funciones.multiplicacion("l",2)).toBe(0);
    })

    test("division", () =>{
        expect (funciones.division("o",2)).toBe(0);
    })
})
