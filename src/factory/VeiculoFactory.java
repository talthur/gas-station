package factory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Veiculo;

public class VeiculoFactory {

	public ArrayList<Veiculo> createVeiculo(HashMap<String, List<String>> dadosModelo, HashMap<String, String> dadosVeiculo) {
//		
		ArrayList<Veiculo> arrayVeiculos = new ArrayList<Veiculo>();
		
		for (@SuppressWarnings("rawtypes")
		Map.Entry me : dadosVeiculo.entrySet()) {

			List<String> caracteristicas = dadosModelo.get(me.getKey());
			String modelo = (String) me.getKey();
			String placa = (String) me.getValue();
			
			
			String consumoEtanol = caracteristicas.get(0).replace(',', '.');
			String consumoGasolina = caracteristicas.get(1).replace(',', '.');
			BigDecimal bigDecimalConsumoEtanol = new BigDecimal(consumoEtanol);
			BigDecimal bigDecimalConsumoGasolina = new BigDecimal(consumoGasolina);
			
			int capacidadeTanque = Integer.valueOf(caracteristicas.get(2));
			arrayVeiculos.add(new Veiculo(modelo, bigDecimalConsumoEtanol, bigDecimalConsumoGasolina, capacidadeTanque, placa));

//			System.out.println(veiculo.getCapacidadeTanque());
//			System.out.println(veiculo.getConsumoEtanol());
//			System.out.println(veiculo.getModelo());
//			System.out.println(veiculo.getPlaca());

		}
//		
		return arrayVeiculos;
	}
}
