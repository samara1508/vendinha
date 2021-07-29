package br.com.samara.vendinha.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;
import java.util.Objects;

public class Compra {

	private Produto produto;
	private Cliente cliente;
	private Integer qtd;
	private List<ItemCompra> lista;
	private Long id;
	private EnumStatusPagamento status;
	private LocalDateTime dataCompra;
	private LocalDateTime dataPagamento;
	private LocalDateTime dataCancelamento;
	private BigDecimal valorPago;
	
	public Compra(Cliente c, Produto p, Integer qtd) {
		this.lista = new ArrayList<>();
		this.dataCompra = LocalDateTime.now();
		this.cliente = c;
		this.produto = p;
		this.qtd = qtd;
		this.id = new SplittableRandom().nextLong(1, Long.MAX_VALUE);
		this.addProduto(p, qtd);
		this.status = EnumStatusPagamento.AGUARDANDO;
	}
	
	public BigDecimal confirmar (BigDecimal valorPago) {
		BigDecimal troco = BigDecimal.ZERO;
		this.valorPago = valorPago;
		
		if (valorPago.compareTo(getTotal()) >= 0) {
			troco = valorPago.subtract(getTotal());
			this.status = EnumStatusPagamento.PAGO;
			this.dataPagamento = LocalDateTime.now();
		} 
		
		else if(Objects.isNull(valorPago)) {
			throw new RuntimeException("Dinheiro inválido");
		} 
		
		else if (valorPago.compareTo(getTotal()) < 0) {
			troco = valorPago.subtract(getTotal());
			this.status = EnumStatusPagamento.AGUARDANDO;
			this.dataPagamento = this.dataCompra;
		} 
		
		else if (EnumStatusPagamento.CANCELADO.equals(this.status)) {
			this.dataCancelamento = null;
		}
		// ou return valorPago.subtract(this.getTotal()) 
		return troco;
	}
	
	public BigDecimal cancelar () { 
		if (EnumStatusPagamento.PAGO.equals(this.status)) {
			this.status = EnumStatusPagamento.CANCELADO;
			this.dataCancelamento = LocalDateTime.now();
			return valorPago;
		} else {
			this.status = EnumStatusPagamento.CANCELADO;
			this.dataCancelamento = LocalDateTime.now();
			return BigDecimal.ZERO;
		}
	}
	
	public void addProduto(Produto p, Integer qtd) {
		this.lista.add(new ItemCompra(p, qtd));
	}

	public Produto getProduto() {
		return produto;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public Long getId () {
		return id;
	}
	
	public List<ItemCompra> getItens() {
		return lista;
	}
	
	public BigDecimal getTotal() {
		BigDecimal soma = BigDecimal.ZERO;
		for (ItemCompra i : lista) {
			soma = soma.add(i.getTotal());
		}
		return soma;
	}	
}