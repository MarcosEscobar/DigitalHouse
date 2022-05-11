function noParesDeContarImparesHasta(numero){
    let esImpar = 0;
    for (i = 0; i <= numero; i++) {
    if (i % 2 !== 0) {
        esImpar ++;
        }
    }
    return esImpar;
}
console.log(noParesDeContarImparesHasta(4));