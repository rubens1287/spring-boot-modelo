package br.com.etec.demo.repository;

import br.com.etec.demo.models.Curso;
import br.com.etec.demo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    Curso findByNome(String nome);
}
