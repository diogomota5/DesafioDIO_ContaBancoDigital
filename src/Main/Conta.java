package Main;

public abstract class Conta implements iConta {

	protected int agencia;
	protected int numeroConta;
	protected double saldo;
	protected Cliente cliente;

	public Conta(int agencia, int numeroConta) {
		this.agencia = agencia;
		this.numeroConta = numeroConta;
	}

	public Conta(int agencia, int numeroConta, double saldo) {
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void sacar(double valor) {
		if (getSaldo() <= 0) {
			System.out.println("Seu saldo está zerado e/ou negativo");
		} else if (getSaldo() < valor) {
			System.out.println("Saldo insuficiente para saque");
		} else {
			this.saldo = getSaldo() - valor;
		}
	}

	public void depositar(double valor) {
		this.saldo = getSaldo() + valor;
	}

	public void transferir(double valor, iConta contaDestino) {
		if (getSaldo() <= 0) {
			System.out.println("Seu saldo está zerado e/ou negativo");
		} else if (getSaldo() < valor) {
			System.out.println("Saldo insuficiente para transferência");
		} else {
			this.sacar(valor);
			contaDestino.depositar(valor);
		}
	}

	public void imprimirExtrato() {
		System.out.println("Agência: " + getAgencia());
		System.out.println("Conta: " + getNumeroConta());
		System.out.println("Saldo disponível: " + getSaldo());
		System.out.println("Cliente: " + getCliente());
	}

	@Override
	public String toString() {
		return "Agência: " + getAgencia() 
				   + "\nConta: " + getNumeroConta() 
				   + "\nCliente " + getCliente();
	}

}
