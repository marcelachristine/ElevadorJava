package aula01;

public class Elevador {

	private int idElevador;
	private String status;
	private int limitePessoas;
	private int pessoasTransportadas;
	
	public Elevador (int codigo, int limite)	{
	    
		this.idElevador = codigo;
		this.pessoasTransportadas = 0;
		this.status = "Em opera��o";
		this.limitePessoas = limite;
		
	}
		
	public int getIdElevador() {
		return idElevador;
	}

	public String getStatus() {
		return status;
	}

	public int getLimitePessoas() {
		return limitePessoas;
	}
		
	public void setLimitePessoas(int limitePessoas) {
		this.limitePessoas = limitePessoas;
	}

	public int getPessoasTransportadas() {
		return pessoasTransportadas;
	}

	public void setPessoasTransportadas(int pessoasTransportadas) {
		this.pessoasTransportadas = pessoasTransportadas;
	}


	void registrarEntrada(int qtdeEntrada) {
		this.pessoasTransportadas += qtdeEntrada;
		if (this.pessoasTransportadas>this.limitePessoas) {
			this.status = "Bloqueado";
		}
	}

	void registrarSaida(int qtdeSaida) {
		this.pessoasTransportadas -= qtdeSaida;
		if (this.pessoasTransportadas<=this.limitePessoas) {
			this.status = "Em opera��o";
		}
	}		
}
	

