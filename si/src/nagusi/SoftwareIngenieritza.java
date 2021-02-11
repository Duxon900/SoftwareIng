package nagusi;

import java.util.*;
import java.util.stream.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class SoftwareIngenieritza{
	
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
		matrikulatuZerr.forEach(elem-> System.out.println(elem.notaFinalaKalkulatu()));
	}
	
	public List<Ikasle> gainditutakoakLortu(){
		List<Ikasle> lista= matrikulatuZerr.stream().filter(elem->elem.notaFinalaKalkulatu()>=5.0).collect(toList());
		//toList()

		System.out.println(lista);

		return lista;
	}

	public List<Ikasle> gainditutakoakIzenezOrdenatutaLortu(){
		return matrikulatuZerr.stream() //sekuentzialki analizatu
				.filter(elem->elem.notaFinalaKalkulatu()>=5.0) //5.0 baino handiagoko notak sartu
				.sorted(Comparator.comparing(Ikasle::getIzen)) //izenaz ordenatu
				.collect(toList());
	}

	public List<Ikasle> gainditutakoakIzenezAbizenezOrdenatutaLortu(){
		return matrikulatuZerr.stream() //sekuentzialki analizatu
				.filter(elem->elem.notaFinalaKalkulatu()>=5.0) //5.0 baino handiagoko notak sartu
				.sorted(comparing(Ikasle::getIzen).thenComparing(Ikasle::getAbizen)) //izenaz ordenatu
				.collect(toList());
	}
	
	public double gaindituenPortzentaiaLortu(){
		long ema = matrikulatuZerr.stream()
				.filter(elem -> elem.notaFinalaKalkulatu() >= 5.0)
				.count();
		return (double) ema/matrikulatuZerr.size()*100;
	}

	public List<String> herrialdeakLortu(){
		return matrikulatuZerr.stream()
				.map(Ikasle::getHerrialde) //stringen fluxua lortu
				.distinct() //elementu bat bakoitzeko
				.collect(toList());
	}
	

	public List<Ikasle> entregagarriGuztiakGainditutakoakLortu(){
		return matrikulatuZerr.stream()
				.filter(Ikasle::entregagarriGuztiakGaindituDitu)
				.collect(toList());
	}
	
	public List<Ikasle> entregagarrianNotaGainditzenDutenIkasleakLortu(double pNota){
		return matrikulatuZerr.stream()
				.filter(elem->elem.entregagarrietakoBatekNotaGaindituDu(pNota))
				.collect(toList());
	}

	public void ikasleenEstatiskikakInprimatu() {
		DoubleSummaryStatistics doubleSummaryStatistics = matrikulatuZerr.stream()
				.mapToDouble(Ikasle::notaFinalaKalkulatu)
				.summaryStatistics();
		System.out.println(
				"{\"max\":"+doubleSummaryStatistics.getMax()+
				",\"min\":"+doubleSummaryStatistics.getMin()+
				",\"average\":"+doubleSummaryStatistics.getAverage()+"}"
		);
	}
	
	public Map<Boolean,List<Ikasle>> gaindituakSuspendituakLortu(){
		return matrikulatuZerr.stream()
				.collect(partitioningBy(Ikasle::gaindituDu)); //partitioningBy -> Map<Boolean, Object>
	}
	
	public Map<String,List<Ikasle>> ikasleakHerrialdekaLortu(){
		return matrikulatuZerr.stream()
				.collect(groupingBy(Ikasle::getHerrialde)); //String=Herrialdea

	}

	public Map<String,Double> batazbestekoNotakHerrialdekaLortu(){
		return matrikulatuZerr.stream()
				.collect(groupingBy(Ikasle::getHerrialde,
						Collectors.averagingDouble(Ikasle::notaFinalaKalkulatu))
				); //String=Herrialdea
	}

	public Map<String,Ikasle> notaMaximodunIkasleaHerrialdekaLortu(){
		return matrikulatuZerr.stream()
				.collect(groupingBy(Ikasle::getHerrialde,
						Collectors.collectingAndThen(
								maxBy(Comparator.comparing(Ikasle::notaFinalaKalkulatu)),
								elem->elem.isPresent()?elem.get() : new Ikasle("a","a","a","a") //ez badago elementurik a a a a datuko ikaslea sartuko da xdn't
						)
				));
	}
	
	public Map<String,Double> notaMaximoaHerrialdekaLortu(){
		return matrikulatuZerr.stream()
				.collect(groupingBy(Ikasle::getHerrialde,
						Collectors.collectingAndThen(
								maxBy(Comparator.comparing(Ikasle::notaFinalaKalkulatu)),
								elem->elem.isPresent()?elem.get().notaFinalaKalkulatu() : new Double(0.0)
						)
				));

	}

}
