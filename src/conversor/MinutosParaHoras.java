package conversor;

public class MinutosParaHoras {
	
	private float minutos;
	
	public MinutosParaHoras(float minutos) {
		this.minutos = minutos;
	}
	
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
