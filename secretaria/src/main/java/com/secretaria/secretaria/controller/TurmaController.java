package com.secretaria.secretaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secretaria.secretaria.model.Turma;
import com.secretaria.secretaria.repository.TurmaRepository;

@RestController
@RequestMapping("/turma")//a requisição passa a consumir essa classe
@CrossOrigin(origins = "*", allowedHeaders = "*")//para aceitar todas as origens do front @CrossOrigin(origins = "*", allowedHeaders = "*")
public class TurmaController {
	
	@Autowired//n conseguimos intanciar, por isso deixamos a responsabilidade de instanciamento para o spring
	private TurmaRepository repository;
	
	@GetMapping //FindAll
	public ResponseEntity<List<Turma>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")//FindById
	
	//@PathVariable  o valor q vai entrar na variavel id ele vai vir como uma variavel do caminha da uri
	public ResponseEntity<Turma> GetById (@PathVariable long id){
		return repository.findById(id).map(resp-> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Turma> post (@RequestBody Turma turma){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(turma));
	}
	@PutMapping
	public ResponseEntity<Turma> put (@RequestBody Turma turma){
		return ResponseEntity.ok(repository.save(turma));				
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
