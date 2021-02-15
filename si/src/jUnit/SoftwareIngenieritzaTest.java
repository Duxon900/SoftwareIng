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

        ikElemBakarra.setNota(7.5);
        ikHutsa.setNota(3.0);
        //lista.add()
        
    }

    @Test
    void gainditutakoakIzenezOrdenatutaLortu() {
    }

    @Test
    void gainditutakoakIzenezAbizenezOrdenatutaLortu() {
    }

    @Test
    void gaindituenPortzentaiaLortu() {
    }

    @Test
    void herrialdeakLortu() {
    }

    @Test
    void entregagarriGuztiakGainditutakoakLortu() {
    }

    @Test
    void entregagarrianNotaGainditzenDutenIkasleakLortu() {
    }

    @Test
    void ikasleenEstatiskikakInprimatu() {
    }

    @Test
    void gaindituakSuspendituakLortu() {
    }

    @Test
    void ikasleakHerrialdekaLortu() {
    }

    @Test
    void batazbestekoNotakHerrialdekaLortu() {
    }

    @Test
    void notaMaximodunIkasleaHerrialdekaLortu() {
    }

    @Test
    void notaMaximoaHerrialdekaLortu() {
    }
}