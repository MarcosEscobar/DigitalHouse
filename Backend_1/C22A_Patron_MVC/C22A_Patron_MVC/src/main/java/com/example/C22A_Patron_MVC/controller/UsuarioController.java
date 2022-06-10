package com.example.C22A_Patron_MVC.controller;

import com.example.C22A_Patron_MVC.dominio.Usuario;
import com.example.C22A_Patron_MVC.services.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    private UsuarioService usuarioService = new UsuarioService();

    @GetMapping("/")
    public Usuario crearUsuario(){
        return usuarioService.crearUsuario();
    }


}
