package models;

import java.math.BigDecimal;

/**
 * Classe para objetos do tipo <b>Bomba</b>, contendo seus atributos e métodos
 * @author talthur
 * @version 1.00
 */

public class Bomba {
	
	private String tipoCombustivel;
	private BigDecimal precoDoLitro;
	private double totalDeLitros;
	private int litrosPorMinuto;
	
	public Bomba(String tipoCombustivel, BigDecimal precoDoLitro, int litrosPorMinuto) {
		this.tipoCombustivel = tipoCombustivel;
		this.precoDoLitro = precoDoLitro;
		this.litrosPorMinuto = litrosPorMinuto;
	}

	public String getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public BigDecimal getPrecoDoLitro() {
		return precoDoLitro;
	}

	public void setPrecoDoLitro(BigDecimal precoDoLitro) {
		this.precoDoLitro = precoDoLitro;
	}

	public double getTotalDeLitros() {
		return totalDeLitros;
	}

	public void setTotalDeLitros(double totalDeLitros) {
		this.totalDeLitros = totalDeLitros;
	}

	public int getLitrosPorMinuto() {
		return litrosPorMinuto;
	}

	public void setLitrosPorMinuto(int litrosPorMinuto) {
		this.litrosPorMinuto = litrosPorMinuto;
	}
	
	/**
	 * 
	 * Método que retorna quanto tempo é necessário para o abastecimento em um Veículo(Objeto)
	 * @param capacidadeDoTanque
	 * @param litrosPorMinuto
	 * @return float - tempoDeAbastecimento
	 */
	public float quantoTempoDeAbastecimento(int capacidadeDoTanque, int litrosPorMinuto) {
		 float tempoDeAbastecimento = capacidadeDoTanque / litrosPorMinuto;
		 return tempoDeAbastecimento;
	}
	
	/**
	 * Método que retorna quantos reais são necessários para encher o tanque de um Veículo(objeto)
	 * @param capacidadeDoTanque
	 * @param precoDoLitro
	 * @return BigDecimal valor
	 */
	public BigDecimal valorParaEncherOTanque(int capacidadeDoTanque, BigDecimal precoDoLitro){
		BigDecimal capacidadeDoTanqueBD = new BigDecimal(capacidadeDoTanque);
		BigDecimal valor = capacidadeDoTanqueBD.multiply(precoDoLitro);
		return valor;
	}
	
	/**
	 * Método que incrementa atributo totalDeLitros, conforme capacidade do tanque
	 * @param capacidadeDoTanque
	 */
	public void guardaTotalDeLitros(double capacidadeDoTanque) {
		double totalParcial = getTotalDeLitros();
		totalParcial += capacidadeDoTanque;
		setTotalDeLitros(totalParcial);
	}

}
