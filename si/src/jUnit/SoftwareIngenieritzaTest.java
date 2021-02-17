package jUnit;

import nagusi.Entregagarri;
import nagusi.Ikasle;
import nagusi.SoftwareIngenieritza;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SoftwareIngenieritzaTest {

    SoftwareIngenieritza si = SoftwareIngenieritza.getSoftwareIngenieritza();

    Ikasle ikElemBakarra=new Ikasle("iraide","zabala","a@ezer.kk","Sestao");
    Ikasle ikHutsa=new Ikasle("Gonzalo","Gonzalez","ad@ad.ad","Portuñordo");
    Ikasle ikAskoHutsa=new Ikasle("ez","dakit","zer gehiago","jarri");
    Ikasle ikBeteaHutsa=new Ikasle("Homer","simpson","homer@nuclear.sp","springfield");

    Entregagarri entregagarriHutsa=new Entregagarri("penkatuko dizuet berdin berdin.");
    Entregagarri entregagarriBetea=new Entregagarri("Josuk 3 sagar baditu eta Nereak 2 kentzen badizkio. Kalkulatu Lurraren distantzia Neptunorekiko.");


    @BeforeEach
    void setUp() {
    }


    @Test
    void gainditutakoakLortu() {
        List<Ikasle> lista=new ArrayList<>();
        assertEquals(lista.size(),si.gainditutakoakLortu().size()); //lista hutsa denean

        //gainditu
        ikElemBakarra.setNota(7.5);
        entregagarriBetea.setNota(8.0);
        ikElemBakarra.addEntregagarri(entregagarriBetea);

        //penkatu
        ikHutsa.setNota(3.0);

        si.addIkasle(ikElemBakarra);
        si.addIkasle(ikHutsa);

        assertEquals(1,si.gainditutakoakLortu().size());
        
    }
}