# GRUPO 9
# marcos javier escobar martin
# sorany pulgarin villa
# sabrina giuliana incinga
# cristhian cely
# john harold herrera
#####################################################
USE proyecto_spotify;
select * from cancion where titulo like '%z%';
select * from cancion where titulo like '%_a%s';
select idPlaylist as 'Id Playlist', idusuario as 'id Usuario', titulo as 'Titulo', cantcanciones as 'Cantidad de Canciones', idestado as 'ID Estado', Fechacreacion as 'Fecha de Creación', Fechaeliminada as 'Fecha Eliminada'  from playlist order by cantcanciones desc limit 1;
select nombreusuario as 'Usuario' from usuario order by fecha_nac asc limit 10 offset 5;
select titulo, cantreproduccion as 'Cantidad de reproducciones' from cancion order by cantreproduccion desc limit 5;
select * from album order by titulo;
select * from album where imagenportada is null or imagenportada = '' order by titulo;
INSERT INTO usuario (`idUsuario`,`nombreusuario`,`nyap`,`fecha_nac`,`sexo`,`CP`,`password`,`Pais_idPais`,`IdTipoUsuario`)
VALUES (20,'nuevousuariodespotify@gmail.com','Elmer Gomez',15/11/1991,'m','B4129ATF','S4321m',2, 3);
#select * from cancion join generoxcancion join genero on (cancion.idCancion = generoxcancion.IdCancion and genero.idGenero = generoxcancion.IdGenero) where genero.Genero = 'POP';
#select * from playlistxcancion join cancion join generoxcancion join genero on (playlistxcancion.Idcancion = cancion.idCancion and cancion.idCancion = generoxcancion.IdCancion and genero.idGenero = generoxcancion.IdGenero) where genero.Genero = 'POP';
delete generoxcancion from generoxcancion join genero on generoxcancion.idGenero = genero.idGenero where genero.genero = 'POP';
update artista set imagen = 'Imagen faltante' where (imagen is null or imagen = '');