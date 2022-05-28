package blackbox;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import junit.framework.TestCase;
import model.Usuario;

public class UsuarioTestes extends TestCase  {
	/*
    1) O sistema deve permitir o cadastro de um usuÃ¡rio informando CPF , e-mail e password.
		a) Um CPF Ã© vÃ¡lido quando tem 11 caracteres numÃ©ricos, caso contrÃ¡rio deve emitir uma
		excepÃ§Ã£o indicando â€œCPF invalidoâ€�
		b) Um e mail Ã© vÃ¡lido quando tem pelo menos um caractere seguido por â€œ@â€�
		c) Uma password Ã© vÃ¡lida quando pelo menos tem um carÃ¡cter especial (!?.*, etc)
	*/
	
	@Test
	public void testDadoUsuarioValidoDeveInstanciarClasseCorretamente() {
		//Arrange
		String cpf = "01234567890"; 
		String email = "caio@teste.com.br";
		String senha = "12345";
		
		//Act
		try {
			Usuario usr = new Usuario(email, cpf, senha);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assert(false);
		}
		
		//Assert
		assert(true);
	}
	
	@Test
	public void testDadoCPFNumericoMenorQueOnzeInvalidoDeveEmitirUmaExcepcaoDeCPFInvalido() {
		//Arrange
		String cpf = "01234567"; 
		String email = "caio@teste.com.br";
		String senha = "12345";
		
		String exMessage = "";
		
		Usuario usr;
		//Act
		try {
			usr = new Usuario(cpf, email, senha);
			usr.setCpf(cpf);
		}
		catch(Exception ex) {
			exMessage = ex.getMessage();
		}
		
		//Assert
		assertEquals("CPF invalido", exMessage);
	}
	
	@Test
	public void testDadoCPFNumericoMaiorQueOnzeInvalidoDeveEmitirUmaExcepcaoDeCPFInvalido() {
		//Arrange
		String cpf = "0123456798274579459237478294875827592347592347594"; 
		String email = "caio@teste.com.br";
		String senha = "12345";
		
		String exMessage = "";
		
		Usuario usr;
		//Act
		try {
			usr = new Usuario(cpf, email, senha);
			usr.setCpf(cpf);
		}
		catch(Exception ex) {
			exMessage = ex.getMessage();
		}
		
		//Assert
		assertEquals("CPF invalido", exMessage);
	}

	@Test
	public void testDadoCPFInvalidoDeveEmitirUmaExcepcaoDeCPFInvalido() {
		//Arrange
		String cpf = "abcdefghijkl"; 
		String email = "caio@teste.com.br";
		String senha = "12345";
		
		String exMessage = "";
		
		Usuario usr;
		//Act
		try {
			usr = new Usuario(cpf, email, senha);
			usr.setCpf(cpf);
		}
		catch(Exception ex) {
			exMessage = ex.getMessage();
		}
		
		//Assert
		assertEquals("CPF invalido", exMessage);
	}

	@Test
	public void testDadoEmailInvalidoDeveEmitirUmaExcepcaoDeEmailInvalido() {
		//Arrange
		String cpf = "01234567890";
		String email = "@teste.com.br";
		String senha = "12345";
		
		//Act
		Usuario usr = null;
		try {
			usr = new Usuario(cpf, email, senha);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			usr.setEmail(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Assert
		assertNotEquals(email, usr.getEmail());
	}
	
	//2) O sistema deve inserir 200 moedas na carteira do usuÃ¡rio apÃ³s o cadastro do usuÃ¡rio.
	@Test
	public void testDadoUmUsuarioValidoDeveConterInicialmenteDuzentasMoedas() {
		//Arrange
		String cpf = "01234567890"; 
		String email = "caio@teste.com.br";
		String senha = "12345";
		float moedas = 200;
		
		//Act
		Usuario usr = null;
		try {
			usr = new Usuario(email, cpf, senha);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Assert
		assertEquals(usr.getMoedas(), moedas);
	}
	
	@Test
	public void testDadoUmUsuarioValidoNaoDeveConterInicialmenteMaisQueDuzentasMoedas() {
		//Arrange
		String cpf = "01234567890"; 
		String email = "caio@teste.com.br";
		String senha = "12345";
		float moedas = 201;
		
		//Act
		Usuario usr = null;
		try {
			usr = new Usuario(email, cpf, senha);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Assert
		assertNotEquals(usr.getMoedas(), moedas);
	}
	
	@Test
	public void testDadoUmUsuarioValidoNaoDeveConterInicialmenteMenosQueDuzentasMoedas() {
		//Arrange
		String cpf = "01234567890"; 
		String email = "caio@teste.com.br";
		String senha = "12345";
		float moedas = 199;
		
		//Act
		Usuario usr = null;
		try {
			usr = new Usuario(email, cpf, senha);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Assert
		assertNotEquals(usr.getMoedas(), moedas);
	}
	
	@Test
	public void testDadosUmPasswordInvalidoDeveEmitirUmaExcepcao()
	{
		//Arrange
		String cpf = "40012345651"; 
		String email = "caio@teste.com.br";
		String senha = "12345";
		float moedas = 199;
		String erroSenha = "";
		//Act
		Usuario usr = null;
		try {
			usr = new Usuario(email, cpf, senha);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			erroSenha = e.getMessage();
		}
		
		//Assert
		assertNotEquals("", erroSenha);
	}
	
}
