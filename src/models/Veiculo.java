package models;

import java.math.BigDecimal;

public class Veiculo {
	
	private BigDecimal consumoEtanol;
	private BigDecimal consumoGasolina;
	private int capacidadeTanque;
	private String placa;
	private String modelo;
	

	public Veiculo(String modelo, BigDecimal consumoEtanol, BigDecimal consumoGasolina, int capacidadeTanque, String placa) {
	
		this.consumoEtanol = consumoEtanol;
		this.consumoGasolina = consumoGasolina;
		this.capacidadeTanque = capacidadeTanque;
		this.modelo = modelo;
		this.placa = placa;
		
	}
	
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public BigDecimal getConsumoEtanol() {
		return consumoEtanol;
	}
	public BigDecimal getConsumoGasolina() {
		return consumoGasolina;
	}
	public double getCapacidadeTanque() {
		return capacidadeTanque;
	}
	public String getPlaca() {
		return placa;
	}
	
	public String getModelo() {
		return modelo;
	}
	

}
