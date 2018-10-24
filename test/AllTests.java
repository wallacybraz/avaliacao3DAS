package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TesteCadastroDeClientes.class, TesteEncerramentoCorrida.class, TesteSolicitacaoCorrida.class })
public class AllTests {

}
