package nagusi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class OfertaKatalogoa {

	private static OfertaKatalogoa nOK = new OfertaKatalogoa();
	private List<Oferta> ofertakol = new ArrayList<Oferta>();
	
	private OfertaKatalogoa(){};
	
	public static OfertaKatalogoa getOK()
	{
		return nOK;
	}
	
	
	public void addOferta(Oferta o)
	{
		ofertakol.add(o);
	}
	
	//1 ariketa
	public void printHelburuPosibleak(String pJat) {
		ofertakol.stream()
				.filter(p->p.jatorriaDa(pJat))
				.map(Oferta::getHelburu)
				.forEach(System.out::println);
	}
	
	//2 ariketa
	public void printHelburuPosibleak2(String pOrigen) {
		ofertakol.stream()
				.filter(p->p.jatorriaDa(pOrigen))
				.map(Oferta::getHelburu)
				.distinct()
				.forEach(System.out::println);
	}
	
	//3 ariketa
	public List<Oferta> getJatorrizOrdenatutakoOfertak() {
		return ofertakol.stream()
				.sorted(comparing(Oferta::getJatorri))
				.collect(toList());

	}
	
	//4 ariketa
	public List<Oferta> getJatorrizHelburuzOrdenatutakoOfertak() {
		return ofertakol.stream()
				.sorted(comparing(Oferta::getJatorri)
						.thenComparing(Oferta::getHelburu)
				)
				.collect(toList());

	}
	
	//5 ariketa	
	public List<Oferta> getEstaziodunOfertak(String pHiri)
	{
		return ofertakol.stream()
				.filter(p->p.helburuaDa(pHiri))
				.filter(p->p.estazioakKontatu()>=1)
				.collect(toList());
	}
	
	//6 ariketa
	public void printOfertakJatorriHelburu(String pJat, String pHel){
		ofertakBilatu(pJat,pHel).stream()
				.sorted(comparing(Oferta::kalkKostu))
				.forEach(Oferta::toString);
	}

	private List<Oferta> ofertakBilatu(String pJat, String pHel) {
		return ofertakol.stream()
				.filter(p->(p.jatorriaDa(pJat) && p.helburuaDa(pHel)))
				.collect(toList());
	}

	//7 ariketa
	public Map<String,Oferta> getOfertaMinEstazioJatorri() {
		return ofertakol.stream()
				.collect(
						groupingBy(Oferta::getJatorri,collectingAndThen(
								minBy(comparing(Oferta::estazioakKontatu)),
								p->p.get()
						))
				);
	}
	
	//8 ariketa
	public Map<String,Integer> getMinEstazioJatorri() {
		return ofertakol.stream()
				.collect(
						groupingBy(Oferta::getJatorri,collectingAndThen(
								minBy(comparing(Oferta::estazioakKontatu)),
								p->p.get().estazioakKontatu()
						))
				);
	}
}
