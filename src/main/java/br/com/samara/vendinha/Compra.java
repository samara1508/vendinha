package br.com.samara.vendinha;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class Compra {

	private Produto produto;
	private Cliente cliente;
	private Integer qtd;
	private List<ItemCompra> lista = new ArrayList<>();
	private Long id; 
	
	public Compra(Cliente c, Produto p, Integer qtd) {
		this.cliente = c;
		this.produto = p;
		this.qtd = qtd;
		this.id = new SplittableRandom().nextLong(1, Long.MAX_VALUE);
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
	
	
}