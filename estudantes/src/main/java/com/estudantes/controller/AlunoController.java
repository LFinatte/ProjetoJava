package com.alunos.controller;


import java.util.List;
import java.util.Optional;

import com.alunos.entities.Aluno;
import com.alunos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/alunos")           
@CrossOrigin
public class AlunoController {

    @Autowired
    private AlunoRepository repo;

    @GetMapping
    public List<Aluno> getAlunos() {
        List<Aluno> lista = repo.findAll();
        return lista;
    }

    @GetMapping("{id}")
    public Aluno getAluno(@PathVariable Long id){
        Optional<Aluno> op =  repo.findById(id);
        Aluno aluno = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return aluno;
    }


}


