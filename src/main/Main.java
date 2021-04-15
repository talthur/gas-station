package main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import CSV.CSVReaderModels;
import CSV.CSVReaderVeiculos;
import factory.VeiculoFactory;
import models.Bomba;
import models.Veiculo;
import regras.EscolheCombustivel;

public class Main {

	public static void main(String[] args) {
		CSVReaderVeiculos csv = new CSVReaderVeiculos();
		HashMap<String, String> dadosVeiculo = csv
				.readCSV("/home/talthur/eclipse-workspace/gas-station/src/resources/veiculos.csv");

		CSVReaderModels csvv = new CSVReaderModels();
		HashMap<String, List<String>> dadosModelo = csvv
				.readCSV("/home/talthur/eclipse-workspace/gas-station/src/resources/modelos.csv");

		BigDecimal precoGasolina = new BigDecimal(2.90);
		BigDecimal precoAlcool = new BigDecimal(2.27);
		
		Bomba bombaGas = new Bomba("Gasolina",precoGasolina, 10);
		Bomba bombaAlcool = new Bomba("ALcool",precoAlcool, 12);
		
		VeiculoFactory vf = new VeiculoFactory();
		ArrayList<Veiculo> arrayVeiculo = vf.createVeiculo(dadosModelo, dadosVeiculo);
		EscolheCombustivel escolheCombustivel = new EscolheCombustivel();
		for (Veiculo veiculo : arrayVeiculo) {
			String resposta = escolheCombustivel.isGasOrAlcool(veiculo, bombaGas, bombaAlcool);
			System.out.println(resposta);
		}
	}
}
