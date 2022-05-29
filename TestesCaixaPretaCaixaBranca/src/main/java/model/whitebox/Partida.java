package model.whitebox;

import java.util.ArrayList;

public class Partida {
	
	private String campeonato;
	private String timeVisitante;
	private String timeMandante;
	private String status;
	
	private ArrayList<Aposta> apostas;
	
	public Partida() {
		super();
		this.status = "aposta_bloqueada";
		this.apostas = new ArrayList<Aposta>();
	}
	
	public String getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(String campeonato) {
		this.campeonato = campeonato;
	}
	public String getTimeVisitante() {
		return timeVisitante;
	}
	public void setTimeVisitante(String timeVisitante) {
		this.timeVisitante = timeVisitante;
	}
	public String getTimeMandante() {
		return timeMandante;
	}
	public void setTimeMandante(String timeMandante) {
		this.timeMandante = timeMandante;
	}
	public String getStatus() {
		return this.status;
	}

	public void liberarApostas() {
		this.status = "apostas_abertas";
	}

	public boolean estaDisponivelReceberApostas() {
		return this.status == "apostas_abertas";
	}

	public int getNumeroApostas() {
		return this.apostas.size();
	}

	public boolean enviarAposta(Aposta aposta) throws Exception {
		this.validaAposta(aposta);
		int apostas_anteriores = this.getNumeroApostas();
		this.apostas.add(aposta);
		aposta.getApostador().diminuirMoedas();
		return apostas_anteriores < this.getNumeroApostas();
	}
	//7) O sistema deve permitir uma aposta quando:
	public void validaAposta(Aposta aposta) throws Exception {
		String mensagemErro = "Aposta inválida";
		//a) A partida estiver liberada para receber apostas;
		if(!this.estaDisponivelReceberApostas())
			throw new Exception(mensagemErro);
		//b) O usuário tem moedas suficiente para apostar;
		if(!aposta.getApostador().temSaldoSuficiente())
			throw new Exception(mensagemErro);
		//c) A quantidade de gols visitantes e mandantes deve ser maior ou igual que 0;
		if(aposta.getGolsMandate() <= 0 || aposta.getGolsVisitante() <= 0)
			throw new Exception(mensagemErro);
	}

}
