
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class SoftwareIngenieritza {
	
	private static SoftwareIngenieritza nSoftwareIngenieritza;
	private List<Ikasle> matrikulatuZerr = new ArrayList<>();
	
	private SoftwareIngenieritza(){}
	
	public static SoftwareIngenieritza getSoftwareIngenieritza()
	{
		if(nSoftwareIngenieritza==null){
			nSoftwareIngenieritza = new SoftwareIngenieritza();
		}
		return nSoftwareIngenieritza;
	}
	
	public void addIkasle(Ikasle pIk)
	{
		matrikulatuZerr.add(pIk);
	}
	
	private Iterator<Ikasle> getIterator()
	{
		return matrikulatuZerr.iterator();
	}	
	
	////////////////////////////JAVA8////////////////////////////////
	

	public void notaTotalakErakutsi(){
		//TODO  5. ariketa
	}
	
	public List<Ikasle> gainditutakoakLortu(){
		//TODO  6. ariketa
	}

	public List<Ikasle> gainditutakoakIzenezOrdenatutaLortu(){
		//TODO  7. ariketa
	}

	public List<Ikasle> gainditutakoakIzenezAbizenezOrdenatutaLortu(){
		//TODO  8. ariketa
	}
	
	public double gaindituenPortzentaiaLortu(){
		//TODO  9. ariketa
	}

	public List<String> herrialdeakLortu(){
		//TODO  10. ariketa
	}
	

	public List<Ikasle> entregagarriGuztiakGainditutakoakLortu(){
		//TODO  11. ariketa	
	}
	
	public List<Ikasle> entregagarrianNotaGainditzenDutenIkasleakLortu(double pNota){
		//TODO  12. ariketa
	}

	public void ikasleenEstatiskikakInprimatu() {
		//TODO  13. ariketa
	}
	
	public Map<Boolean,List<Ikasle>> gaindituakSuspendituakLortu(){
		//TODO  14. ariketa
	}
	
	public Map<String,List<Ikasle>> ikasleakHerrialdekaLortu(){
		//TODO  15. ariketa
	}

	public Map<String,Double> batazbestekoNotakHerrialdekaLortu(){
		//TODO  16. ariketa
	}

	public Map<String,Ikasle> notaMaximodunIkasleaHerrialdekaLortu(){
		//TODO  17. ariketa
	}
	
	public Map<String,Double> notaMaximoaHerrialdekaLortu(){
		//TODO  18. ariketa			
	}
}
