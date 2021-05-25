package br.com.etec.demo.controller.form;

import br.com.etec.demo.models.Topico;
import br.com.etec.demo.repository.TopicoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizarTopicoForm {

    @NotNull
    @NotEmpty
    private String titulo;
    @NotNull @NotEmpty
    private String mensagem;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Topico atualizar(Long id, TopicoRepository topicoRepository) {
        Topico topico = topicoRepository.getOne(id);
        topico.setTitulo(this.titulo);
        topico.setMensagem(this.mensagem);
        return topico;

    }
}
