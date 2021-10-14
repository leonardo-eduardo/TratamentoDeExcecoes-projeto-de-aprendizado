package aplicacao;

public class Conta {

	private int numerodaconta;
	private String titular;
	private double saldo;
	private double limitedesaque;

	public Conta() {
	}

	public Conta(int numerodaconta, String titular) throws ContaException {
		this.numerodaconta = numerodaconta;
		if (titular.length() > 10) {
			throw new ContaException("Nome com mais de 10 caracteres\nRepita a operação");// TRATAMENTO DO ERRO COM A
																							// MENSAGEM
		} else {
			this.titular = titular;
		}
	}

	public Conta(int numerodaconta, String titular, double saldo, double limitedesaque) throws ContaException {
		this.numerodaconta = numerodaconta;
		this.titular = titular;
		if (saldo > 500.00) {
			this.saldo = saldo;
		} else {
			throw new ContaException("Valor de depósito inicial inferior a R$500,00\nRepita a operação");// TRATAMENTO
																											// DO ERRO
																											// COM A
																											// MENSAGEM
		}

		this.limitedesaque = limitedesaque;
	}

	public int getNumerodaconta() {
		return numerodaconta;
	}

	public void setNumerodaconta(int numerodaconta) {
		this.numerodaconta = numerodaconta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getLimitedesaque() {
		return limitedesaque;
	}

	public void deposito(double valor) {
		saldo += valor;
	}

	public void saque(double valor) throws ContaException {
		if (valor <= saldo && valor <= limitedesaque) {
			saldo -= valor;
		} else if (valor > limitedesaque) {
			throw new ContaException("Limite de saque ultrapassado\nRepita a operação");// TRATAMENTO DO ERRO COM A
																						// MENSAGEM
		} else {
			throw new ContaException("Saldo insuficiente\nRepita a operação");// TRATAMENTO DO ERRO COM A MENSAGEM
		}
	}

	public String toString() {
		return "Conta número: " + numerodaconta + "   " + "Titular: " + titular + "   " + "Saldo em conta R$ "
				+ String.format("%.2f", saldo);
	}

}
