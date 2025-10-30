package com.nossoprojeto.novaoportunidade.service;

import com.nossoprojeto.novaoportunidade.model.TipoAluno;
import com.nossoprojeto.novaoportunidade.repository.TipoAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoAlunoService {

    @Autowired
    private TipoAlunoRepository tipoAlunoRepository;

    public List<TipoAluno> findAll() {
        return tipoAlunoRepository.findAll();
    }

}
