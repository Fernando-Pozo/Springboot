package br.org.generation.minhaLojaGame.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Tb_Produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "O atributo nome é obrigatorio!")
	@Size(min = 5, max = 50, message = "O atributo nome deve ter no minimo 5 e no maximo 50 caracteres")
	private String nome;
	
	@NotNull(message = "O atributo preço é obrigatorio!")
	@Size(min = 5, max = 100, message = "O atributo texto deve ter no minimo 5 e no maximo 1000 caracteres")
	private double preco;

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Produto produto;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
