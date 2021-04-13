package main;

import java.util.HashMap;
import java.util.List;

import CSV.CSVReaderModels;
import CSV.CSVReaderVeiculos;
import factory.VeiculoFactory;

public class Main {

	public static void main(String[] args) {
		CSVReaderVeiculos csv = new CSVReaderVeiculos();
		HashMap<String, String> dadosVeiculo = csv
				.readCSV("/home/talthur/eclipse-workspace/gas-station/src/resources/veiculos.csv");

		CSVReaderModels csvv = new CSVReaderModels();
		HashMap<String, List<String>> dadosModelo = csvv
				.readCSV("/home/talthur/eclipse-workspace/gas-station/src/resources/modelos.csv");

		VeiculoFactory vf = new VeiculoFactory();
		vf.createVeiculo(dadosModelo, dadosVeiculo);
	}
}
