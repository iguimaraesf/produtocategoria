package com.guimaraes.cadastro.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	@Column(length = 200)
	private String nome;
	@NotNull
	@Positive
	@Column(precision = 12, scale = 2)
	private BigDecimal valor;
	@NotNull
	@ManyToOne
	private Categoria categoria;
	@Future
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate validade;

	public Produto() {
		
	}

	public Produto(Long id, @NotEmpty String nome, @NotNull BigDecimal valor, @NotNull Categoria categoria,
			@Future LocalDate validade) {
		this();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.categoria = categoria;
		this.validade = validade;
	}


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
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public LocalDate getValidade() {
		return validade;
	}
	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Produto))
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", valor=" + valor + ", categoria=" + categoria + ", validade="
				+ validade + "]";
	}
	
	
}
