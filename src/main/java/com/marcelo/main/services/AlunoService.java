package com.marcelo.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.marcelo.main.entities.Aluno;
import com.marcelo.main.repositories.AlunoRepository;

@Service
public class AlunoService {

	
	@Autowired
	AlunoRepository aRepository;
	public void insertAluno(Aluno aluno) {
		try {
			if (aRepository.existsByMatricula(aluno.getMatricula())) {
				throw new RuntimeException();
			}
			aRepository.save(aluno);
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.NOT_MODIFIED);
		}
		
	}
	
	public Aluno buscarAluno(String matricula) {
		try {
			if (!aRepository.existsByMatricula(matricula))
				throw new RuntimeException();
			
			return aRepository.findByMatricula(matricula).get();
		
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	public List<Aluno> buscarAlunos() {
		return aRepository.findAll();
	}
	
	public void alterarAluno(String matricula, Aluno aluno) {
		try {
			if (!aRepository.existsByMatricula(matricula)) 
				throw new RuntimeException();
			
			Optional<Aluno> alunoUpdate = aRepository.findByMatricula(matricula);
			alunoUpdate.get().setNome(aluno.getNome());
			alunoUpdate.get().setMensalidade(aluno.getMensalidade());
			aRepository.save(alunoUpdate.get());
			
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
		}
	}
	
	public void deleteAluno(String matricula) {
		try {
			if (!aRepository.existsByMatricula(matricula))
				throw new RuntimeException();
			
			aRepository.deleteByMatricula(matricula);
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
}
