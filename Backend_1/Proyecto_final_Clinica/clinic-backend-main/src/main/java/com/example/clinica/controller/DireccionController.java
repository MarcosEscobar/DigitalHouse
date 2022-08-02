package com.example.clinica.controller;

import com.example.clinica.entities.*;
import com.example.clinica.service.TurnoService;
import com.example.clinica.service.OdontologoService;
import com.example.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/turnos")
public class DireccionController {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<TurnoDTO> crearTurno(@RequestBody TurnoDTO turnoDTO) {
        ResponseEntity<TurnoDTO> response;
        PacienteDTO pacienteDTO = pacienteService.buscarPacientesPorId(turnoDTO.getPaciente().getId());
        OdontologoDTO odontologoDTO = odontologoService.buscarOdontologoPorId(turnoDTO.getOdontologo().getId());

        //Controlamos que existan el paciente y el domicilio antes de agregar el turno.
        if (pacienteDTO !=null&& odontologoDTO !=null) {
            response = ResponseEntity.ok(turnoService.crearTurno(turnoDTO));

        }
        else {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<?> modificarTurno(@RequestBody TurnoDTO turnoDTO) {
        turnoService.modificarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> encontrarTurnoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(turnoService.encontrarTurno(id));
    }

    @GetMapping
    public ResponseEntity<Set<TurnoDTO>> listarTurnos() {
        return ResponseEntity.ok(turnoService.listarTurnos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurnoPorId(@PathVariable Long id) {
        turnoService.eliminarTurnoPorId(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
