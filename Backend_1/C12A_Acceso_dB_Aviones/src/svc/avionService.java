package svc;

import dao.IDAO;
import model.avion;

import java.util.List;

public class avionService {
    private IDAO<avion> avionDAO;

    public avionService(IDAO<avion> avionDAO){
        this.avionDAO=avionDAO;
    }

    public List<avion> buscarTodos(){
        return avionDAO.buscarTodos();
    }
    public void registrarAvion(avion avion){
        avionDAO.registrarAvion(avion);
    }

    public avion buscarPorId(int id){
        return avionDAO.buscarPorId(id);
    }

    public void eliminarPorId(int id){
        avionDAO.eliminarPorId(id);
    }
}
