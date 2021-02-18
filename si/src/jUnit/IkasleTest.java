package jUnit;

import nagusi.Ikasle;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class IkasleTest {

    Ikasle ikElemBakarra=new Ikasle("iraide","zabala","a@ezer.kk","Sestao");
    Ikasle ikHutsa=new Ikasle("Gonzalo","Gonzalez","ad@ad.ad","Portuñordo");
    Ikasle ikAskoHutsa=new Ikasle("ez","dakit","zer gehiago","jarri");
    Ikasle ikBeteaHutsa=new Ikasle("Homer","simpson","homer@nuclear.sp","springfield");

    Entregagarri entregagarriHutsa=new Entregagarri("penkatuko dizuet berdin berdin.");
    Entregagarri entregagarriBetea=new Entregagarri("Josuk 3 sagar baditu eta Nereak 2 kentzen badizkio. Kalkulatu Lurraren distantzia Neptunorekiko.");

    @BeforeEach
    void setUp(){
        //Notak
        ikElemBakarra.setNota(3.0);
        ikHutsa.setNota(3.0);
        ikAskoHutsa.setNota(3.0);
        ikBeteaHutsa.setNota(3.0);

        //Entregagarriak
        entregagarriBetea.setNota(6.7);

        //sartu entregagarriak
        ikElemBakarra.addEntregagarri(entregagarriBetea);
        ikHutsa.addEntregagarri(entregagarriHutsa);

        ikAskoHutsa.addEntregagarri(entregagarriHutsa);
        ikAskoHutsa.addEntregagarri(entregagarriHutsa);
        ikAskoHutsa.addEntregagarri(entregagarriHutsa);
        ikAskoHutsa.addEntregagarri(entregagarriHutsa);

        ikBeteaHutsa.addEntregagarri(entregagarriHutsa);
        ikBeteaHutsa.addEntregagarri(entregagarriBetea);
        ikBeteaHutsa.addEntregagarri(entregagarriHutsa);
        ikBeteaHutsa.addEntregagarri(entregagarriBetea);
    }

    @org.junit.jupiter.api.Test
    void entregagarrienNotaKalkulatu() {
        assertEquals(0.0,ikHutsa.entregagarrienNotaKalkulatu());
        assertEquals(6.7,ikElemBakarra.entregagarrienNotaKalkulatu());

        assertEquals(0.0,ikAskoHutsa.entregagarrienNotaKalkulatu());
        assertEquals(3.35,ikBeteaHutsa.entregagarrienNotaKalkulatu());
    }

    @org.junit.jupiter.api.Test
    void notaFinalaKalkulatu() {
        /***
         * testa egiteko suposatuko da ez dela egongo balio nulurik, hau da
         * azterketaNota balioa beti double balio batekin egongo da kargaturik
         * Beraz, aurretiaz probatu denez metodoa, batuketa sinple baten proba izango litzateke
         */
    }

    @org.junit.jupiter.api.Test
    void entregagarriGuztiakGaindituDitu() {
        assertEquals(false,ikHutsa.entregagarriGuztiakGaindituDitu());
        assertEquals(true,ikElemBakarra.entregagarriGuztiakGaindituDitu());

        assertEquals(false,ikAskoHutsa.entregagarriGuztiakGaindituDitu());
        assertEquals(false,ikBeteaHutsa.entregagarriGuztiakGaindituDitu());
    }

    @org.junit.jupiter.api.Test
    void entregagarrietakoBatekNotaGaindituDu() {
        assertEquals(false,ikHutsa.entregagarrietakoBatekNotaGaindituDu(5.0));
        assertEquals(true,ikElemBakarra.entregagarrietakoBatekNotaGaindituDu(5.0));

        assertEquals(false,ikAskoHutsa.entregagarrietakoBatekNotaGaindituDu(4.0));
        assertEquals(true,ikBeteaHutsa.entregagarrietakoBatekNotaGaindituDu(2.0));
    }
}