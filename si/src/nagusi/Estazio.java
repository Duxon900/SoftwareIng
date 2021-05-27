package nagusi;

public class Estazio {
	
	private String hiri;
	private float kostu;
	
	public Estazio(String pHiri, float pKostu)
	{
		this.hiri = pHiri;
		this.kostu = pKostu;
	}
	
	public float getKostu()
	{
		return kostu;
	}
	public String getHiri()
	{
		return hiri;
	}
	
	public boolean hiriaDa(String phiri)
	{
		return hiri.equals(phiri);
	}

}
