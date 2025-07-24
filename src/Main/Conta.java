package Main;

public abstract class Conta implements iConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numeroConta;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numeroConta = SEQUENCIAL++;
		this.cliente = cliente;
	}

	public Conta(Cliente cliente, double saldo) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numeroConta = SEQUENCIAL++;
		this.cliente = cliente;
		this.saldo = saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
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
		System.out.println(getCliente());
	}

	@Override
	public String toString() {
		return "Agência: " + getAgencia() + "\nConta: " + getNumeroConta() + "\n" + getCliente() + "\nSaldo: " + getSaldo();
	}

}
