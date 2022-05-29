package whitebox;

import org.junit.Test;
import junit.framework.TestCase;
import model.whitebox.*;

public class ApostaTestes extends TestCase {
	
	Partida partida = null;
	@Override
	protected void setUp() throws Exception {
		String nomeDoCampeonato = "Campeonato XPTO 2";
		String NomeDoTimeVisitante = "Time Visitante 3";
		String NomeDoTimeMandante = "Time Mandante 5";
		partida = new Partida();
		partida.setCampeonato(nomeDoCampeonato);
		partida.setTimeMandante(NomeDoTimeMandante);
		partida.setTimeVisitante(NomeDoTimeVisitante);
		partida.liberarApostas();
	}
	
	/*
	 5) Uma aposta somente pode ser feita por um usu�rio cadastrado e com moedas suficientes para
	 pagar o custo da aposta. O apostador deve definir um n�mero de gols tanto para o time visitante
	 como para o mandante.

	 */
	@Test
	public void testDadoUmUsuarioCadastradoEComMoedasSuficientesDeveSerPossivelDefinirUmNumeroDeGols() {
		//Arrange
		String cpf = "01234567890"; 
		String email = "caio@teste.com.br";
		String senha = "#12345";
		int numeroDeGolsVisitante = 1;
		int numeroDeGolsMandante = 2;
		Usuario usr = null;
		try {
			usr = new Usuario(email, cpf, senha);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Act
		Aposta aposta = new Aposta();
		aposta.setPartida(partida);
		aposta.setApostador(usr);
		aposta.setGolsMandate(numeroDeGolsMandante);
		aposta.setGolsVisitante(numeroDeGolsVisitante);
		Boolean fazerAposta = false;
		try {
			fazerAposta = aposta.enviar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Assert
		assertTrue(fazerAposta);
	}
	
	@Test
	public void testDadoUmUsuarioCadastradoEComMoedasSuficientesNaoDeveSerPossivelFazerUmaApostaSemONumeroDeGolsDoMandante() {
		//Arrange
		String cpf = "01234567890"; 
		String email = "caio@teste.com.br";
		String senha = "#12345";
		int numeroDeGolsVisitante = 1;
		int numeroDeGolsMandante = 2;
		Usuario usr = null;
		try {
			usr = new Usuario(email, cpf, senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Act
		Aposta aposta = new Aposta();
		aposta.setPartida(partida);
		aposta.setApostador(usr);
		aposta.setGolsVisitante(numeroDeGolsVisitante);
		
		Boolean fazerAposta = false;
		try {
			fazerAposta = !aposta.enviar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Assert
		assertFalse(fazerAposta);
		
	}
	
	@Test
	public void testDadoUmUsuarioCadastradoEComMoedasSuficientesNaoDeveSerPossivelFazerUmaApostaSemONumeroDeGolsDoVisitante() {
		//Arrange
		String cpf = "01234567890"; 
		String email = "caio@teste.com.br";
		String senha = "#12345";
		int numeroDeGolsVisitante = 1;
		int numeroDeGolsMandante = 2;
		Usuario usr = null;
		try {
			usr = new Usuario(email, cpf, senha);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Act
		Aposta aposta = new Aposta();
		aposta.setPartida(partida);
		aposta.setApostador(usr);
		aposta.setGolsMandate(numeroDeGolsMandante);
		Boolean fazerAposta = false;
		try {
			fazerAposta = !aposta.enviar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Assert
		assertFalse(fazerAposta);
	}
	
	
	//6) O custo da aposta � de 50 moedas.
	@Test
	public void testDadoUmaApostaValidaSeuCustoDeveSer50Moedas()
	{
		//Arrange
		String cpf = "01234567890"; 
		String email = "caio@teste.com.br";
		String senha = "#12345";
		int numeroDeGolsVisitante = 1;
		int numeroDeGolsMandante = 2;
		float valorPadraoPorAposta = 50;
		Usuario usr = null;
		try {
			usr = new Usuario(email, cpf, senha);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Aposta aposta = new Aposta();
		aposta.setPartida(partida);
		aposta.setApostador(usr);
		aposta.setGolsMandate(numeroDeGolsMandante);
		aposta.setGolsVisitante(numeroDeGolsVisitante);
		float valorMoedaUsuarioAntesApostar = usr.getMoedas();
		
		//Act
		try {
			aposta.enviar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		float valorMoedasUsuarioAposApostar = usr.getMoedas();
		
		//Assert
		assertEquals(valorPadraoPorAposta, valorMoedaUsuarioAntesApostar - valorMoedasUsuarioAposApostar);
	}
	
	/*
	7) O sistema deve permitir uma aposta quando:
		a) A partida estiver liberada para receber apostas;
		b) O usu�rio tem moedas suficiente para apostar;
		c) A quantidade de gols visitantes e mandantes deve ser maior ou igual que 0;
	 * */
	
	@Test
	public void testDadoUmaPartidaLiberadaParaReceberApostaUmUsuarioComMoedasSuficientesEAquantidadeDeGolsMaiorOuIgualAZeroDeveSerPossivelEfetuarUmaAposta()
	{
		//Arrange
		String cpf = "01234567890"; 
		String email = "caio@teste.com.br";
		String senha = "#12345";
		int numeroDeGolsVisitante = 1;
		int numeroDeGolsMandante = 1;
		Usuario usr = null;
		try {
			usr = new Usuario(email, cpf, senha);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Aposta aposta = new Aposta();
		aposta.setPartida(partida);
		aposta.setApostador(usr);
		aposta.setGolsMandate(numeroDeGolsMandante);
		aposta.setGolsVisitante(numeroDeGolsVisitante);
		
		//Act
		Boolean fazerAposta = false;
		try {
			fazerAposta = aposta.enviar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Assert
		assertTrue(fazerAposta);
	}
	
	

}
