package com.example.clinica.service;

import com.example.clinica.entities.Paciente;
import com.example.clinica.entities.PacienteDTO;
import com.example.clinica.repository.PacienteRepository;
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
public class PacienteService {
    private final PacienteRepository pacienteRepository;
    private static Logger logger = Logger.getLogger(Main.class);
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Autowired
    ObjectMapper mapper;

    public PacienteDTO crearPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
        return pacienteDTO;
    }

    public PacienteDTO modificarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
        return pacienteDTO;
    }

    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
        logger.info("Se eliminó el registro ID: "+ id);
    }

    public PacienteDTO buscarPacientesPorId(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent()) {
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }
        return pacienteDTO;
    }

    public Set<PacienteDTO> listarPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacienteDTOS = new HashSet<>();

        for(Paciente paciente : pacientes) {
            pacienteDTOS.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        logger.debug("Se listaron los registros con éxito");
        return pacienteDTOS;
    }


}
