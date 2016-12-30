/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Dylan
 */
public class DomeinController
{

    private Speler bieke;
    private Speler marianne;
    private Speler brian;
    private Speler robin;
    private List<Vraag> vragenRonde2;
    
    public void maakSpelers()
    {
        bieke = new Speler("Bieke");
        marianne = new Speler("Marianne");
        brian = new Speler("Brian");
        robin = new Speler("Robin");
    }

    public List<Vraag> getVragenRonde2()
    {
        maakVragenRonde2();
        return vragenRonde2;
    }
    
    public ArrayList<Speler> getSpelers()
    {
        ArrayList<Speler> spelersLijst = new ArrayList<>();
        spelersLijst.add(bieke);
        spelersLijst.add(marianne);
        spelersLijst.add(brian);
        spelersLijst.add(robin);
        return spelersLijst;
    }
    
    public Speler getSpeler(String naam)
    {
        ArrayList<Speler> spelersLijst = getSpelers();
        for(Speler speler : spelersLijst)
        {
            if(speler.getName().toLowerCase().equals(naam.toLowerCase()))
                return speler;
        }
        return null;
    }
    
    public void maakVragenRonde2()
    {
        vragenRonde2 = new ArrayList<>();
        List<String> antwoorden1 = new ArrayList<>();
        antwoorden1.add("gsm");
        antwoorden1.add("kledij");
        antwoorden1.add("computer");
        antwoorden1.add("geld");
        Vraag vraag1 = new Vraag("Wat zijn de objecten die men het vaakst verliest op de tram?", antwoorden1);
        List<String> antwoorden2 = new ArrayList<>();
        antwoorden2.add("April");
        antwoorden2.add("Juni");
        antwoorden2.add("September");
        antwoorden2.add("November");
        Vraag vraag2 = new Vraag("Welke 4 maanden tellen exact 30 dagen?", antwoorden2);
        List<String> antwoorden3 = new ArrayList<>();
        antwoorden3.add("1969");
        antwoorden3.add("Apollo 11");
        antwoorden3.add("One small step");
        antwoorden3.add("Neil Armstrong");
        Vraag vraag3 = new Vraag("Wat weet je over de eerste maanlanding?", antwoorden3);
        List<String> antwoorden4 = new ArrayList<>();
        antwoorden4.add("Brugge");
        antwoorden4.add("Kortrijk");
        antwoorden4.add("Oostende");
        antwoorden4.add("Roeselare");
        Vraag vraag4 = new Vraag("Wat zijn de vier grootste steden van West-Vlaanderen?", antwoorden4);
        this.vragenRonde2.add(vraag1);
        this.vragenRonde2.add(vraag2);
        this.vragenRonde2.add(vraag3);
        this.vragenRonde2.add(vraag4);
        
    }
    
    public Puzzel puzzel1()
    {
        List<String> antwoorden = new ArrayList<>();
        List<String> stukjes = new ArrayList<>();
        antwoorden.add("Tequilla");
        antwoorden.add("Hoofdsteden");
        antwoorden.add("Usain Bolt");
        stukjes.add("Mexicaans");
        stukjes.add("Citroen");
        stukjes.add("Zout");
        stukjes.add("Sunrise");
        stukjes.add("Brussel");
        stukjes.add("Londen");
        stukjes.add("Amsterdam");
        stukjes.add("Parijs");
        stukjes.add("100 meter");
        stukjes.add("9.63 seconden");
        stukjes.add("Jamaica");
        stukjes.add("Sprinter");
        return new Puzzel(antwoorden, stukjes);
        
    }
    
    public Puzzel puzzel2()
    {
        List<String> antwoorden = new ArrayList<>();
        List<String> stukjes = new ArrayList<>();
        antwoorden.add("Verzamelen");
        antwoorden.add("Tourette");
        antwoorden.add("De drie biggetjes");
        stukjes.add("Suikerzakjes");
        stukjes.add("Munten");
        stukjes.add("Postzegels");
        stukjes.add("Sigarenbandjes");
        stukjes.add("Tic");
        stukjes.add("Lul!");
        stukjes.add("Syndroom");
        stukjes.add("Eikel!");
        stukjes.add("Sprookje");
        stukjes.add("Stro");
        stukjes.add("Steen");
        stukjes.add("Hout");
        return new Puzzel(antwoorden, stukjes);
    }
    
    public Puzzel puzzel3()
    {
        List<String> antwoorden = new ArrayList<>();
        List<String> stukjes = new ArrayList<>();
        antwoorden.add("Totempaal");
        antwoorden.add("Netanyahu");
        antwoorden.add("Braadworst");
        stukjes.add("Indianen");
        stukjes.add("Boomstam");
        stukjes.add("Vastbinden");
        stukjes.add("Versieringen");
        stukjes.add("Premier");
        stukjes.add("Israël");
        stukjes.add("Benjamin");
        stukjes.add("Likoed");
        stukjes.add("Worst");
        stukjes.add("Mosterd");
        stukjes.add("Zuurkool");
        stukjes.add("Ketchup");
        return new Puzzel(antwoorden, stukjes);
    }
    
    public Puzzel puzzel4()
    {
        List<String> antwoorden = new ArrayList<>();
        List<String> stukjes = new ArrayList<>();
        antwoorden.add("Braadworst");
        antwoorden.add("Middenstand");
        antwoorden.add("Jan");
        stukjes.add("Boxershort");
        stukjes.add("Slip");
        stukjes.add("String");
        stukjes.add("Tanga");
        stukjes.add("Sociale klasse");
        stukjes.add("Geen arbeiders");
        stukjes.add("Regeert het land");
        stukjes.add("Kleine zelfstandigen");
        stukjes.add("Hoet");
        stukjes.add("Met de pet");
        stukjes.add("Modaal");
        stukjes.add("Zonder Vrees");
        return new Puzzel(antwoorden, stukjes);
    }
    
}
