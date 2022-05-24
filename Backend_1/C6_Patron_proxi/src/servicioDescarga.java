public class servicioDescarga implements cancion {
    @Override
    public void descargar(usuario u, String cancion) {
        System.out.println("Usuario ID: "+u.getId()+" descargando canción "+cancion);
    }
}
