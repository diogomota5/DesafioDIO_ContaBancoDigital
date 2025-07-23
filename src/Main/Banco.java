package Main;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	public String nome;
	List<Conta> conta = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Conta> getConta() {
		return conta;
	}
	public void setConta(List<Conta> conta) {
		this.conta = conta;
	}
	
	public void contasCadastradas() {
		System.out.println("As contas cadastradas são: ");
		for (Conta contas : conta) {
			System.out.println(contas);
		}
	}
}
