package Main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Apllication {

	public static void main(String[] args) throws ParseException {
		try (Scanner sc = new Scanner(System.in)) {
			List<Conta> contas = new ArrayList<>();

			do {
				System.out.println("\n=== BEM VINDO AO BANCO ===");
				System.out.println("=== SELECIONE UMA DAS OPÇÕES ABAIXO ===");
				System.out.println("1 - Cadastrar uma nova conta");
				System.out.println("2 - Consultar contas cadastradas");
				System.out.println("3 - Efetuar um depósito");
				System.out.println("4 - Efetuar um saque");
				System.out.println("5 - Efetuar uma transferência");
				System.out.println("6 - Imprimir o extrato de uma conta");
				System.out.println("7 - Sair do Sistema");
				int optional = -1;
				optional = sc.nextInt();

				switch (optional) {
				case 1:
					char resposta;
					System.out.println("=== Cadastro de Conta ===");
					System.out.println("Informe o nome do Cliente: ");
					String nome = sc.next();
					do {
						System.out.println("Deseja abrir uma Conta Corrente ou Conta Poupança: (C / P)");
						resposta = sc.next().toUpperCase().charAt(0);
					} while (resposta != 'C' && resposta != 'P');
					if (resposta == 'C') {
						do {
							System.out.println("Deseja realizar um depósito na abertura da Conta Corrente? (S / N)");
							resposta = sc.next().toUpperCase().charAt(0);
						} while (resposta != 'S' && resposta != 'N');
						if (resposta == 'S') {
							System.out.println("Informe o valor do depósito: ");
							double valorDeposito = sc.nextDouble();
							Conta conta = new ContaCorrente(new Cliente(nome), valorDeposito);
							contas.add(conta);
							System.out.println("\nConta Corrente criada com sucesso: \n" + conta);
						} else if (resposta == 'N') {
							Conta conta = new ContaCorrente(new Cliente(nome));
							contas.add(conta);
							System.out.println("\nConta Corrente criada com sucesso: \n" + conta);
						}
						while (resposta != 'S' && resposta != 'N')
							;
					} else if (resposta == 'P') {
						do {
							System.out.println("Deseja realizar um depósito na abertura da Conta Poupança? (S / N)");
							resposta = sc.next().toUpperCase().charAt(0);
						} while (resposta != 'S' && resposta != 'N');
						if (resposta == 'S') {
							System.out.println("Informe o valor do depósito: ");
							double valorDeposito = sc.nextDouble();
							Conta conta = new ContaPoupanca(new Cliente(nome), valorDeposito);
							contas.add(conta);
							System.out.println("\nConta Poupança criada com sucesso: \n" + conta);
						} else if (resposta == 'N') {
							Conta conta = new ContaPoupanca(new Cliente(nome));
							contas.add(conta);
							System.out.println("\nConta Poupança criada com sucesso: \n" + conta);
						}
					}
					break;
				case 2:
					System.out.println("As contas cadastradas são: ");
					for (Conta conta : contas) {
						System.out.println("\n" + conta);
					}
					break;
				case 3:
					System.out.println("Informe o número da conta que deseja realizar o depósito: ");
					int numeroConta = sc.nextInt();
					for (Conta conta : contas) {
						if (numeroConta == conta.getNumeroConta()) {
							System.out.println("Qual valor deseja depositar ?");
							double deposito = sc.nextDouble();
							conta.depositar(deposito);
							System.out.println(conta);
						}
					}
					break;
				case 4:
					System.out.println("Informe o número da conta que deseja realizar o saque: ");
					numeroConta = sc.nextInt();
					for (Conta conta : contas) {
						if (numeroConta == conta.getNumeroConta()) {
							System.out.println("Qual valor deseja sacar ?");
							double saque = sc.nextDouble();
							conta.sacar(saque);
							System.out.println(conta);
						}
					}
					break;
				case 5:
					System.out.println("Informe o número da conta que deseja realizar o saque para transferência: ");
					numeroConta = sc.nextInt();
					System.out.println("Informe o número da conta que deseja realizar o deposito: ");
					int numeroConta2 = sc.nextInt();
					System.out.println("Qual valor deseja transferir?");
					double transferencia = sc.nextDouble();
					for (Conta conta : contas) {
						if (numeroConta == conta.getNumeroConta()) {
							conta.sacar(transferencia);
							conta.imprimirExtrato();
						}
					}
					for (Conta conta : contas) {
						if (numeroConta2 == conta.getNumeroConta()) {
							conta.depositar(transferencia);
							conta.imprimirExtrato();
						}
					}
					break;
				case 6:
					System.out.println("Informe o número da conta que deseja emitir o extrato: ");
					numeroConta = sc.nextInt();
					for (Conta conta : contas) {
						if (numeroConta == conta.getNumeroConta()) {
							conta.imprimirExtrato();
						}
					}
					break;
				case 7:
					System.exit(0);
				default:
					System.out.println("Opção escolhida inválida, informe um número de 1 a 8");
				}
			} while (true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
