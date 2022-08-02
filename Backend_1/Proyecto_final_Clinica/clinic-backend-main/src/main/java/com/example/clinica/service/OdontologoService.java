package com.example.clinica.service;

import com.example.clinica.entities.Odontologo;
import com.example.clinica.entities.OdontologoDTO;
import com.example.clinica.repository.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService {
    private final OdontologoRepository odontologoRepository;
    private static Logger logger = Logger.getLogger(Main.class);
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Autowired
    ObjectMapper mapper;

    public OdontologoDTO crearOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
        return odontologoDTO;
    }

    public OdontologoDTO modificarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
        return odontologoDTO;
    }

    public void eliminarOdontologoPorId(Long id) {
        odontologoRepository.deleteById(id);
        logger.info("Se eliminó el registro ID: "+ id);
    }

    public OdontologoDTO buscarOdontologoPorId(Long id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent()) {
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    public Set<OdontologoDTO> listarOdontologos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();

        for (Odontologo odontologo : odontologos) {
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        logger.debug("Se listaron los registros con éxito" + Arrays.toString(odontologosDTO.toArray()));
        return odontologosDTO;
    }

}
