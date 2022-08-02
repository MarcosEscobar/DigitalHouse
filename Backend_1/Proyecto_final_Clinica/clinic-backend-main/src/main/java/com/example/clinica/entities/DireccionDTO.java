package com.example.clinica.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DireccionDTO {
    private Long id;
    private String calle;
    private String numero;
    private String provincia;
    private String ciudad;

    public DireccionDTO() {

    }

    public DireccionDTO(String calle, String numero, String provincia, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.provincia = provincia;
        this.ciudad = ciudad;
    }

    public Long getId() {
        return id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
