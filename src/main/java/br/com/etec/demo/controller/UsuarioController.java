package br.com.etec.demo.controller;

import br.com.etec.demo.models.Usuario;
import br.com.etec.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping("/usuario")
    public List<Usuario> lista(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }


}
