package Main;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}
	
	public ContaPoupanca(Cliente cliente, double valor) {
		super(cliente, valor);
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println("=== EXTRATO BANCÁRIO - CONTA POUPANÇA ===");
		super.imprimirExtrato();
	}

}
