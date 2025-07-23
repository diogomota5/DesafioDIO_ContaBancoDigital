package Main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {

	public String nome;
	public Date bithdate;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getBithdate() {
		return bithdate;
	}

	public void setBithdate(Date bithdate) {
		this.bithdate = bithdate;
	}	
	
	@Override
	public String toString() {
		return "Nome: "  + getNome() + " - Data de Nascimento: " + getBithdate();
	}
}