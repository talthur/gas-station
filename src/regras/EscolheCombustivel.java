package regras;

import java.math.BigDecimal;
import java.math.RoundingMode;

import models.Bomba;
import models.Veiculo;


/**
 * Classe responsável por escolher qual o combustivel ideal para cada veículo
 * @author talthur
 * @version 1.00
 */
public class EscolheCombustivel {
	
	
	/**
	 * Método que retorna quantos reais são necessários para encher o tanque de um Véiculo(Objeto)
	 * @param capacidadeTanque
	 * @param precoDoLitro
	 * @return BigDecimal
	 */
	public BigDecimal quantosReaisParaEncherOTanque(double capacidadeTanque, BigDecimal precoDoLitro) {

		BigDecimal capacidadeTanqueBD = new BigDecimal(capacidadeTanque);
		return capacidadeTanqueBD.multiply(precoDoLitro);

	}

	/**
	 * Metodo que retorna quantos KMs é possível rodar com um tanque cheio
	 * @param capacidadeTanque
	 * @param consumo
	 * @return BigDecimal
	 */
	public BigDecimal quantosKMporTanque(double capacidadeTanque, BigDecimal consumo) {
		BigDecimal capacidadeTanqueBD = new BigDecimal(capacidadeTanque);
		return capacidadeTanqueBD.multiply(consumo);
	}
	
	/**
	 * Método que retorna quanto sai o KM/Real para cada Veículo
	 * @param quantosKMporTanque
	 * @param quantosReaisParaEncherOTanque
	 * @return BigDecimal
	 */

	public BigDecimal razaoKmReal(BigDecimal quantosKMporTanque, BigDecimal quantosReaisParaEncherOTanque) {
				
		return quantosKMporTanque.divide(quantosReaisParaEncherOTanque,2, RoundingMode.HALF_UP);
	}

	
	/**
	 * Método que, a partir dos outros métodos, decide qual combústivel é melhor para o Veículo
	 * @param veiculo
	 * @param bombaGas
	 * @param bombaAlcool
	 * @return
	 */
	public Bomba isGasOrAlcool(Veiculo veiculo, Bomba bombaGas, Bomba bombaAlcool) {

		BigDecimal quantosReaisParaEncherOTanqueAlcool = quantosReaisParaEncherOTanque(veiculo.getCapacidadeTanque(),
				bombaAlcool.getPrecoDoLitro());

		BigDecimal quantosKMporTanqueAlcool = quantosKMporTanque(veiculo.getCapacidadeTanque(),
				veiculo.getConsumoEtanol());

		BigDecimal razaoKmRealAlcool = razaoKmReal(quantosKMporTanqueAlcool, quantosReaisParaEncherOTanqueAlcool);

		BigDecimal quantosReaisParaEncherOTanqueGas = quantosReaisParaEncherOTanque(veiculo.getCapacidadeTanque(),
				bombaGas.getPrecoDoLitro());

		BigDecimal quantosKMporTanqueGas = quantosKMporTanque(veiculo.getCapacidadeTanque(),
				veiculo.getConsumoGasolina());

		BigDecimal razaoKmRealGas = razaoKmReal(quantosKMporTanqueGas, quantosReaisParaEncherOTanqueGas);
		
		
		BigDecimal zero = new BigDecimal(0);
		
		if (razaoKmRealAlcool.compareTo(zero) == 0) {
			return bombaGas;
		}
		
		if (razaoKmRealGas.compareTo(zero) == 0) {
			return bombaAlcool;
		}

		if (razaoKmRealGas.compareTo(razaoKmRealAlcool) > 0) {
			return bombaAlcool;

		} else {
			return bombaGas;
		}

	}

}
