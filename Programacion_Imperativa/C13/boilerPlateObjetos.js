// EQUIPO 7

// MJ
// marcos javier escobar martin
// MP
// maureen parra
// LF
// luis fernando rodríguez ortiz
// DL
// daniel leonardo arcila ibague
// DG
// diego garcia
// JV
// julieta vittori

//la lista de clientes.
let arrayCuentas = [
  {
    nroCuenta: 5486273622,
    tipoDeCuenta: "Cuenta Corriente",
    saldoEnPesos: 27771,
    titularCuenta: "Abigael Natte",
  },
  {
    nroCuenta: 1183971869,
    tipoDeCuenta: "Caja de Ahorro",
    saldoEnPesos: 8675,
    titularCuenta: "Ramon Connell",
  },
  {
    nroCuenta: 9582019689,
    tipoDeCuenta: "Caja de Ahorro",
    saldoEnPesos: 27363,
    titularCuenta: "Jarret Lafuente",
  },
  {
    nroCuenta: 1761924656,
    tipoDeCuenta: "Cuenta Corriente",
    saldoEnPesos: 32415,
    titularCuenta: "Ansel Ardley",
  },
  {
    nroCuenta: 7401971607,
    tipoDeCuenta: "Cuenta Unica",
    saldoEnPesos: 18789,
    titularCuenta: "Jacki Shurmer",
  },
];
// podes continuar tu codigo a partir de aca!

let banco = {
  clientes : arrayCuentas,
  consultarCliente : function (titular) {
                          for (let i = 0; i < this.clientes.length; i++) {
                            let cliente = this.clientes[i];
                            if (titular === cliente.titularCuenta) {
                              return cliente;
                            }
                        }
                        return 'Cliente no encontrado';
  },
  Depositar : function (titular, importe) {
    cuenta = this.consultarCliente(titular);
    cuenta.saldoEnPesos = cuenta.saldoEnPesos + importe;
    console.log('Su nuevo saldo es: ' + cuenta.saldoEnPesos);
  },
  Retirar : function (titular, extraccion) {
    cuenta = this.consultarCliente(titular);
    if ((cuenta.saldoEnPesos - extraccion) < 0) {
      console.log('Saldo insuficiente')
    }
    cuenta.saldoEnPesos = cuenta.saldoEnPesos - extraccion;
    console.log('Su saldo actual es: ' + cuenta.saldoEnPesos);
    return cuenta.saldoEnPesos;
  }
}
// let clienteEncontrado = banco.consultarCliente("Jacki Shurmer");
// let depositoRealizado = banco.Depositar(clienteEncontrado.titularCuenta, 1000)
let retiroRealizado1 = banco.Retirar("Jacki Shurmer", 1000);
let retiroRealizado2 = banco.Retirar("Jacki Shurmer", 1000);
let retiroRealizado3 = banco.Retirar("Jacki Shurmer", 1000);

console.log(retiroRealizado1);
console.log(retiroRealizado2);
console.log(retiroRealizado3);
console.log(banco.clientes[4].saldoEnPesos);