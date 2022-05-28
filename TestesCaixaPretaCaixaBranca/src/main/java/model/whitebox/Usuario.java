package model.whitebox;

import java.math.BigInteger;

public class Usuario {
		
		private String email;
		private String cpf;
		private String password;
		private float moedas;
		
		
		public Usuario() {
			super();
			this.moedas = 200f;
		}

		public Usuario(String email, String cpf, String password) throws Exception {
			super();
			this.email = email;
			this.cpf = cpf;
			this.password = password;
			this.moedas = 200f;
			
			this.ValidaEmail();
			this.ValidaCPF();
			this.ValidaSenha();
		}

		public String getEmail() {
			return email;
		}
		public void setEmail(String email) throws Exception {
			this.email = email;
			this.ValidaEmail();
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) throws Exception {
			this.cpf = cpf;
			this.ValidaCPF();
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) throws Exception {
			this.password = password;
			this.ValidaSenha();
		}
		
		public boolean temSaldoSuficiente() {
			return this.moedas > Aposta.CUSTO_APOSTA;
		}

		public float getMoedas() {
			return this.moedas;
		}

		public void diminuirMoedas() {
			this.moedas = this.moedas - Aposta.CUSTO_APOSTA;
		}
		
		public void ValidaEmail() throws Exception {
			//validação simples
			//o email tem que ter @
			if(!this.email.contains("@")) {
				throw new Exception("Email inválido");
			}
			
		}
		
		public void ValidaCPF() throws Exception{
			//a) Um CPF é válido quando tem 11 caracteres numéricos, caso contrário deve emitir uma excepção indicando “CPF invalido”
			String mensagemDeErro = "CPF invalido";
			if(this.cpf.length() != 11) {
				throw new Exception(mensagemDeErro);
			}
			try {
			//Integer.valueOf(this.cpf);
			new BigInteger(this.cpf);
			} catch (Exception e) {
				throw new Exception(mensagemDeErro);
			}
		}
		
		public void ValidaSenha() throws Exception{
			String replacedString = this.password.replaceAll("[^A-Za-z0-9]", "");
			if(replacedString == this.password) {
				throw new Exception("Senha Invalida");
			}
		}
	
	}



