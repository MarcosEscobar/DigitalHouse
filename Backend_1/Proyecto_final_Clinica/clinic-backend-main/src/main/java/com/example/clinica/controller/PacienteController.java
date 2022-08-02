package com.example.clinica.controller;

import com.example.clinica.entities.PacienteDTO;
import com.example.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDTO pacienteDTO) {
        pacienteDTO.setFechaDeRegistro(LocalDate.now());
        pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok((HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscarPacientesPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.buscarPacientesPorId(id));
    }

    @GetMapping
    public Set<PacienteDTO> listarPacientes() {
        return pacienteService.listarPacientes();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
