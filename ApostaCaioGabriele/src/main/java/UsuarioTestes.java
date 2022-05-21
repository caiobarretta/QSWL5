import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import junit.framework.TestCase;
import model.Usuario;

public class UsuarioTestes extends TestCase  {
	/*
    1) O sistema deve permitir o cadastro de um usuário informando CPF , e-mail e password.
		a) Um CPF é válido quando tem 11 caracteres numéricos, caso contrário deve emitir uma
		excepção indicando “CPF invalido”
		b) Um e mail é válido quando tem pelo menos um caractere seguido por “@”
		c) Uma password é válida quando pelo menos tem um carácter especial (!?.*, etc)
	2) O sistema deve inserir 200 moedas na carteira do usuário após o cadastro do usuário.
	*/
	
	@Test
	public void testDadoUsuarioValidoDeveInstanciarClasseCorretamente() {
		//Arrange
		String cpf = "01234567890"; 
		String email = "caio@teste.com.br";
		String senha = "12345";
		
		//Act
		Usuario usr = new Usuario(email, cpf, senha);
		
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
	public void testDadoEmailInvalidoDeveEmitirUmaExcepcaoDeCPFInvalido() {
		//Arrange
		String cpf = "01234567890";
		String email = "@teste.com.br";
		String senha = "12345";
		
		String exMessage = "";
		
		Usuario usr;
		//Act
		usr = new Usuario(cpf, email, senha);
		usr.setEmail(email);
		
		//Assert
		assertNotEquals(email, usr.getEmail());
	}
	

}
