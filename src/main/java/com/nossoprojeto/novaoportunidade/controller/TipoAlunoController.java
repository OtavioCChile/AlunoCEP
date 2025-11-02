package com.nossoprojeto.novaoportunidade.controller;

import com.nossoprojeto.novaoportunidade.model.TipoAluno;
import com.nossoprojeto.novaoportunidade.service.TipoAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tipos")
public class TipoAlunoController {

    @Autowired
    private TipoAlunoService service;

    @GetMapping("/")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView("/tipoAluno");
        mv.addObject("tipos", service.findAll());
        return mv;
    }

    @GetMapping("/add")
    public ModelAndView add(TipoAluno tipoAluno){
        ModelAndView mv = new ModelAndView("/tipoAlunoAdd");
        mv.addObject("tipoAluno", tipoAluno);
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id) {
        return add(service.findOne(id).get());
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {
        service.delete(id);
        return findAll();
    }

    @PostMapping("/save")
    public ModelAndView save(TipoAluno tipoAluno, BindingResult result){
        if(result.hasErrors()){
            return add(tipoAluno);
        }
        service.save(tipoAluno);
        return findAll();
    }


}
