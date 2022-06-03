# Patrón cadena de responsabilidad
## Objetivo
Realizar el diagrama UML y programar en Java implementando patrón cadena de responsabilidad según el siguiente enunciado.

A tener en cuenta:

Ejercicio individual

Nivel de complejidad: intermedio 🔥🔥

## Enunciado
En una empresa se desea controlar la calidad de un producto. Se pasa por tres controles diferentes y en cada uno se verifica si cumple con los estándares de calidad. Según los controles:

Lote: debe estar entre 1000 y 2000.
Peso: debe estar entre 1200 y 1300.
Envase: debe ser igual a “sano” o “casi sano”. 

En caso de que no cumpla con algún criterio debe informarse que fue rechazado. Si cumple con todos los requisitos, debe informarse que fue aceptado.

El artículo pertenece a una clase artículo que tiene cuatro datos:

Nombre: string.
Lote: int.
Peso: int.
Envasado: string (“sano”, “casi sano”, etc.).

Se desea que una clase AnalistaDeCalidad vaya enviando el artículo a cada uno de los controles. Primero el de lote, si este es correcto, pasará al de control de peso. Si no es correcto, informa que está mal el lote. La secuencia de cada control continúa hasta que, al pasar todos los controles, debe informar que está correcto.

Por último, se debe hacer una clase que cree un artículo y le pida a CompruebaCalidad que lo verifique.

Realizar los casos de prueba necesarios para garantizar la calidad del método validarCalidadDelProducto()

¡Muchos éxitos!
