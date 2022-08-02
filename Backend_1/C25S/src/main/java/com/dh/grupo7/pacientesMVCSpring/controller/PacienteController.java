package com.dh.grupo7.pacientesMVCSpring.controller;

import com.dh.grupo7.pacientesMVCSpring.DAO.imp.TurnoDAOH2;
import com.dh.grupo7.pacientesMVCSpring.domain.Odontologo;
import com.dh.grupo7.pacientesMVCSpring.domain.Paciente;
import com.dh.grupo7.pacientesMVCSpring.DAO.imp.OdontologoDAOH2;
import com.dh.grupo7.pacientesMVCSpring.domain.Turno;
import com.dh.grupo7.pacientesMVCSpring.service.OdontologoService;
import com.dh.grupo7.pacientesMVCSpring.DAO.imp.PacienteDAOH2;
import com.dh.grupo7.pacientesMVCSpring.service.PacienteService;
import com.dh.grupo7.pacientesMVCSpring.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

@Controller
public class PacienteController {
    @Autowired
    static PacienteDAOH2 PDaoH2=new PacienteDAOH2();
    static PacienteService pacienteService=new PacienteService(PDaoH2);
    static OdontologoDAOH2 ODaoH2=new OdontologoDAOH2();
    static OdontologoService odontologoService=new OdontologoService(ODaoH2);
    static TurnoDAOH2 turnoDAOH2=new TurnoDAOH2();
    static TurnoService turnoService=new TurnoService(turnoDAOH2);


    @GetMapping("/")
    public String devolverIndex(){
        return "index";
    }

    @GetMapping(path = "/pacientes")
    public String devolverPacientesAll(Model model) throws SQLException {
        List<Paciente> pacientes=pacienteService.buscarTodos();
        model.addAttribute("pacientes", pacientes);
        return "pacientesAll";
    }

    @GetMapping("/odontologosAll")
    public String devolverOdontologosAll(Model model) throws SQLException {
        List<Odontologo> odontologos=odontologoService.buscarTodos();
        model.addAttribute("odontologos", odontologos);
        return "odontologosAll";
    }

    /*@GetMapping("/pacientePorID")
    public String getPacienteByID(@RequestParam(name = "id", required = true, defaultValue = "0")  int id, Model model) throws SQLException {

        Paciente paciente=pacienteService.buscarPorId((long)id);
        Odontologo odontologo=null;

        if (paciente != null) {
            odontologo = odontologoService.buscarPorId(paciente.getId_odontologo());
        }

        if (paciente==null){
            return "error";
        }else if (odontologo!=null){
            model.addAttribute("nombre_paciente", paciente.getNombre());
            model.addAttribute("apellido_paciente", paciente.getApellido());
            model.addAttribute("dni", paciente.getDNI());
            model.addAttribute("fecha", paciente.getFechaIngreso());
            model.addAttribute("calle", paciente.getDomicilio().getCalle());
            model.addAttribute("nro", paciente.getDomicilio().getNumero());
            model.addAttribute("localidad", paciente.getDomicilio().getLocalidad());
            model.addAttribute("provincia", paciente.getDomicilio().getProvincia());
            model.addAttribute("nombre_odontologo", odontologo.getNombre());
            model.addAttribute("apellido_odontologo", odontologo.getApellido());
            model.addAttribute("matricula_odontologo", odontologo.getMatricula());
            return "idConOdontologo";
        }else{
            model.addAttribute("nombre_paciente", paciente.getNombre());
            model.addAttribute("apellido_paciente", paciente.getApellido());
            model.addAttribute("dni", paciente.getDNI());
            model.addAttribute("fecha", paciente.getFechaIngreso());
            model.addAttribute("calle", paciente.getDomicilio().getCalle());
            model.addAttribute("nro", paciente.getDomicilio().getNumero());
            model.addAttribute("localidad", paciente.getDomicilio().getLocalidad());
            model.addAttribute("provincia", paciente.getDomicilio().getProvincia());
            return "idSinOdontologo";
        }

    }*/

    @GetMapping(path = "/pacientes/{id}")
    public String pacientePorID(@PathVariable("id") int id, Model model) throws SQLException {
        Paciente paciente=pacienteService.buscarPorId((long)id);
        Odontologo odontologo=null;

        if (paciente == null) {
            return "error";

        }else{
            odontologo = odontologoService.buscarPorId(paciente.getId_odontologo());
        }

        if (odontologo!=null){
            model.addAttribute("nombre_paciente", paciente.getNombre());
            model.addAttribute("apellido_paciente", paciente.getApellido());
            model.addAttribute("dni", paciente.getDNI());
            model.addAttribute("fecha", paciente.getFechaIngreso());
            model.addAttribute("calle", paciente.getDomicilio().getCalle());
            model.addAttribute("nro", paciente.getDomicilio().getNumero());
            model.addAttribute("localidad", paciente.getDomicilio().getLocalidad());
            model.addAttribute("provincia", paciente.getDomicilio().getProvincia());
            model.addAttribute("nombre_odontologo", odontologo.getNombre());
            model.addAttribute("apellido_odontologo", odontologo.getApellido());
            model.addAttribute("matricula_odontologo", odontologo.getMatricula());
            return "idConOdontologo";
        }else{
            model.addAttribute("nombre_paciente", paciente.getNombre());
            model.addAttribute("apellido_paciente", paciente.getApellido());
            model.addAttribute("dni", paciente.getDNI());
            model.addAttribute("fecha", paciente.getFechaIngreso());
            model.addAttribute("calle", paciente.getDomicilio().getCalle());
            model.addAttribute("nro", paciente.getDomicilio().getNumero());
            model.addAttribute("localidad", paciente.getDomicilio().getLocalidad());
            model.addAttribute("provincia", paciente.getDomicilio().getProvincia());
            return "idSinOdontologo";
        }
    }

    @DeleteMapping(path = "/pacientes/{id}")
    public String eliminarPacientePorID(@PathVariable("id") int id, Model model) throws SQLException {
        pacienteService.eliminar((long)id);
        model.addAttribute("idPaciente", id);
        return "pacienteEliminado";
    }

    @GetMapping("/odontologoPorID")
    public String getOdontologoByID(@RequestParam(name = "id", required = true, defaultValue = "0")  int id, Model model) throws SQLException {

        Odontologo odontologo=odontologoService.buscarPorId((long)id);

        if (odontologo==null){
            return "error";
        }else {
            model.addAttribute("nombre_odontologo", odontologo.getNombre());
            model.addAttribute("apellido_odontologo", odontologo.getApellido());
            model.addAttribute("matricula_odontologo", odontologo.getMatricula());
            model.addAttribute("id_odontologo", odontologo.getId());
            return "odontologo";
        }

    }

    @GetMapping(path = "/turnos/{id}")
    public String buscarTurnoPorID(@PathVariable("id") int id, Model model) throws SQLException {
        Turno t=turnoService.buscarPorId((long)id);
        model.addAttribute("id_turno", t.getId());
        model.addAttribute("id_paciente", t.getId_paciente());
        model.addAttribute("id_odontologo", t.getId_odontologo());

        return "turno";
    }

}
