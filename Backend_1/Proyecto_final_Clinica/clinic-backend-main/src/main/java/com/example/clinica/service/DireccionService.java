package com.example.clinica.service;

import com.example.clinica.entities.Direccion;
import com.example.clinica.entities.DireccionDTO;
import com.example.clinica.repository.DireccionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class DireccionService {
    private final DireccionRepository direccionRepository;
    private static Logger logger = Logger.getLogger(Main.class);
    public DireccionService(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

    @Autowired
    ObjectMapper mapper;

    public DireccionDTO crearDireccion(DireccionDTO direccionDTO) {
        Direccion direccion = mapper.convertValue(direccionDTO, Direccion.class);
        direccionRepository.save(direccion);
        logger.info("Se creó el registro "+ direccion);
        return direccionDTO;
    }

    public void eliminarDireccion(Long id) {
        direccionRepository.deleteById(id);
    }

    public DireccionDTO modificarDireccion(DireccionDTO direccionDTO) {
        Direccion direccion = mapper.convertValue(direccionDTO, Direccion.class);
        direccionRepository.save(direccion);
        logger.info("Se modificó el registro "+ direccion);
        return direccionDTO;
    }

    public DireccionDTO buscarDireccion(Long id) {
        Optional<Direccion> direccion = direccionRepository.findById(id);
        DireccionDTO direccionDTO = null;
        if (direccion.isPresent()){
            direccionDTO = mapper.convertValue(direccion, DireccionDTO.class);
        }
        logger.info("Se encontró el registro "+ direccion);
        return direccionDTO;
    }

    public Set<DireccionDTO> listarDirecciones() {
        List<Direccion> listaDirecciones = direccionRepository.findAll();
        Set<DireccionDTO> direccionDTOList = new HashSet<>();

        for (Direccion direccion : listaDirecciones) {
            direccionDTOList.add(mapper.convertValue(direccion, DireccionDTO.class));
        }

        return direccionDTOList;
    }


}
