package nagusi;

import java.util.ArrayList;
import java.util.List;

public class Oferta {
	
	private List<Estazio> estazioKol = new ArrayList<Estazio>();
	
	private String jatorri;
	private String helburu;
	
	public Oferta(String pJat, String pHel)
	{
		this.jatorri = pJat;
		this.helburu = pHel;
	}
	
	public boolean jatorriaDa(String pJat)
	{
		return this.jatorri.equals(pJat);
	}
	
	public boolean helburuaDa(String pHel)
	{
		return this.helburu.equals(pHel);
	}
	
	public boolean jatorriaHelburuaDa(String pJat, String pHel)
	{
		return this.jatorri.equals(pJat) && this.helburu.equals(pHel);
	}
	
	public String toString()
	{
		return jatorri + "-" + helburu + " precio: " + kalkKostu();
	}
	public void addEstazio(Estazio e)
	{
		estazioKol.add(e);
	}
	public String getJatorriHelburu()
	{
		return jatorri+helburu;
	}
	
	public String getHelburu()
	{
		return this.helburu;
	}
	public String getJatorri()
	{
		return this.jatorri;
	}
	
	public float kalkKostu()
	{
		return (float) estazioKol.stream().
				mapToDouble(e->e.getKostu()).sum();
			
	}
	
	public boolean estazioaDu(String pHiri)
	{
		return estazioKol.stream().anyMatch(e->e.hiriaDa(pHiri));
	}
	
	public int estazioakKontatu()
	{
		return (int)estazioKol.stream().count();
	}
	
	
	
	

}
