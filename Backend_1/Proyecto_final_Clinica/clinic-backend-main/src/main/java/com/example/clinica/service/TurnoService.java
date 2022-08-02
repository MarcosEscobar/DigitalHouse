package com.example.clinica.service;

import com.example.clinica.entities.Turno;
import com.example.clinica.entities.TurnoDTO;
import com.example.clinica.repository.TurnosRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService {
    private final TurnosRepository turnosRepository;
    private static Logger logger = Logger.getLogger(Main.class);
    public TurnoService(TurnosRepository turnosRepository) {
        this.turnosRepository = turnosRepository;
    }

    @Autowired
    ObjectMapper mapper;

    public TurnoDTO crearTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnosRepository.save(turno);
        logger.info("Se creó el registro "+ turnoDTO);
        return turnoDTO;
    }

    public TurnoDTO modificarTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnosRepository.save(turno);
        logger.info("Se modificó el registro "+ turnoDTO);
        return turnoDTO;
    }

    public void eliminarTurnoPorId(Long id) {
        turnosRepository.deleteById(id);
        logger.info("Se eliminó el registro ID: "+ id);
    }

    public TurnoDTO encontrarTurno(Long id) {
        Optional<Turno> turno = turnosRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turno.isPresent()) {
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        }
        logger.info("Se encontró el registro "+ turnoDTO);
        return turnoDTO;
    }

    public Set<TurnoDTO> listarTurnos() {
        List<Turno> turnos = turnosRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();

        for (Turno turno : turnos) {
            turnosDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }

        logger.debug("Se listaron los registros con éxito");

        return turnosDTO;
    }


}
