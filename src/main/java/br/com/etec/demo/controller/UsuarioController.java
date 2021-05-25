package br.com.etec.demo.controller;

import br.com.etec.demo.controller.dto.CursoDto;
import br.com.etec.demo.controller.dto.UsuarioDto;
import br.com.etec.demo.controller.form.AtualizarCursoForm;
import br.com.etec.demo.controller.form.AtualizarUsuarioForm;
import br.com.etec.demo.controller.form.CursoForm;
import br.com.etec.demo.controller.form.UsuarioForm;
import br.com.etec.demo.models.Curso;
import br.com.etec.demo.models.Topico;
import br.com.etec.demo.models.Usuario;
import br.com.etec.demo.repository.TopicoRepository;
import br.com.etec.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public List<Usuario> lista() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder) {
        Usuario usuario = form.coverter();
        usuarioRepository.save(usuario);
        URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UsuarioDto> atualizar(@PathVariable("id") Long id, @RequestBody @Valid AtualizarUsuarioForm form) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(new UsuarioDto(form.atualizar(id, usuarioRepository)));
        }
        return ResponseEntity.notFound().build();
    }
}
