package br.com.samara.vendinha.domain;

import java.math.BigDecimal;
import java.util.SplittableRandom;

public class ItemCompra {

	private Produto produto;
	private Integer qtd;
	private BigDecimal total;
	private Long id;
	
	public ItemCompra (Produto p, Integer qtd) {
		this.produto = p;
		this.qtd = qtd;
		this.total = produto.getValor().multiply(BigDecimal.valueOf(this.qtd));
		this.id = new SplittableRandom().nextLong(1, Long.MAX_VALUE);
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public Integer getQtd() {
		return qtd;
	}

	public BigDecimal getTotal() {
		return total;
	}
	
	public Long getId () {
		return id;
	}
}
