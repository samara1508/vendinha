package br.com.samara.vendinha;

import java.math.BigDecimal;
import java.util.SplittableRandom;

public class ItemCompra {

	private Produto produto;
	private Integer qtd;
	private BigDecimal valorUnit;
	private BigDecimal total;
	private Long id;
	
	public ItemCompra (Compra compra) {
		this.valorUnit = produto.getValor();
		this.total = produto.getValor().multiply(BigDecimal.valueOf(this.qtd));
		this.id = new SplittableRandom().nextLong(1, Long.MAX_VALUE);
	}
	
	public Integer getQtd() {
		return qtd;
	}

	public BigDecimal getValorUnit() {
		return valorUnit;
	}

	public BigDecimal getTotal() {
		return total;
	}
	
	public Long getId () {
		return id;
	}
}
