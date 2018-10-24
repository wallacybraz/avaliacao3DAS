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


@RunWith(Parameterized.class)
public class TesteEncerramentoCorrida {

	private Cliente cliente;
	private int horaTermino;
	private int minutosTermino;
	private int duracaoHorasEsperado;
	private int duracaoMinutosEsperado;
	private int duracaoTotalMinutos;

	@Parameters
	public static Collection<Object[]> getParameters() {
		Cliente[] clientes = new Cliente[] {
				Cliente.obterCliente("Joao", "111.111.111-11"),
				Cliente.obterCliente("Maria", "222.222.222-22"),
				Cliente.obterCliente("Jose", "333.333.333-33"),
				Cliente.obterCliente("Marcio", "444.444.444-44"),
		};
		clientes[0].iniciarViagem(10, 00);
		clientes[1].iniciarViagem(20, 30);
		clientes[2].iniciarViagem(11, 25);
		clientes[3].iniciarViagem(12, 00);
		
		
		Object[][] parametros = new Object[][] {
			{clientes[0], 10, 30, 0, 30, 30}, 
			{clientes[1], 22, 15, 1, 45, 105},
			{clientes[2], 11, 50, 0, 25, 25}, 
			{clientes[3], 14, 00, 2,  0, 120}, 
		};
		
		return Arrays.asList(parametros);
	}
	
	public TesteEncerramentoCorrida(Cliente c, int horaTermino, 
			int minutosTermino, int duracaoHorasEsperado, 
			int duracaoMinutosEsperado, int duracaoTotalMinutos) {
		this.cliente = c;
		this.horaTermino = horaTermino;
		this.minutosTermino = minutosTermino;
		this.duracaoHorasEsperado = duracaoHorasEsperado;
		this.duracaoMinutosEsperado = duracaoMinutosEsperado;
		this.duracaoTotalMinutos = duracaoTotalMinutos;
	}
	
	@Test
	public void testEncerrarCorrida() {
		cliente.encerrarViagem(horaTermino, minutosTermino);
		assertEquals(cliente.getHoraTermino(), horaTermino);
		assertEquals(cliente.getMinutosTermino(), minutosTermino);
		
		assertEquals(duracaoHorasEsperado, cliente.getViagem().getDuracaoHoras());
		assertEquals(duracaoMinutosEsperado, cliente.getViagem().getDuracaoMinutos());
		assertEquals(duracaoTotalMinutos, cliente.getViagem().getDuracaoTotalMinutos());
	}

}
