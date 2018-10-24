package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import Cadastros.Cliente;

@RunWith(Parameterized.class)
public class TesteCadastroDeClientes {

	@Parameters
	public static Collection<Object[]> getParameters() {
		Object parametros[][] = new Object[][] {
			{"Joao", "111.111.111-11", true},
			{"Maria", "222.222.222-22", true},
			{"Jose", "333.333.333-33", true},
			{"Joao", "111.111.111-11", false},
			{"Joao", "111.111.111-11", false},
		};
		return Arrays.asList(parametros);
	}

	private String nome;
	private String cpf;
	private boolean respostaEsperada;
	
	public TesteCadastroDeClientes(String nome, String cpf, boolean respostaEsperada) {
		this.nome = nome;
		this.cpf = cpf;
		this.respostaEsperada = respostaEsperada;
	}
	
	@Test
	public void testCadastroDeClientesUnico() {
		Cliente c = Cliente.obterCliente(nome, cpf);
		boolean resposta = Cliente.cadastrar(c);
		assertEquals(respostaEsperada, resposta);
	}

}
