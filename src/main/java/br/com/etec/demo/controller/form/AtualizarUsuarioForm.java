package br.com.etec.demo.controller.form;

import br.com.etec.demo.models.Topico;
import br.com.etec.demo.models.Usuario;
import br.com.etec.demo.repository.TopicoRepository;
import br.com.etec.demo.repository.UsuarioRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizarUsuarioForm {

    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String email;
    @NotNull @NotEmpty
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
        Usuario usuario = usuarioRepository.getOne(id);
        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);
        return usuario;
    }
}
