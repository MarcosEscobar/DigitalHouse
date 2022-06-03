package com.dh.service;

import com.dh.dao.ConfiguracionJDBC;
import com.dh.dao.IDao;
import com.dh.dao.impl.DomicilioDaoH2;
import com.dh.dao.impl.PacienteDaoH2;
import com.dh.model.entidades.Domicilio;
import com.dh.model.entidades.Paciente;
import org.apache.log4j.Logger;

import java.sql.Date;

public class ClinicaOdontologica {

    private static final Logger logger = Logger.getLogger(ClinicaOdontologica.class);
    private final IDao<Paciente> pacienteDaoH2;
    private final IDao<Domicilio> domicilioDaoH2 ;

    public ClinicaOdontologica() throws Exception {
        pacienteDaoH2 = new PacienteDaoH2(new ConfiguracionJDBC());
        domicilioDaoH2 = new DomicilioDaoH2(new ConfiguracionJDBC());
    }

    public ClinicaOdontologica(ConfiguracionJDBC configuracionJDBC) throws Exception {
        this.pacienteDaoH2 = new PacienteDaoH2(configuracionJDBC);
        this.domicilioDaoH2 = new DomicilioDaoH2(configuracionJDBC);
    }

    public String buscarPaciente(Integer id) {
        String respuesta = "Paciente con ID: " + id + " no encontrado";
        try {
            Paciente paciente = pacienteDaoH2.consultarPorId(id);
            if (paciente != null) {
                Domicilio domicilio = domicilioDaoH2.consultarPorId(paciente.getDomicilio().getDomicilioID());
                paciente.setDomicilio(domicilio);
                respuesta = "El paciente con ID: " + id + " es " + paciente;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    public String darDeAltaPaciente(String nombre, String apellido, Integer dni, Date fecha, Integer domicilioID) {
        String respuesta = "No se pudo dar de alta el paciente";
        Paciente paciente = new Paciente(nombre, apellido, dni, fecha, new Domicilio(domicilioID));
        try {
            if (domicilioDaoH2.consultarPorId(domicilioID) != null) {
                pacienteDaoH2.insertarNuevo(paciente);
                respuesta = "El paciente " + paciente + " fue dado de alta con éxito";
            } else {
                respuesta += ", el domicilio no es válido.";
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    public String darDeAltaPaciente(String nombre, String apellido, Integer dni, Date fecha, String calle, Integer numero, String localidad, String provincia) {
        String respuesta = "No se pudo dar de alta el paciente";
        Domicilio domicilio = new Domicilio(calle, numero, localidad, provincia);
        try {
            Integer domicilioID = domicilioDaoH2.insertarNuevo(domicilio).getDomicilioID();
            domicilio.setDomicilioID(domicilioID);
            Paciente paciente = new Paciente(nombre, apellido, dni, fecha, domicilio);
            pacienteDaoH2.insertarNuevo(paciente);
            respuesta = "El paciente " + paciente + " fue dado de alta con éxito";
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    public String darDeBajaPaciente(Integer pacienteID) {
        String respuesta = "No se pudo dar de baja el paciente";
        try {
            Boolean seBorro = pacienteDaoH2.borrarPorId(pacienteID);
            if (seBorro) {
                respuesta = "El paciente con ID: " + pacienteID + " se borró con éxito";
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    public String actualizarPaciente(Integer pacienteID, String nombre, String apellido, Integer dni, Date fecha, Integer domicilioID) {
        String respuesta = "Paciente con ID: " + pacienteID + " no encontrado";
        try {
            Paciente paciente = pacienteDaoH2.consultarPorId(pacienteID);
            paciente.setNombre(nombre);
            paciente.setApellido(apellido);
            paciente.setDni(dni);
            paciente.setFechaIngreso(fecha);
            Domicilio domicilio = domicilioDaoH2.consultarPorId(domicilioID);
            paciente.setDomicilio(domicilio);
            if (paciente.getNombre() != null && paciente.getApellido() != null && paciente.getDni() != null && paciente.getFechaIngreso() != null) {
                respuesta = "Los nuevos datos son:\n" + paciente;
                pacienteDaoH2.actualizar(paciente);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }
}
