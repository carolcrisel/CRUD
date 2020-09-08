package com.secretaria.secretaria.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity//essa anotação diz que essa classe vai ser uma entidade do jpa
@Table(name="tb_turma")//essa entidade dentro do banco de dados vira uma tabela
public class Turma {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) //esse atributo no banco de dados vai se tornar uma primary key 
		private long id;
		
		@NotNull
		//@Size(min = 5,max=50)
		private String turma;
	
		@NotNull
		private boolean ativo;
		
		@OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
		@JsonIgnoreProperties("turma") 
		private List<Aluno> Aluno;
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getTurma() {
			return turma;
		}

		public void setTurma(String turma) {
			this.turma = turma;
		}

		public boolean isAtivo() {
			return ativo;
		}

		public void setAtivo(boolean ativo) {
			this.ativo = ativo;
		} 
		public List<Aluno> getAluno() {
			return Aluno;
		}

		public void setAluno(List<Aluno> aluno) {
			Aluno = aluno;
		}

		
		
}
