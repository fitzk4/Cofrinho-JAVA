package cofrinhoUninter;

public class Euro extends Moeda {
	
	public Euro(double valorInicial){
		this.valor = valorInicial;
	}

	@Override
	public void info() {
		System.out.println("Euro - " +valor);
		
	}

	@Override
	public double converter() {
		return this.valor * 5.24;
	}

	@Override
	public boolean equals(Object objeto) {
		if (this == objeto) {
			return true;
		}

		if (!(objeto instanceof Euro)) { // Verifica se o objeto é uma instância da classe Euro.
			return false;
		}

		Euro outroEuro = (Euro) objeto;
		return Double.compare(this.valor, outroEuro.valor) == 0;
	}
}


