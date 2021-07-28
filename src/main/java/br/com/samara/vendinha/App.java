package br.com.samara.vendinha;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {
        
    	Produto p1 = new Produto("cenoura", BigDecimal.valueOf(0.5));
    	Produto p2 = new Produto("casa", BigDecimal.valueOf(1500.35));
    	Produto p3 = new Produto("carro", BigDecimal.valueOf(8790.25));
    	
    	Cliente carlos = new Cliente("Carlos");
    	Compra compra = new Compra (carlos, p2, 5);
    	ItemCompra itens = new ItemCompra(compra);
    	
    	System.out.println("Cliente...: " + compra.getCliente().getNome());
    	System.out.println("Id Cliente: " + compra.getCliente().getId());
    	System.out.println("Produto...: " + compra.getProduto().getNome());
    	System.out.println("Id Produto: " + compra.getProduto().getId());
    	System.out.println("Qtd.......: " + itens.getQtd());
    	System.out.println("Valor.....: " + itens.getValorUnit());
    	System.out.println("Total.....: " + itens.getTotal());
    	System.out.println("Id Compra.: " + compra.getId());
    }
}
