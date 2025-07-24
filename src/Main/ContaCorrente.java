package Main;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}
	
	public ContaCorrente(Cliente cliente, double saldo) {
		super(cliente, saldo);
	}
	

	@Override
	public void imprimirExtrato() {
		System.out.println("=== EXTRATO BANCÁRIO - CONTA CORRENTE ===");
		super.imprimirExtrato();
	}

}
