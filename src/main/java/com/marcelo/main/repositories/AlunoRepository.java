package com.marcelo.main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcelo.main.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	Optional<Aluno> findByMatricula(String matricula);
	Boolean existsByMatricula(String matricula);
	void deleteByMatricula(String matricula);
	void deleteAllByMatricula(String matricula);
	
}
