package models;

public class Veiculo {
	
	public Veiculo(double consumoEtanol, double consumoGasolina, int capacidadeTanque, String placa) {
	
		this.consumoEtanol = consumoEtanol;
		this.consumoGasolina = consumoGasolina;
		this.capacidadeTanque = capacidadeTanque;
		this.placa = placa;
		
	}
	
	private double consumoEtanol;
	private double consumoGasolina;
	private int capacidadeTanque;
	private String placa;
	
	public double getConsumoEtanol() {
		return consumoEtanol;
	}
	public double getConsumoGasolina() {
		return consumoGasolina;
	}
	public int getCapacidadeTanque() {
		return capacidadeTanque;
	}
	public String getPlaca() {
		return placa;
	}
	

}
