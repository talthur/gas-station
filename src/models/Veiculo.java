package models;

public class Veiculo {
	
	private float consumoEtanol;
	private float consumoGasolina;
	private double capacidadeTanque;
	private String placa;
	private String modelo;
	

	public Veiculo(String modelo, float consumoEtanol, float consumoGasolina, double capacidadeTanque) {
	
		this.consumoEtanol = consumoEtanol;
		this.consumoGasolina = consumoGasolina;
		this.capacidadeTanque = capacidadeTanque;
		this.modelo = modelo;
		
	}
	
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public double getConsumoEtanol() {
		return consumoEtanol;
	}
	public double getConsumoGasolina() {
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
