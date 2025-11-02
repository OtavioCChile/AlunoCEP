package com.nossoprojeto.novaoportunidade.controller;

import com.nossoprojeto.novaoportunidade.model.Aluno;
import com.nossoprojeto.novaoportunidade.model.TipoAluno;
import com.nossoprojeto.novaoportunidade.service.AlunoService;
import com.nossoprojeto.novaoportunidade.service.CepService;
import com.nossoprojeto.novaoportunidade.service.TipoAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AlunoController {
    @Autowired
    private AlunoService service;

    @Autowired
    private TipoAlunoService tipoAlunoService;

    @GetMapping("/")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView("/aluno");
        mv.addObject("alunos", service.findAll());
        return mv;
    }

    @GetMapping("/add")
    public ModelAndView add(Aluno aluno) {

        ModelAndView mv = new ModelAndView("/alunoAdd");
        mv.addObject("aluno", aluno);
        mv.addObject("tipos", tipoAlunoService.findAll());

        return mv;
    }



    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        Aluno alunoParaEditar = service.findOne(id).get();
        return add(alunoParaEditar);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {

        service.delete(id);

        return findAll();
    }

    @Autowired
    private CepService cepService;

//    @GetMapping("/buscar-endereco/{cep}/{numero}")
//    public ModelAndView buscarEndereco(@PathVariable String cep, @PathVariable String numero) {
//        Long numeroLong = null;
//        if (numero != null && !numero.equalsIgnoreCase("null") && !numero.isBlank()) {
//            numeroLong = Long.valueOf(numero);
//        }
//
//        Aluno aluno = cepService.buscarEnderecoPorCep(cep, numeroLong);
//        ModelAndView mv = new ModelAndView("/alunoAdd");
//        mv.addObject("aluno", aluno);
//        mv.addObject("tipos", tipoAlunoService.findAll());
//        return mv;
//    }

    @GetMapping("/buscar-endereco-json/{cep}/{numero}")
    @ResponseBody
    public Aluno buscarEnderecoJson(@PathVariable String cep, @PathVariable String numero) {
        Long numeroLong = null;
        if (numero != null && !numero.equalsIgnoreCase("null") && !numero.isBlank()) {
            numeroLong = Long.valueOf(numero);
        }
        return cepService.buscarEnderecoPorCep(cep, numeroLong);
    }




    @PostMapping("/save")
    public ModelAndView save(Aluno aluno, BindingResult result) {

        if(result.hasErrors()) {
            return add(aluno);
        }

        service.save(aluno);

        return findAll();
    }


}
