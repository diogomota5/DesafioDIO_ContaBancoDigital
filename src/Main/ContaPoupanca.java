package Main;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	public ContaPoupanca(Cliente cliente, double valor) {
		super(cliente, valor);
	}

	@Override
	public String toString() {
		return "Agência: " + getAgencia() + "\nConta Poupança: " + getNumeroConta() + "\n" + getCliente();
	}

	public void imprimirExtrato() {
		System.out.println("Agência: " + getAgencia());
		System.out.println("Conta Poupança: " + getNumeroConta());
		System.out.println("Saldo disponível: " + getSaldo());
		System.out.println(getCliente());
	}
}
