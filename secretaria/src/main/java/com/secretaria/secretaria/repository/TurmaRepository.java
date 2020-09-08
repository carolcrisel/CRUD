package com.secretaria.secretaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;	
import org.springframework.stereotype.Repository;

import com.secretaria.secretaria.model.Turma;


@Repository //indica para o spring q essa classe se trata de uma classe de repositório
public interface TurmaRepository extends JpaRepository<Turma, Long>  //long do jeito primitivo ESSE É TIPO DO ID
{
	public List<Turma> findAllByTurmaContainingIgnoreCase (String turma);
}

