package CSV;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CSVReaderVeiculos {
	
	String line = "";
	HashMap<String, String> map = new HashMap<String, String>();
	String[] values;
	
	public HashMap<String, String> readCSV(String path) {
		try {

			BufferedReader br = new BufferedReader(new FileReader(path));
			@SuppressWarnings("unused")
			String headerLine = br.readLine();
			while ((line = br.readLine()) != null) {
				values = line.split(";");
				map.put(values[0], values[1]);
			}

			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(map);
		return map;
	}
}