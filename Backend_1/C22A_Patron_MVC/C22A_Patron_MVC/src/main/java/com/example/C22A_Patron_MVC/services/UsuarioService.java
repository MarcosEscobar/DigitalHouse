package com.example.C22A_Patron_MVC.services;

import com.example.C22A_Patron_MVC.dominio.Usuario;

public class UsuarioService {
    public Usuario crearUsuario(){
        Usuario usuario = new Usuario("Marcos Escobar", 34);
        return usuario;
    }
}
