package Main;

public class ContaCorrente extends Conta {

	public ContaCorrente(int agencia, int numeroConta) {
		super(agencia, numeroConta);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== EXTRATO BANCÁRIO - CONTA CORRENTE ===");
		super.imprimirExtrato();
	}

}
