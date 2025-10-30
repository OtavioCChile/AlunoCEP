package com.nossoprojeto.novaoportunidade.repository;

import com.nossoprojeto.novaoportunidade.model.TipoAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAlunoRepository extends JpaRepository<TipoAluno, Integer> {
}
