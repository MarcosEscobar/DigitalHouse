USE dhtube;
/*Generar un reporte que indique la cantidad de usuarios por país,
mostrando el nombre del país y su cantidad.*/
SELECT p.nombre, COUNT(idUsuario) as 'Cantidad de Usuarios'
FROM usuario u 
RIGHT JOIN pais p 
ON u.Pais_idPais = p.idPais 
GROUP BY p.nombre 
ORDER BY COUNT(idUsuario) desc;
/*
2. Mostrar el Top 5 de avatars utilizados por los usuarios, listando el
nombre del avatar y la cantidad de veces utilizado.
*/
SELECT a.idAvatar, a.nombre, COUNT(u.Avatar_idAvatar) as 'Cantidad de usuarios'
FROM usuario u
INNER JOIN avatar a
ON u.Avatar_idAvatar = a.idAvatar
GROUP BY a.nombre
ORDER BY COUNT(u.Avatar_idAvatar) desc
limit 5;
/*
Emitir un listado de todas las playlists públicas, informando el nombre
del usuario que la creó, el título de cada video que posee y el nombre
y  año de creación de la playlist.
*/
SELECT p.nombre as 'Nombre de Playlist', u.nombre as 'Usuario', v.titulo as 'Título de Canción', p.fechaCreacion as 'Fecha de Creación'
FROM playlist_video pv 
INNER JOIN playlist p ON pv.Playlist_idPlaylist = p.idPlaylist
INNER JOIN video v ON pv.Video_idVideo = v.idVideo
INNER JOIN usuario u ON p.Usuario_idUsuario = u.idUsuario
WHERE p.privado =0
ORDER BY u.nombre;
/*
 Listar las 10 etiquetas menos usadas.
*/
SELECT e.nombre as 'Etiqueta', COUNT(ve.Video_idVideo) as 'Cantidad'
FROM video_etiqueta ve
INNER JOIN etiqueta e ON e.idEtiqueta = ve.Etiqueta_idEtiqueta
INNER JOIN video v ON v.idVideo = ve.Video_idVideo
GROUP BY e.nombre
ORDER BY COUNT(ve.Video_idVideo) desc limit 10;
/*
5. Generar un reporte de las últimas 10 reacciones, listando la fecha, el
nombre de la reacción, el id y nombre de usuario, y el título del video.
*/
SELECT r.fecha as 'Fecha de emisión', t.nombre as 'Tipo de reacción', r.idReaccion as 'ID de Reacción', u.nombre as 'Nombre de Usuario', v.Titulo as 'Titulo del video'
FROM reaccion r
INNER JOIN tiporeaccion t ON r.TipoReaccion_idTipoReaccion = t.idTipoReaccion
INNER JOIN usuario u ON r.Usuario_idUsuario = u.idUsuario
INNER JOIN video v ON r.Video_idVideo = v.idVideo
ORDER BY r.fecha desc
limit 10;
/*
Mostrar por usuario la cantidad de playlists que posee, pero solo para
aquellos que tengan más de 1 playlist  creada en el año 2021.
*/
SELECT u.nombre as 'Nombre de Usuario', COUNT(p.Usuario_idUsuario) as 'Cantidad de playlists'
FROM playlist p
INNER JOIN usuario u ON p.Usuario_idUsuario = u.idUsuario
WHERE YEAR(p.fechaCreacion) = '2021'
GROUP BY u.nombre
HAVING COUNT(p.Usuario_idUsuario)>1;
/*
*/
/*
*/
/*
*/
/*
*/
/*
*/
/*
*/
/*
*/
/*
*/
/*
*/
/*
*/
/*
*/
/*
*/
/*
*/
/*
*/
