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

	public boolean enviarAposta(Aposta aposta) {
		int apostas_anteriores = this.getNumeroApostas();
		this.apostas.add(aposta);
		aposta.getApostador().diminuirMoedas();
		return apostas_anteriores < this.getNumeroApostas();
	}

}
