package com.edad.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class edadController {

    @GetMapping(path = "/{anio}/{mes}/{dia}")
    public String devolverEdad(@PathVariable("anio") int anio, @PathVariable("mes") int mes,  @PathVariable("dia") int dia){
        LocalDate fechaIngresada=LocalDate.of(anio, mes, dia);
        return "La persona tiene "+ String.valueOf(Period.between(fechaIngresada, LocalDate.now()).getYears())+ " años";
    }
}
