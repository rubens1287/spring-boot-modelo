package br.com.etec.demo.controller.form;

import br.com.etec.demo.models.Curso;
import br.com.etec.demo.models.Topico;
import br.com.etec.demo.models.Usuario;
import br.com.etec.demo.repository.CursoRepository;
import br.com.etec.demo.repository.TopicoRepository;
import br.com.etec.demo.repository.UsuarioRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TopicoForm {

    @NotNull @NotEmpty
    private String titulo;
    @NotNull @NotEmpty
    private String mensagem;
    @NotNull @NotEmpty
    private String nomeCurso;
    @NotNull @NotEmpty
    private String emailUsuario;

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

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public Topico coverter(CursoRepository cursoRepository, UsuarioRepository usuarioRepository) {
        Curso curso = cursoRepository.findByNome(nomeCurso);
        Usuario usuario = usuarioRepository.findByEmail(emailUsuario);
        return new Topico(titulo,mensagem,curso,usuario);
    }
}
