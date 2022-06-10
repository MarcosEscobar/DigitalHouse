package com.empresa;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String cuit;
    private String razonSocial;
    private List<Empleado> empleados;

    public Empresa(String cuit, String razonSocial) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.empleados = new ArrayList<>();
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void agregarEmpleado(Empleado e) {
        this.empleados.add(e);
    }

    public void eliminarEmpleado(Empleado e) {
        this.empleados.remove(e);
    }
}
