import drive.DocumentoConcreto;
import drive.DocumentoProxy;
import drive.Drive;

public class Main {
    public static void main(String[] args) {
        Drive drive = new Drive();
        DocumentoConcreto documento = new DocumentoConcreto("www.documento.com", 441, "Soy un documento");
        DocumentoProxy proxy = new DocumentoProxy(documento.getUrl(), documento);

        proxy.agregarUsuarioAutorizado("yo@yo.com");
        proxy.agregarUsuarioAutorizado("vos@vos.com");
        drive.subir(proxy);

        drive.abrir("www.documento.com", "yo@yo.com");
        drive.abrir("www.documento.com", "vos@vos.com");
        drive.abrir("www.documento.com", "yo@yo.com");
        drive.abrir("documento", "yo@yo.com");
        drive.abrir("www.documento.com", "i0@i0.com");
        drive.abrir("www.documento.com", "voz@voz.com");

        drive.mostrarAccesosDocumento("www.documento.com");
    }
}
