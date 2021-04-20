package conversor;


/**
 * Classe conversora de minutos para horas, retornando em String
 * @author talthur
 * @version 1.00
 */
public class MinutosParaHoras {
	
	private float minutos;
	
	public MinutosParaHoras(float minutos) {
		this.minutos = minutos;
	}
	
	
	
	/**
	 * Método que transforma valor passado no construtor da classe para horas.
	 * @return String horaFormatada
	 */
	public String transforma() {
		
		String horas = String.valueOf(Math.round(minutos/60));
		String minutosFinais = String.valueOf(Math.round(minutos%60));
		
		if (horas.length() < 2){
			horas = "0" + horas;
		}
		
		if (minutosFinais.length() < 2){
			minutosFinais = "0" + minutosFinais;
		}
		
		String horaFormatada = horas + ":" + minutosFinais;
		return horaFormatada;
		
		
	}
	
	public float getMinutos() {
		return minutos;
	}

	public void setMinutos(float minutos) {
		this.minutos = minutos;
	}

	
	
	

}
