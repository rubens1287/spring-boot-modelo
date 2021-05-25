package br.com.etec.demo.repository;

import br.com.etec.demo.models.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
