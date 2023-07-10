package cofrinhoUninter;

public class Dolar extends Moeda {
	
	public Dolar(double valorInicial){
		this.valor = valorInicial;
	}

	@Override
	public void info() {
		System.out.println("Dólar - " +valor);
		
	}

	@Override
	public double converter() {
		return this.valor * 4.81;
	}

	@Override
	public boolean equals(Object objeto) {
		if (this == objeto) {
			return true;
		}

		if (!(objeto instanceof Dolar)) { // Verifica se o objeto é uma instância da classe Dolar.
			return false;
		}

		Dolar outroDolar = (Dolar) objeto;
		return Double.compare(this.valor, outroDolar.valor) == 0;
	}
}


