public class proxyDescarga implements cancion {
    servicioDescarga sD=new servicioDescarga();

    @Override
    public void descargar(usuario u, String cancion) {
        if (u.getTipo()=="Premium"){
            sD.descargar(u, cancion);
        }else{
            System.out.println("Usted es pobre y no puede descargar canciones!");
        }
    }
}
