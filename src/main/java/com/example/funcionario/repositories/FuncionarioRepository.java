package com.example.funcionario.repositories;

import com.example.funcionario.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.parser.Entity;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    @Query(value = "SELECT * FROM Funcionario WHERE data_admissao = ?1", nativeQuery = true)
    Optional<Funcionario> findByData(String dataAdmissao);
}
