package br.com.locadora.carros.model;

import java.util.Date;

public class Locacao {
	private Long id;
	private Veiculo veiculo;
	private Cliente cliente;
	private Date dataLocacao;
	private Date dataDevolucao;
	private String metodoDePagamento;
	private double valorTotal;
	
	public Locacao() {
		
	}
	
	public Locacao(Veiculo veiculo, Cliente cliente, Date dataLocacao, Date dataDevolucao, String metodoDePagamento, double valorTotal) {
		this.veiculo = veiculo;
		this.cliente = cliente;
		this.dataLocacao = dataLocacao;
		this.dataDevolucao = dataDevolucao;
		this.metodoDePagamento = metodoDePagamento;
		this.valorTotal = valorTotal;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Date getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getMetodoDePagamento() {
		return metodoDePagamento;
	}

	public void setMetodoDePagamento(String metodoDePagamento) {
		this.metodoDePagamento = metodoDePagamento;
	}


	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
