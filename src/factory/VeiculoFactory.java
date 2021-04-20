package factory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Veiculo;


/**
 * Classe responsavel por produzir objetos do tipo Veículo, recebendo como parametro um HashMap previo. Retorna um Array de Veículos
 * @author talthur
 * @version 1.00
 */
public class VeiculoFactory {
	
	/**
	 * Método que lê um um HashMap com dados do CSV e cria os Objetos Veículos com seus atributos, retorna um ArrayList de Objetos Veiculos
	 * @param dadosModelo
	 * @param dadosVeiculo
	 * @return ArrayList de Veiculos arrayVeiculos
	 */
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

		}	
		return arrayVeiculos;
	}
}
