public class Entregagarri {

	private String enunciado;
	private String url;
	private double nota;
	
	public Entregagarri(String pEnunciado){
		enunciado = pEnunciado;
	}
	
	public double getNota(){
		return nota;
	}
	
	public void setNota(double pNota){
		nota = pNota;
	}
	
	public void setUrl(String pUrl){
		url = pUrl;
	}
	
	
}