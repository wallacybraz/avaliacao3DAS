package Cadastros;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Cliente {

	private static List<Cliente> cadastroClientes = new LinkedList<Cliente>();
	private String nome;
	private String cpf;
	private Viagem viagem;

	private Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public static Cliente obterCliente(String nome, String cpf) {
		Cliente c = new Cliente (nome, cpf);
		return c;
	}

	public static boolean cadastrar(Cliente c) {
		Iterator<Cliente> it = cadastroClientes.iterator();
		boolean cadastrar = true;
		while (it.hasNext()) {
			Cliente t = it.next();
			if (t.getCPF().equals(c.getCPF())) 
				cadastrar = false;
		}
		
		boolean resposta;
		if (cadastrar)
			resposta = cadastroClientes.add(c);
		else 
			resposta = false;
		return resposta;
	}

	private String getCPF() {
		return cpf;
	}

	public static Cliente pesquisarCliente(String cpf) {
		Cliente resposta = null;
		Iterator<Cliente> it = cadastroClientes.iterator();
		while (it.hasNext()) {
			Cliente c = it.next();
			if (c.getCPF().equals(cpf)) {
				resposta = c;
				break;
			}
		}
		return resposta;
	}

	public Viagem iniciarViagem(int hora, int minutos) {
		if (viagem == null) 
			viagem = Viagem.obterViagem(hora, minutos);
		return viagem;
	}

	public Viagem encerrarViagem(int hora, int minutos) {
		Viagem resposta;
		if (viagem == null)
			resposta = null;
		else {
			viagem.encerrarViagem(hora, minutos);
			resposta = viagem;
		}
		return resposta;
	}

	public int getHoraTermino() {
		return viagem.getHoraTermino();
	}

	public int getMinutosTermino() {
		return viagem.getMinutosTermino();
	}

	public Viagem getViagem() {
		return viagem;
	}
}
