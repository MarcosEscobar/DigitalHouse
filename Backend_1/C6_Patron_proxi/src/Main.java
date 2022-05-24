public class Main {
    public static void main(String[] args) {
        //Se crean dos usuarios de prueba.
        usuario u1=new usuario("Free", 1);
        usuario u2=new usuario("Premium",2);

        proxyDescarga proxy=new proxyDescarga();

        proxy.descargar(u1, "Miranda - Mentía");
        proxy.descargar(u2, "Piñon Fijo - Chuchuwa");
    }
}
