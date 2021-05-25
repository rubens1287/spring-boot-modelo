package br.com.etec.demo.controller.form;

import br.com.etec.demo.models.Curso;
import br.com.etec.demo.models.Topico;
import br.com.etec.demo.repository.CursoRepository;
import br.com.etec.demo.repository.TopicoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizarCursoForm {

    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String categoria;

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

    public Curso atualizar(Long id, CursoRepository cursoRepository) {
        Curso curso = cursoRepository.getOne(id);
        curso.setNome(this.nome);
        curso.setCategoria(this.categoria);
        return curso;

    }
}
