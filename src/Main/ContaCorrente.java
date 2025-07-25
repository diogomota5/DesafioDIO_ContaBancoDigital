package Main;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	public ContaCorrente(Cliente cliente, double saldo) {
		super(cliente, saldo);
	}

	@Override
	public String toString() {
		return "Agência: " + getAgencia() + "\nConta Corrente: " + getNumeroConta() + "\n" + getCliente();
	}

	public void imprimirExtrato() {
		System.out.println("Agência: " + getAgencia());
		System.out.println("Conta Corrente: " + getNumeroConta());
		System.out.println("Saldo disponível: " + getSaldo());
		System.out.println(getCliente());
	}

}
