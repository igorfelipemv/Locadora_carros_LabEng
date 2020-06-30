package br.com.locadora.carros.model;

public class Veiculo {
	private Long id;
	private String marca;
	private String modelo;
	private String anoModelo;
	private String anoFabricacao;
	private String placa;
	private String cor;
	private double valorDiaria;
	
	public Veiculo() {
		
	}
	
	public Veiculo(String marca, String modelo, String anoModelo, String anoFabricacao, String placa, String cor, double valorDiaria) {
		this.marca = marca;
		this.modelo = modelo;
		this.anoModelo = anoModelo;
		this.anoFabricacao = anoFabricacao;
		this.placa = placa;
		this.cor = cor;
		this.valorDiaria = valorDiaria;
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
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getAnoModelo() {
		return anoModelo;
	}
	
	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}
	
	public String getAnoFabricacao() {
		return anoFabricacao;
	}
	
	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public double getValorDiaria() {
		return valorDiaria;
	}
	
	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
}
