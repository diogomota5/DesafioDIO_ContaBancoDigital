package Main;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(int agencia, int numeroConta) {
		super(agencia, numeroConta);
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println("=== EXTRATO BANCÁRIO - CONTA POUPANÇA ===");
		super.imprimirExtrato();
	}

}
