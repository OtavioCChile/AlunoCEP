package com.nossoprojeto.novaoportunidade.service;

import com.nossoprojeto.novaoportunidade.model.Aluno;
import com.nossoprojeto.novaoportunidade.model.TipoAluno;
import com.nossoprojeto.novaoportunidade.repository.TipoAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoAlunoService {

    @Autowired
    private TipoAlunoRepository tipoAlunoRepository;

    public List<TipoAluno> findAll() {
        return tipoAlunoRepository.findAll();
    }

    //Retorno um post a partir do ID
    public Optional<TipoAluno> findOne(int id) {
        return tipoAlunoRepository.findById(id);
    }


    //Salva ou atualiza um post
    public TipoAluno save(TipoAluno tipoAluno) {
        return tipoAlunoRepository.saveAndFlush(tipoAluno);
    }

    //Exclui um post
    public void delete(int id) {
        tipoAlunoRepository.deleteById(id);
    }


}
