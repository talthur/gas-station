package main;

import CSV.CSVReaderModels;
import CSV.CSVReaderVeiculos;

public class Main {
	
	public static void main(String[] args) {
		CSVReaderModels csv = new CSVReaderModels();
		csv.readCSV("/home/talthur/eclipse-workspace/gas-station/src/resources/modelos.csv");
		
		CSVReaderVeiculos csvv = new CSVReaderVeiculos();
		csvv.readCSV("/home/talthur/eclipse-workspace/gas-station/src/resources/veiculos.csv");
	}
	
	

}
