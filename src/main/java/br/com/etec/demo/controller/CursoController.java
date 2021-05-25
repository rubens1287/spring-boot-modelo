package br.com.etec.demo.controller;

import br.com.etec.demo.controller.dto.CursoDto;
import br.com.etec.demo.controller.dto.TopicoDto;
import br.com.etec.demo.controller.form.AtualizarCursoForm;
import br.com.etec.demo.controller.form.AtualizarTopicoForm;
import br.com.etec.demo.controller.form.CursoForm;
import br.com.etec.demo.controller.form.TopicoForm;
import br.com.etec.demo.models.Curso;
import br.com.etec.demo.models.Topico;
import br.com.etec.demo.models.Usuario;
import br.com.etec.demo.repository.CursoRepository;
import br.com.etec.demo.repository.TopicoRepository;
import br.com.etec.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    @Transactional
    public List<Curso> lista(){
        List<Curso> Curso = cursoRepository.findAll();
        return Curso;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CursoDto> cadastrar(@RequestBody @Valid CursoForm form, UriComponentsBuilder uriBuilder){
        Curso curso = form.coverter();
        cursoRepository.save(curso);
        URI uri = uriBuilder.path("/curso/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(new CursoDto(curso));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CursoDto> atualizar(@PathVariable("id") Long id, @RequestBody @Valid AtualizarCursoForm form){
        Optional<Curso> curso = cursoRepository.findById(id);
        if(curso.isPresent()){
            return  ResponseEntity.ok(new CursoDto(form.atualizar(id,cursoRepository)));
        }
        return  ResponseEntity.notFound().build();
    }
}
