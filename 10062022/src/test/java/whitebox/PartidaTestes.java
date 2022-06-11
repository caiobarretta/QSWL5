package whitebox;

import org.junit.Test;
import junit.framework.TestCase;
import model.whitebox.*;

public class PartidaTestes extends TestCase  {
	
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
	}

	//3) Uma partida é definida pelo nome do campeonato, nome do time visitante e nome do time
	//mandante. 
	@Test
	public void testDadoUmNomeDeCampeonatoTimeVisitanteETimeMandanteValidosAPartidaDeveSerDefinida() {
		//Arrange
		String nomeDoCampeonato = "Campeonato XPTO 2";
		String NomeDoTimeVisitante = "Time Visitante 3";
		String NomeDoTimeMandante = "Time Mandante 5";
		
		//Act
		Partida partida = new Partida();
		partida.setCampeonato(nomeDoCampeonato);
		try {
			partida.setTimeMandante(NomeDoTimeMandante);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			partida.setTimeVisitante(NomeDoTimeVisitante);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Assert
		assertNotNull(partida);
	}
	
	//3) Uma partida é definida pelo nome do campeonato, nome do time visitante e nome do time
	// mandante. Quando a partida é criada, as apostas estão bloqueadas.
	@Test
	public void testDadoAPartidaValidaQuandoCriadaAsApostasDevemEstarBloqueadas() {
		//Arrange
		String nomeDoCampeonato = "Campeonato XPTO 2";
		String NomeDoTimeVisitante = "Time Visitante 3";
		String NomeDoTimeMandante = "Time Mandante 5";
		Partida partida = new Partida();
		partida.setCampeonato(nomeDoCampeonato);
		try {
			partida.setTimeMandante(NomeDoTimeMandante);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			partida.setTimeVisitante(NomeDoTimeVisitante);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Act
		Boolean estaDisponivelReceberApostas = partida.estaDisponivelReceberApostas();
		//Assert
		assertTrue(!estaDisponivelReceberApostas);
	}
	
	//3) Uma partida é definida pelo nome do campeonato, nome do time visitante e nome do time
	// mandante. Quando a partida é criada, as apostas estão bloqueadas.
		@Test
		public void testDadoAPartidaInvalidaQuandoCriadaDeveLancarUmErroCasoONomeDoTimeVisitanteSejaVazio() {
			//Arrange
			String nomeDoCampeonato = "Campeonato XPTO 2";
			String NomeDoTimeVisitante = "";
			String NomeDoTimeMandante = "Time Mandante 5";
			Partida partida = new Partida();
			String erro = "";
			partida.setCampeonato(nomeDoCampeonato);
			try {
				partida.setTimeMandante(NomeDoTimeMandante);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//Act
			try {
				partida.setTimeVisitante(NomeDoTimeVisitante);
			} catch (Exception e) {
				erro = e.getMessage();
			}
			//Assert
			assertEquals("Nome do time visitante inválido.", erro);
		}
		
		//3) Uma partida é definida pelo nome do campeonato, nome do time visitante e nome do time
		// mandante. Quando a partida é criada, as apostas estão bloqueadas.
			@Test
			public void testDadoAPartidaInvalidaQuandoCriadaDeveLancarUmErroCasoONomeDoTimeMandanteSejaVazio() {
				//Arrange
				String nomeDoCampeonato = "Campeonato XPTO 2";
				String NomeDoTimeVisitante = "Time Visitante";
				String NomeDoTimeMandante = "";
				Partida partida = new Partida();
				String erro = "";
				partida.setCampeonato(nomeDoCampeonato);
				try {
					partida.setTimeMandante(NomeDoTimeMandante);
				} catch (Exception e) {
					erro = e.getMessage();
				}
				
				//Act
				try {
					partida.setTimeVisitante(NomeDoTimeVisitante);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//Assert
				assertEquals("Nome do time mandante inválido.", erro);
			}
	
	//4) Uma partida somente pode receber apostas depois de esta ser liberada.
	@Test
	public void testDadosUmaPartidaLiberadaDeveReceberApostas() {
		//Arrange
		partida.liberarApostas();
		
		//Act
		String statusPartida = partida.getStatus();
		
		//Assert
		assertEquals("apostas_abertas", statusPartida);
	}
	
}
