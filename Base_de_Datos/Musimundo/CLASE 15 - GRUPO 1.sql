# GRUPO 1
# Diana Cruz
# Geraldine Claros Rios 
# Lucia Ferreti
# Sabrina Giuliana Incinga 
# Sorany Pulgarin Villa
# Marcos Escobar

use musimundos; 
# 1. Listar las canciones cuya duración sea mayor a 2 minutos.
select nombre, milisegundos from canciones where milisegundos > 12000;
# 2. Listar las canciones cuyo nombre comience con una vocal
select nombre from canciones where nombre like 'a%' or 'i%' or 'u%' or 'e%' or 'o%' order by nombre;
# 3. Listar las canciones ordenadas por compositor en forma descendente.Luego, por nombre en forma ascendente. Incluir únicamente aquellas canciones que tengan compositor
select compositor, nombre from canciones group by compositor having compositor is not null order by compositor desc, nombre asc; 
# 4.  A. Listar la cantidad de canciones de cada compositor.
select compositor, count(id) from canciones group by compositor;
# 4.  B.  Modificar el listado del punto (a) mostrando únicamente las ciudades de Canadá.
select compositor, count(id) from canciones group by compositor having count(id) > 10;
# 5.  A. Listar el total facturado agrupado por ciudad.
select ciudad_de_facturacion, sum(total) from facturas group by ciudad_de_facturacion order by sum(total) desc;
# 5.  B. Modificar el listado del punto (a) mostrando únicamente las ciudades de Canadá.
select pais_de_facturacion, ciudad_de_facturacion, sum(total) from facturas group by ciudad_de_facturacion having pais_de_facturacion = 'Canada' order by sum(total) desc;
# 5.  C. Modificar el listado del punto (a) mostrando únicamente las ciudades con una facturación mayor a 38.
select ciudad_de_facturacion, sum(total) from facturas group by ciudad_de_facturacion  having sum(total) > 38 order by sum(total) desc;
# 5.  D. Modificar el listado del punto (a) agrupando la facturación por país, y luego por ciudad.
select pais_de_facturacion, ciudad_de_facturacion, sum(total) from facturas group by pais_de_facturacion, ciudad_de_facturacion order by pais_de_facturacion, sum(total) desc;
# 6. A. Listar la duración mínima, máxima y promedio de las canciones.
select min(milisegundos), max(milisegundos), AVG(milisegundos) from canciones;
#6. B. Modificar el punto (a) mostrando la información agrupada por género.
select generos.nombre, min(milisegundos), max(milisegundos), avg(milisegundos) from canciones inner join generos on generos.id = canciones.id_genero group by id_genero;