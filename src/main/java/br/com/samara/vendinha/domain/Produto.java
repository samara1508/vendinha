package br.com.samara.vendinha.domain;

import java.math.BigDecimal;
import java.util.SplittableRandom;

public class Produto {
	
	private String nome;
	private BigDecimal valor;
	private Long id;
	
	public Produto(String nome, BigDecimal valor) {
		this.nome = nome;
		this.valor = valor;
		this.id = new SplittableRandom().nextLong(1, Long.MAX_VALUE);
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getValor() {
		return valor;
	}
	
	public Long getId () {
		return id;
	}
}
