package CSV;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Classe responsável por ler arquivo de Modelos em CSV e retornar um HashMap com o resultado
 * @author talthur
 * @version 1.00
 */
public class CSVReaderModels {

	
	/**
	 * Método que lê arquivo CSV e retorna um HashMap.
	 * @param path
	 * @return HashMap map
	 */
	public HashMap<String, List<String>> readCSV(String path) {
		
		String line = "";
		ArrayList<String> ar = new ArrayList<String>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		String[] values;

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			@SuppressWarnings("unused")
			String headerLine = br.readLine();
			while((line = br.readLine()) != null) {
				values = line.split(";");
				ar.add(0, values[1]);
				ar.add(1, values[2]);
				ar.add(2, values[3]);
				map.put(values[0], ar);
				ar = new ArrayList<String>();
			}
			
			br.close();	
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
	}
}
