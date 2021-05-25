package br.com.etec.demo.controller.form;

import br.com.etec.demo.models.Curso;
import br.com.etec.demo.models.Topico;
import br.com.etec.demo.repository.CursoRepository;
import br.com.etec.demo.repository.TopicoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CursoForm {

    private Long id;
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String categoria;

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

    public Curso coverter() {
        return new Curso(id,nome,categoria);
    }


}
