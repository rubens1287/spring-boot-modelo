package br.com.etec.demo.controller;

import br.com.etec.demo.models.Curso;
import br.com.etec.demo.models.Usuario;
import br.com.etec.demo.repository.CursoRepository;
import br.com.etec.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @RequestMapping("/curso")
    public List<Curso> lista(){
        List<Curso> Curso = cursoRepository.findAll();
        return Curso;
    }


}
