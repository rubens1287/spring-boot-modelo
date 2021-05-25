package br.com.etec.demo.controller.dto;

import br.com.etec.demo.models.Curso;
import br.com.etec.demo.models.Topico;
import br.com.etec.demo.repository.CursoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CursoDto {

    private Long id;
    private String nome;
    private String categoria;

    public CursoDto(Curso curso) {
        this.id = curso.getId();
        this.nome = curso.getNome();
        this.categoria = curso.getCategoria();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public static List<CursoDto> coverter(List<Curso> cursos) {
        return cursos.stream().map(CursoDto::new).collect(Collectors.toList());
    }
}
