package br.com.fiap.sprint4bigodes.model;

public class Bicicleta {
	
	private Long id;
	private String marca;
	private String numeroSerie;
	private String modelo;
	private boolean roubada;

	public Bicicleta(Long id, String marca, String numeroSerie, String modelo, boolean roubada) {
		super();
		this.id = id;
		this.marca = marca;
		this.numeroSerie = numeroSerie;
		this.modelo = modelo;
		this.roubada = roubada;
	}

	public Bicicleta() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public boolean isRoubada() {
		return roubada;
	}

	public void setRoubada(boolean roubada) {
		this.roubada = roubada;
	}

}
