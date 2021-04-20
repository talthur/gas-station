package main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import CSV.CSVReaderModels;
import CSV.CSVReaderVeiculos;
import conversor.MinutosParaHoras;
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
		Bomba bombaAlcool = new Bomba("Alcool",precoAlcool, 12);
		
		VeiculoFactory vf = new VeiculoFactory();
		ArrayList<Veiculo> arrayVeiculo = vf.createVeiculo(dadosModelo, dadosVeiculo);
		EscolheCombustivel escolheCombustivel = new EscolheCombustivel();
		for (Veiculo veiculo : arrayVeiculo) {
			Bomba bomba = escolheCombustivel.isGasOrAlcool(veiculo, bombaGas, bombaAlcool);
			
			float tempoDeAbastecimento = bomba.quantoTempoDeAbastecimento((int) veiculo.getCapacidadeTanque(), bomba.getLitrosPorMinuto());
			
			MinutosParaHoras minutosParaHora = new MinutosParaHoras(tempoDeAbastecimento);
			String tempoDeAbastecimentoEmHoras =
			 minutosParaHora.transforma();
			
			
			System.out.println("[" + tempoDeAbastecimentoEmHoras + "]" + " Veiculo " + veiculo.getModelo() + ",Placa: " + veiculo.getPlaca() + " foi abastecido com: " + veiculo.getCapacidadeTanque() + " litros de " + bomba.getTipoCombustivel());
			bomba.guardaTotalDeLitros(veiculo.getCapacidadeTanque());
			System.out.println("-----------");
			
		}
		System.out.println("Resumo da simulação");
		System.out.println("----------");
		System.out.println("Total abastecido da bomba de Alcool: " + bombaAlcool.getTotalDeLitros());
		System.out.println("Total abastecido da bomba de Gasolina: " + bombaGas.getTotalDeLitros());
		System.out.println("Informações adicionais:");
		System.out.println("Valor do litro de gasolina: " + bombaGas.getPrecoDoLitro().floatValue());
		System.out.println("Valor do litro de alcool: " + bombaAlcool.getPrecoDoLitro().floatValue());
		System.out.println("Velocidade de abastecimento da bomba de Gasolina: " + bombaGas.getLitrosPorMinuto());
		System.out.println("Velocidade de abastecimento da bomba de Alcool: " + bombaAlcool.getLitrosPorMinuto());
	}
}
