package models;

import java.math.BigDecimal;

public class Bomba {
	
	private String tipoCombustivel;
	private BigDecimal precoDoLitro;
	private static double totalDeLitros;
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

	public static double getTotalDeLitros() {
		return totalDeLitros;
	}

	public static void setTotalDeLitros(double totalDeLitros) {
		Bomba.totalDeLitros = totalDeLitros;
	}

	public int getLitrosPorMinuto() {
		return litrosPorMinuto;
	}

	public void setLitrosPorMinuto(int litrosPorMinuto) {
		this.litrosPorMinuto = litrosPorMinuto;
	}

}
