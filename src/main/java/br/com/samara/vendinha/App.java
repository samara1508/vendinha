package br.com.samara.vendinha;

import java.math.BigDecimal;
import br.com.samara.vendinha.domain.Cliente;
import br.com.samara.vendinha.domain.Compra;
import br.com.samara.vendinha.domain.ItemCompra;
import br.com.samara.vendinha.domain.Produto;

public class App {

    public static void main(String[] args) {
        
    	Produto p1 = new Produto("cenoura", BigDecimal.valueOf(0.50));
    	Produto p2 = new Produto("tomate", BigDecimal.valueOf(0.80));
    	Produto p3 = new Produto("batata", BigDecimal.valueOf(14.50));
    	
    	Cliente eu = new Cliente("Samarinea");
    	
    	Compra c = eu.comprar(p1, 4);
    	c.addProduto(p2, 2);
    	
    	System.out.println("Cliente....: " + c.getCliente().getId() + " - " + c.getCliente().getNome());
    	for (ItemCompra i : c.getItens()) {
			System.out.println("");
    		System.out.println("Produto....: " + i.getProduto().getId() + " - " + i.getProduto().getNome());
    		System.out.println("Qtd........: " + i.getQtd());
    		System.out.println("Valor UN...: " + i.getProduto().getValor());
    		System.out.println("Total......: " + i.getTotal());
		}
    	System.out.println("Total G....: " + c.getTotal());
    	System.out.println("Troco......: " + c.confirmar(BigDecimal.valueOf(5.00)));

    }
}
