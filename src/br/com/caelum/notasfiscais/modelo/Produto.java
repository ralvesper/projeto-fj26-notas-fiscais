package br.com.caelum.notasfiscais.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Produto {
	@Id @GeneratedValue
	private Long id;
	
	@NotEmpty(message="Produto deve ter um nome válido")
	private String nome;
	
	@NotEmpty(message="Produto deve ter uma descricao válida")
	private String descricao;
	
	@Pattern(regexp="[0-9]")
	private Double preco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
