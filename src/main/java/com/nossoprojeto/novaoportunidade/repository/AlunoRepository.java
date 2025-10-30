package com.nossoprojeto.novaoportunidade.repository;

import com.nossoprojeto.novaoportunidade.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
