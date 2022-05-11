// EQUIPO 9
// marcos javier escobar martin
// maureen parra
// julieta vittori
// daniel leonardo arcila ibague
// jhon alexander caicedo
const jsonHelper = require("./jsonHelper");

const concesionaria = {
  vehiculos: jsonHelper.leerArchivo("AUTOS"),
  incrementarPrecio: function (porcentaje) {
    let aux = porcentaje / 100 + 1;
    for (let i = 0; i < this.vehiculos.length; i++) {
      const vehiculo = this.vehiculos[i];
      vehiculo.precio *= aux;
    }
    jsonHelper.escribirArchivo("AUTOS", this.vehiculos);
    return `Los vehiculos aumentaron un %${porcentaje}`;
  },
  agregarAuto : function (marca, modelo, ano, precio, patente, vendido = false) {
      this.vehiculos.push({marca : marca, modelo : modelo, ano : ano, precio : precio, patente : patente, vendido : vendido })
      jsonHelper.escribirArchivo("AUTOS", this.vehiculos);
  },
  venderAuto : function (patente) {
      for (let i = 0; i < this.vehiculos.length; i++) {
        let vehiculo = this.vehiculos[i]
        if (vehiculo.patente == patente) {
              vehiculo.vendido = true;
              jsonHelper.escribirArchivo("AUTOS", this.vehiculos);
              return 'El vehículo con patente' + patente + ' fue vendido con éxito.'
            }
      }
      return 'El vehículo con patente' + patente + ' no ha sido encontrado.'
  },
  totalDeVentas : function () {
      let total = 0;
      for (let i = 0; i < this.vehiculos.length; i++) {
          if (this.vehiculos[i].vendido == true) {
              total = total + this.vehiculos[i].precio;
          }
      }
      return total;
  },
  eliminarAuto : function (patente) {
    for (let i = 0; i < this.vehiculos.length; i++) {
        let vehiculo = this.vehiculos[i]
        if (vehiculo.patente == patente) {
              this.vehiculos.splice(i, 1);
              jsonHelper.escribirArchivo("AUTOS", this.vehiculos);
              return 'El vehículo con patente' + patente + ' fue eliminado.'
            }
      }
    return 'El vehículo con patente' + patente + ' no ha sido encontrado.'
  }
};
concesionaria.agregarAuto('Ford', 'Focus', '1999', '300.000', 'AXC 123');
console.log(concesionaria.venderAuto('AXC 123'));
console.log(concesionaria.totalDeVentas());
console.log(concesionaria.eliminarAuto("AXC 123"));
// console.log(concesionaria.vehiculos);
// console.log(concesionaria.incrementarPrecio(20));