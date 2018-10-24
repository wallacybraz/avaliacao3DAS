package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Cadastros.Cliente;
import Cadastros.Viagem;

@RunWith(Parameterized.class)
public class TesteSolicitacaoCorrida {

	private String cpf;
	private int hora;
	private int minutos;
	private int horaEsperada;
	private int minutoEsperado;

	@Before
	public void setup() {
		Cliente[] clientes = {
				Cliente.obterCliente("Joao", "111.111.111-11"),
				Cliente.obterCliente("Maria", "222.222.222-22"),
				Cliente.obterCliente("Jose", "333.333.333-33")
		};
		
		for (Cliente c : clientes) 
			Cliente.cadastrar(c);
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[][] parametros = new Object[][] {
			{"111.111.111-11", 10, 00, 10, 00}, 
			{"222.222.222-22", 20, 30, 20, 30}, 
			{"333.333.333-33", 11, 25, 11, 25}, 
			{"222.222.222-22", 22, 00, 20, 30}, 
			{"222.222.222-22", 20, 00, 20, 30}, 
		};
		
		return Arrays.asList(parametros);
	}
	
	public TesteSolicitacaoCorrida(String cpf, 
			int hora, int minutos, int horaEsperada, 
			int minutoEsperado) {
		this.cpf = cpf;
		this.hora = hora;
		this.minutos = minutos;
		this.horaEsperada = horaEsperada;
		this.minutoEsperado = minutoEsperado;
	}
	
	@Test
	public void testIniciarCorrida() {
		Cliente c = Cliente.pesquisarCliente(cpf);
		assertNotNull(c);
		Viagem v = c.iniciarViagem(hora, minutos);
		assertNotNull(v); 
		assertEquals(horaEsperada, v.getHoraInicio());
		assertEquals(minutoEsperado, v.getMinutoInicio());
	}

}
