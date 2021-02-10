package nagusi;

import java.util.ArrayList;
import java.util.List;

public class Ikasle {

	private String izen;
	private String abizen;
	private String eposta;
	private double azterketaNota;
	private String herrialde;
	private List<Entregagarri> entregagarriZerr = new ArrayList<Entregagarri>() ;

	public Ikasle(String pIzen, String pAbizen, String pEposta,  String pHerrialde)
	{
		izen = pIzen;
		abizen = pAbizen;
		eposta = pEposta;
		herrialde = pHerrialde;
		
	}
	/////GETTERRAK//////
	
	public String getIzen(){return izen;}
	public String getAbizen(){return abizen;}
	public String getHerrialde(){return herrialde;}
	
	///////////////////	
	
	public void addEntregagarri(Entregagarri pEnt){
		entregagarriZerr.add(pEnt);
	}
	
	public void setNota(double pNota) {
		azterketaNota = pNota;
	}
	
	public String toString(){
		return "Izen-abizenak: " + izen + " " + abizen + ", eposta: " + eposta; 
	}
	
	////////////////////////////JAVA8////////////////////////////////	
	

	public boolean gaindituDu() {
		return notaFinalaKalkulatu() >= 5.0;
	}
	 
	public double entregagarrienNotaKalkulatu(){
		return entregagarriZerr.stream() //sekuentzialki analizatu
				.mapToDouble(Entregagarri::getNota) //elementu bakoitzeko
				.average() //guztien batez bestekoa atera
				.orElse(0.0); //hutsik balego 0.0 balioz ordezkatu
	}
	
	public double notaFinalaKalkulatu(){
		double entreEmaitza=entregagarrienNotaKalkulatu()*0.4;
		return entreEmaitza+azterketaNota*0.6;
	}
	
	public boolean entregagarriGuztiakGaindituDitu(){
		return entregagarriZerr.stream().allMatch(elem->elem.getNota()>=5.0);
	}
	
	
	public boolean entregagarrietakoBatekNotaGaindituDu(double pNota){
		return entregagarriZerr.stream().anyMatch(elem->elem.getNota()>=pNota);
	}
}
