import dao.imp.avionDAOH2;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import model.avion;
import svc.avionService;

public class main {
    public static void main(String[] args) throws Exception {

        avionDAOH2 AVDAOH2=new avionDAOH2();

        avionService AVService=new avionService(AVDAOH2);

        AVService.registrarAvion(new avion("marcaMain","modeloMain", "matriculaMain", LocalDate.of(2022,05,30), 3));

        List<avion> todos=AVService.buscarTodos();

        System.out.println("Listado de aviones en DB");
        for (avion a: todos) {
            System.out.println(a.toString());
        }

        System.out.println("-----------------------------");
        System.out.println(AVService.buscarPorId(1).toString());
        System.out.println("-----------------------------");
        AVService.eliminarPorId(1);
        System.out.println("-----------------------------");
        todos=AVService.buscarTodos();

        System.out.println("Listado de aviones en DB");
        for (avion a: todos) {
            System.out.println(a.toString());
        }

    }
}
