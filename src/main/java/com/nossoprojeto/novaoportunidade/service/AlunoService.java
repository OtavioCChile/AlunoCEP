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

    public List<Aluno> findAll() {
        return repository.findAll();
    }

    public Optional<Aluno> findOne(Long id) {
        return repository.findById(id);
    }

    public Aluno save(Aluno aluno) {
        return repository.saveAndFlush(aluno);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}