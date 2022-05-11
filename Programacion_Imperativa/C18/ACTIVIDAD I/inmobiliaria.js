const departamentos = require('./DEPARTAMENTOS');

const inmobiliaria = {
    // A
    departamentos,
    // B
    listarDepartamentos: function (arrDeptos) {
      for (let i = 0; i < arrDeptos.length; i++) {
        let disponible = arrDeptos[i].disponible ? "disponible" : "alquilado";
        let aceptaMascotas = arrDeptos[i].aceptaMascotas
          ? "acepta mascotas"
          : "no acepta mascotas";
        console.log(
          `id: ${arrDeptos[i].id}, precio: $ ${arrDeptos[i].precioAlquiler}, está ${disponible}, ` +
            `${arrDeptos[i].ambientes} ambiente${
              arrDeptos[i].ambientes > 1 ? "s" : ""
            }, máximo ${arrDeptos[i].cantidadPersonas}` +
            `personas, ${aceptaMascotas}, propietarios: ${arrDeptos[i].propietarios}`
        );
      }
    },
    // C
    departamentosDisponibles: function () {
      let disponibles = [];
      for (let i = 0; i < this.departamentos.length; i++) {
        if (this.departamentos[i].disponible) {
          disponibles.push(this.departamentos[i]);
        }
      }
      return disponibles;
    },
    // D
    buscarPorId: function (id) {
      let depto;
      let mensajeError =
        "No se encontro ningun departamento con el identificador: " + id;
      for (let i = 0; i < this.departamentos.length; i++) {
        if (this.departamentos[i].id === id) {
          depto = this.departamentos[i];
        }
      }
      return depto ? depto : mensajeError;
    },
    // E
    buscarPorPrecio: function (alquiler) {
      let deptosResultado = [];
      let mensajeError =
        "No se encontraron departamentos con alquileres menores a: $" + alquiler;
      let disponibles = this.departamentosDisponibles();
      for (let i = 0; i < disponibles.length; i++) {
        if (disponibles[i].precioAlquiler <= alquiler) {
          deptosResultado.push(disponibles[i]);
        }
      }
      if (deptosResultado.length > 0) {
        return deptosResultado;
      } else {
        return mensajeError;
      }
    },
    // F
    precioConImpuesto: function (porcentaje) {
      let aux = porcentaje / 100 + 1;
      for (let i = 0; i < this.departamentos.length; i++) {
        this.departamentos[i].precioAlquiler *= aux;
      }
      return this.departamentos;
    },
    // G
    simplificarPropietarios: function () {
      for (let i = 0; i < this.departamentos.length; i++) {
        let losPropietarios = this.departamentos[i].propietarios;
        let desde = losPropietarios.indexOf(":");
        let soloPropietarios = losPropietarios.slice(desde);
        this.departamentos[i].propietarios = "Prop." + soloPropietarios;
      }
      return this.departamentos;
    },
  
    // mesas de trabajo
    // A
    alquilarDepartamento: function (id) {
      let mensaje;
      let mensajeError =
        "No se encontro ningun departamento con el identificador: " + id;
      for (let i = 0; i < this.departamentos.length; i++) {
        if (this.departamentos[i].id === id) {
          this.departamentos[i].disponible = false;
          mensaje = "Departamento alquilado correctamente";
        }
      }
      if (mensaje) {
        return mensaje;
      } else {
        return mensajeError;
      }
    },
    // B
    filtrarPetFriendly: function () {
      let petFriendlyDptos = [];
      for (let i = 0; i < this.departamentos.length; i++) {
        if (this.departamentos[i].aceptaMascotas) {
          petFriendlyDptos.push(this.departamentos[i]);
        }
      }
      return petFriendlyDptos;
    },
    // C
    rebajasPorNoAlquiler: function () {
      let disponibles = this.departamentosDisponibles();
      const descuento = 0.9;
      let rebajados = [];
      for (let i = 0; i < disponibles.length; i++) {
        rebajados.push((disponibles[i].precioAlquiler *= descuento));
      }
      return rebajados;
    },
    // D
    buscarPorPropietarios: function (propietarios) {
      let filtrados = [];
      for (let i = 0; i < this.departamentos.length; i++) {
        if (this.departamentos[i].propietarios.indexOf(propietarios) != -1) {
          filtrados.push(this.departamentos[i]);
        }
      }
      return filtrados;
    },
  };
  
  module.exports = inmobiliaria;