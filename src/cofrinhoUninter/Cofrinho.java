package cofrinhoUninter;

import java.util.ArrayList;

public class Cofrinho<M extends Moeda> { // Utilizei o "M" como um tipo genérico para ficar mais fácil a leitura e utilização.
	
	private ArrayList<M> listaMoedas;
	
	public Cofrinho() {
		this.listaMoedas = new ArrayList<>();
	}

	public void adicionar(M moeda) {
		this.listaMoedas.add(moeda);
	}
	
	public boolean remover(M moeda) {
		return this.listaMoedas.remove(moeda);
	}
	
	public void listagemMoedas() {
		if (listaMoedas.isEmpty()) { // Verifica se a lista de moedas está vazia
			System.out.println("Não há moedas!");
			return; // Retorna imediatamente se a lista estiver vazia
		}
		
		for (M moeda : listaMoedas) {
			moeda.info(); // Chama o método info() de cada moeda na lista
		}
	}

	public double totalConvertido() {
		double acumuloValor = 0;
		
		for (M moeda : listaMoedas) {
			acumuloValor += moeda.converter(); // Acumula o valor convertido de cada moeda
		}
		
		return acumuloValor; // Retorna o valor total convertido
	}

}
