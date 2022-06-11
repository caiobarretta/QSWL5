package whitebox;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import junit.framework.TestCase;
import model.whitebox.*;

public class UsuarioTestes extends TestCase  {
	/*
    1) O sistema deve permitir o cadastro de um usuário informando CPF , e-mail e password.
		a) Um CPF é válido quando tem 11 caracteres numéricos, caso contrário deve emitir uma excepção indicando “CPF invalido”
		b) Um e mail é válido quando tem pelo menos um caractere seguido por “@”
		c) Uma password é válida quando pelo menos tem um carácter especial (!?.*, etc)
	*/
	
	@Test
	public void testDadoUsuarioValidoDeveInstanciarClasseCorretamente() {
		//Arrange
		String cpf = "01234567890"; 
		String email = "caio@teste.com.br";
		String senha = "#12345";
		
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
		String senha = "#12345";
		
		String exMessage = "";
		
		Usuario usr;
		//Act
		try {
			usr = new Usuario(email, cpf, senha);
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
		String senha = "#12345";
		
		String exMessage = "";
		
		Usuario usr;
		//Act
		try {
			usr = new Usuario(email, cpf, senha);
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
		String senha = "#12345";
		
		String exMessage = "";
		
		Usuario usr;
		//Act
		try {
			usr = new Usuario(email, cpf, senha);
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
		String cpf = "40012345651";
		String email = "@teste.com.br";
		String senha = "#12345";
		String erroEmail = "";
		
		//Act
		Usuario usr = null;
		try {
			usr = new Usuario(cpf, email, senha);
			usr.setEmail(email);
		} catch (Exception e) {
			erroEmail = e.getMessage();
		}
		
		//Assert
		assertEquals(erroEmail, "Email inválido");
	}
	
	//2) O sistema deve inserir 200 moedas na carteira do usuário após o cadastro do usuário
	@Test
	public void testDadoUmUsuarioValidoDeveConterInicialmenteDuzentasMoedas() {
		//Arrange
		String cpf = "40012345651"; 
		String email = "caio@teste.com.br";
		String senha = "#12345";
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
		String cpf = "40012345651"; 
		String email = "caio@teste.com.br";
		String senha = "#12345";
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
		String cpf = "40012345651"; 
		String email = "caio@teste.com.br";
		String senha = "#12345";
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
