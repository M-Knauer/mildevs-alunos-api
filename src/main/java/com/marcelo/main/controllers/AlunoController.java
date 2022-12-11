package com.marcelo.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.main.entities.Aluno;
import com.marcelo.main.services.AlunoService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	AlunoService aService;
	
	@PostMapping
	@Transactional
	@ResponseStatus(code = HttpStatus.CREATED)
	public void insertAluno(@RequestBody Aluno aluno) {
		aService.insertAluno(aluno);
		
	}
	
	@ResponseStatus(code = HttpStatus.FOUND)
	@GetMapping(path = "/{matricula}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Aluno buscarAluno(@PathVariable String matricula) {
		return aService.buscarAluno(matricula);
		
	}
	
	@ResponseStatus(code = HttpStatus.FOUND)
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Aluno> buscarAlunos() {
		return aService.buscarAlunos();
		
	}
	
	@PutMapping(path = "/{matricula}")
	@Transactional
	public void updateAluno(@PathVariable String matricula, @RequestBody Aluno aluno) {
		aService.alterarAluno(matricula, aluno);
			
	}
	
	@DeleteMapping(path = "/{matricula}")
	@Transactional
	public void deleteAluno(@PathVariable String matricula) {
		aService.deleteAluno(matricula);
		
	}
	
}
