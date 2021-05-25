package br.com.etec.demo.controller;

import br.com.etec.demo.controller.dto.DetalhesDoTopicoDto;
import br.com.etec.demo.controller.dto.TopicoDto;
import br.com.etec.demo.controller.form.AtualizarTopicoForm;
import br.com.etec.demo.controller.form.TopicoForm;
import br.com.etec.demo.models.Topico;
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
@RequestMapping(value = "/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<TopicoDto> lista(String nomeCurso){
        List<Topico> topico = topicoRepository.findAll();
        return TopicoDto.coverter(topico);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder){
        Topico topico = form.coverter(cursoRepository,usuarioRepository);
        topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DetalhesDoTopicoDto> detalhar(@PathVariable("id") Long id){
        Optional<Topico> topico = topicoRepository.findById(id);
        if(topico.isPresent()){
            return  ResponseEntity.ok(new DetalhesDoTopicoDto(topico.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDto> atualizar(@PathVariable("id") Long id, @RequestBody @Valid AtualizarTopicoForm form, UriComponentsBuilder uriBuilder){
        Optional<Topico> topico = topicoRepository.findById(id);
        if(topico.isPresent()){
            return  ResponseEntity.ok(new TopicoDto(form.atualizar(id,topicoRepository)));
        }
        return  ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDto> atualizar(@PathVariable("id") Long id){
        Optional<Topico> topico = topicoRepository.findById(id);
        if(topico.isPresent()){
            topicoRepository.deleteById(id);
            return  ResponseEntity.ok().build();
        }
        return  ResponseEntity.notFound().build();
    }


}
