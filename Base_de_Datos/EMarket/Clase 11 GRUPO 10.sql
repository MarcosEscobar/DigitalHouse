USE emarket;
/*CATEGORÍAS Y PRODUCTOS*/
/*PUNTO 1*/
SELECT * FROM categorias;
/*PUNTO 2*/
SELECT CategoriaNombre, Descripcion FROM categorias;
/*PUNTO 3*/
SELECT * FROM productos;
/*PUNTO 4*/
SELECT * FROM productos WHERE Discontinuado = 1;
/*PUNTO 5*/
SELECT * FROM productos WHERE ProveedorID = 8;
/*PUNTO 6*/
SELECT * FROM productos WHERE PrecioUnitario BETWEEN 10 AND 22;
/*PUNTO 7*/
SELECT * FROM productos WHERE UnidadesStock < NivelReorden;
/*PUNTO 8*/
SELECT * FROM productos WHERE UnidadesStock < NivelReorden AND UnidadesPedidas = 0;

/*CLIENTES*/
/*PUNTO 1*/
SELECT Contacto, Compania, Titulo, Pais FROM clientes order by Pais;
/*PUNTO 2*/
SELECT Contacto, Compania, Titulo, Pais FROM clientes WHERE Titulo = "owner" order by Pais ;
/*PUNTO 3*/
SELECT Contacto, Compania, Titulo, Pais FROM clientes WHERE Contacto LIKE 'c%';

/*FACTURAS*/
/*PUNTO 1*/
SELECT * FROM facturas ORDER BY FechaFactura asc;
/*PUNTO 2*/
SELECT * FROM facturas WHERE PaisEnvio = "USA" AND EnvioVia != 3 ORDER BY FechaFactura asc;
/*PUNTO 3*/
SELECT * FROM facturas WHERE ClienteID = "GOURL" ORDER BY FechaFactura asc;
/*PUNTO 4*/
SELECT * FROM facturas WHERE EmpleadoID IN (2, 3, 5, 8, 9) ORDER BY EmpleadoID asc;

/*CONSULTAS QUERIES ML PARTE II*/
/*PUNTO 1*/
SELECT * FROM productos ORDER BY PrecioUnitario DESC;
/*PUNTO 2*/
SELECT * FROM productos ORDER BY PrecioUnitario DESC limit 5;
/*PUNTO 3*/
SELECT * FROM productos ORDER BY UnidadesStock DESC limit 10;

/*FACTURA DETALLE*/
/*PUNTO 1*/
SELECT FacturaID, Producto, Cantidad FROM facturadetalle;
/*PUNTO 2*/
SELECT FacturaID, Producto, Cantidad FROM facturadetalle ORDER BY Cantidad desc;
/*PUNTO 3*/
SELECT FacturaID, Producto, Cantidad FROM facturadetalle WHERE Cantidad BETWEEN 50 AND 100 ORDER BY Cantidad desc;
/*PUNTO 4*/
SELECT FacturaID as NroFactura, ProductoID as Producto, (PrecioUnitario * Cantidad) as Total FROM FacturaDetalle;

/*EXTRAS*/
/*PUNTO 1*/
SELECT * FROM Clientes WHERE Pais IN ('Brazil' , 'Mexico') OR Titulo Like 'Sales%';
/*PUNTO 2*/
SELECT * FROM Clientes WHERE Compania LIKE 'A%';
/*PUNTO 3*/
SELECT Ciudad, Contacto as 'Apellido y Nombre', titulo as Puesto FROM Clientes WHERE Ciudad = 'Madrid';
/*PUNTO 4*/
SELECT * FROM Facturas WHERE FacturaID BETWEEN 10000 AND 10500;
/*PUNTO 5*/
SELECT * FROM Facturas WHERE FacturaID BETWEEN 10000 AND 10500 OR ClienteID LIKE 'B%';
/*PUNTO 6*/
SELECT * FROM Facturas WHERE CiudadEnvio = 'Vancouver' OR EnvioVia = 3;
/*PUNTO 7*/
SELECT EmpleadoID FROM empleados WHERE Nombre = "Buchanan" OR Apellido = "Buchanan";
/*PUNTO 8*/
SELECT * FROM Facturas WHERE EmpleadoID = 5;