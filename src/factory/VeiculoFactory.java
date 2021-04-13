package factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Veiculo;

public class VeiculoFactory {

	
	public void createVeiculo(HashMap<String, List<String>> dadosModelo, HashMap<String, String> dadosVeiculo){
//		
		 for (@SuppressWarnings("rawtypes") Map.Entry me : dadosVeiculo.entrySet()) {
			 
			 List<String> caracteristicas = dadosModelo.get(me.getKey());
			 String modelo = (String) me.getKey();
			 Float consumoEtanol = Float.valueOf(caracteristicas.get(1).replace(',', '.'));
			 System.out.println(consumoEtanol);
			 Float consumoGasolina = Float.valueOf(caracteristicas.get(2).replace(',', '.'));
			 Double capacidadeTanque = Double.valueOf(caracteristicas.get(3));
			 
			 
			 Veiculo veiculo = new Veiculo(modelo, consumoEtanol, consumoGasolina, capacidadeTanque);
			 System.out.println(veiculo);
			 
		 }
//		
	}
}
