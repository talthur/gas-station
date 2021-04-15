package regras;

import java.math.BigDecimal;
import java.math.RoundingMode;

import models.Bomba;
import models.Veiculo;

public class EscolheCombustivel {

	public BigDecimal quantosReaisParaEncherOTanque(double capacidadeTanque, BigDecimal precoDoLitro) {

		BigDecimal capacidadeTanqueBD = new BigDecimal(capacidadeTanque);
		return capacidadeTanqueBD.multiply(precoDoLitro);

	}

	public BigDecimal quantosKMporTanque(double capacidadeTanque, BigDecimal consumo) {
		BigDecimal capacidadeTanqueBD = new BigDecimal(capacidadeTanque);
		return capacidadeTanqueBD.multiply(consumo);
	}

	public BigDecimal razaoKmReal(BigDecimal quantosKMporTanque, BigDecimal quantosReaisParaEncherOTanque) {
		
		System.out.println(quantosKMporTanque.divide(quantosReaisParaEncherOTanque,2, RoundingMode.HALF_UP));
		
		return quantosKMporTanque.divide(quantosReaisParaEncherOTanque,2, RoundingMode.HALF_UP);
	}

	public String isGasOrAlcool(Veiculo veiculo, Bomba bombaGas, Bomba bombaAlcool) {

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
			return "Gasolina";
		}
		
		if (razaoKmRealGas.compareTo(zero) == 0) {
			return "Alcool";
		}

		if (razaoKmRealGas.compareTo(razaoKmRealAlcool) > 0) {
			return "Alcool";

		} else {
			return "Gasolina";
		}

	}

}
