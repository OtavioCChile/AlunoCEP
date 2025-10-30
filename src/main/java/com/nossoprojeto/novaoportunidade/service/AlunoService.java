package com.nossoprojeto.novaoportunidade.service;

import com.nossoprojeto.novaoportunidade.model.Aluno;
import com.nossoprojeto.novaoportunidade.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository; //Injeta o repositório

    //Retorna uma lista com todos posts inseridos
    public List<Aluno> findAll() {
        return repository.findAll();
    }

    //Retorno um post a partir do ID
    public Optional<Aluno> findOne(Long id) {
        return repository.findById(id);
    }


    //Salva ou atualiza um post
    public Aluno save(Aluno aluno) {
        return repository.saveAndFlush(aluno);
    }

    //Exclui um post
    public void delete(Long id) {
        repository.deleteById(id);
    }

}