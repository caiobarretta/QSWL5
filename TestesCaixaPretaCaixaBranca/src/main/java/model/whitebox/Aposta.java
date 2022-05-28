package model.whitebox;

public class Aposta {
	
public static final float CUSTO_APOSTA = 50f;
	
	private int golsVisitante;
	private int golsMandate;
	private Usuario apostador;
	private Partida partida;
	
	public Aposta() {
		super();
	}

	public int getGolsVisitante() {
		return golsVisitante;
	}

	public void setGolsVisitante(int golsVisitante) {
		this.golsVisitante = golsVisitante;
	}

	public int getGolsMandate() {
		return golsMandate;
	}

	public void setGolsMandate(int golsMandate) {
		this.golsMandate = golsMandate;
	}

	public Usuario getApostador() {
		return apostador;
	}

	public void setApostador(Usuario apostador) {
		this.apostador = apostador;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public boolean enviar() {		
		if(this.partida.estaDisponivelReceberApostas() && this.apostador.temSaldoSuficiente()) {
			return this.partida.enviarAposta(this);
		}
		return false;
	}
	

}
