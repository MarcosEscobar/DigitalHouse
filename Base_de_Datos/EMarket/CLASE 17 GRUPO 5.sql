-- Marcos Javier Escobar Martin 
-- Sorany Pulgarin Villa 
-- Agostina Finucci 
-- Cristhian Cely 
-- Helvio Koberstein 
-- Joseph Rafael Jimenez Mendoza 
USE emarket;
-- PARTE 1 - CLIENTES
-- PUNTO 1
CREATE VIEW vw_clientes AS
SELECT  ClienteID
       ,Contacto
       ,CASE WHEN Fax IS NULL OR Fax = '' THEN CONCAT('TEL: ',Telefono)  ELSE CONCAT('FAX: ',Fax) END Fax
FROM Clientes;
-- PUNTO 1 - A CONSULTA CON LA TABLA DIRECTA
SELECT  Contacto
       ,Telefono
FROM clientes
WHERE Fax IS NULL or Fax = ''; 
-- PUNTO 1 - B CONSULTA CON LA VISTA
SELECT  Contacto
       ,Fax
FROM vw_clientes
WHERE Fax LIKE 'TEL%';
-- PARTE 2 - PROVEEDORES
-- PUNTO 1
CREATE VIEW vw_proveedores AS
SELECT  ProveedorID
       ,Contacto
       ,Compania
       ,Direccion
FROM proveedores;
-- PUNTO 1 - A
SELECT  Compania
       ,Direccion
FROM proveedores
WHERE Direccion LIKE '%Americanas%';
-- PUNTO 1 - B
SELECT  *
FROM vw_proveedores
WHERE Direccion LIKE '%Americanas%';
-- PARTE 3
-- PUNTO 1
CREATE view vw_productos AS
SELECT  ProductoID
       ,ProductoNombre
       ,ROUND(PrecioUnitario)                                                   AS PrecioUnitario
       ,UnidadesStock
       ,UnidadesPedidas
       ,CASE WHEN UnidadesPedidas = 0 THEN 'BAJA'
             WHEN UnidadesPedidas < UnidadesStock THEN 'MEDIA'
             WHEN UnidadesPedidas < UnidadesStock * 2 THEN 'URGENTE'
             WHEN UnidadesPedidas >= UnidadesStock * 2 THEN 'SUPER URGENTE' END AS Prioridad
FROM Productos;
-- PUNTO 2 
SELECT  Prioridad
       ,COUNT(ProductoID)            AS CantidadProductos
       ,ROUND(AVG(PrecioUnitario),2) AS PrecioPromedio
FROM vw_productos
GROUP BY  Prioridad
HAVING CantidadProductos > 5;