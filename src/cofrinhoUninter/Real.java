package cofrinhoUninter;

public class Real extends Moeda {
	
	public Real(double valorInicial) {
		this.valor = valorInicial;
	}

	@Override
	public void info() {
		System.out.println("Real - " + valor);
	}

	@Override
	public double converter() {
		return this.valor;
	}
	
	@Override
	public boolean equals(Object objeto) {
		if (this == objeto) {
			return true;
		}

		if (!(objeto instanceof Real)) { // Verifica se o objeto é uma instância da classe Real.
			return false;
		}

		Real outroReal = (Real) objeto;
		return Double.compare(this.valor, outroReal.valor) == 0;
	}
}