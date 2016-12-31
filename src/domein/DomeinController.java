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

    private Speler bieke; // 5
    private Speler marianne; // 10
    private Speler brian; // 6
    private Speler robin; // 2
    private List<Vraag> vragenRonde2;
    private List<Vraag> vragenRonde4;
    private List<Vraag> finaleVragen;
    
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
    
    public List<Vraag> getVragenRonde4()
    {
        maakVragenRonde4();
        return vragenRonde4;
    }
    
    public List<Vraag> getFinaleVragen()
    {
        maakFinaleVragen();
        return finaleVragen;
    };
    
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
        antwoorden.add("Onderbroek");
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
    
    public void maakVragenRonde4()
    {
        vragenRonde4 = new ArrayList<>();
        List<String> antwoorden1 = new ArrayList<>();
        antwoorden1.add("Geert Bourgois");
        antwoorden1.add("NVA");
        antwoorden1.add("Minister-President");
        antwoorden1.add("Vlaanderen");
        Vraag vraag1 = new Vraag("C:\\Users\\Dylan\\Documents\\NetBeansProjects\\Quiz\\src\\assets\\1.jpg", antwoorden1);
        List<String> antwoorden2 = new ArrayList<>();
        antwoorden2.add("Vrijheidsbeeld");
        antwoorden2.add("New York");
        antwoorden2.add("Frankrijk");
        antwoorden2.add("1886");
        Vraag vraag2 = new Vraag("C:\\Users\\Dylan\\Documents\\NetBeansProjects\\Quiz\\src\\assets\\2.jpg", antwoorden2);
        List<String> antwoorden3 = new ArrayList<>();
        antwoorden3.add("Nafissatou Thiam");
        antwoorden3.add("Meerkamp");
        antwoorden3.add("Olympische Spelen");
        antwoorden3.add("Goud");
        Vraag vraag3 = new Vraag("C:\\Users\\Dylan\\Documents\\NetBeansProjects\\Quiz\\src\\assets\\3.jpg", antwoorden3);
        List<String> antwoorden4 = new ArrayList<>();
        antwoorden4.add("Mathieu Terryn");
        antwoorden4.add("Bazart");
        antwoorden4.add("Goud");
        antwoorden4.add("Chaos");
        Vraag vraag4 = new Vraag("C:\\Users\\Dylan\\Documents\\NetBeansProjects\\Quiz\\src\\assets\\4.jpg", antwoorden4);
        this.vragenRonde4.add(vraag1);
        this.vragenRonde4.add(vraag2);
        this.vragenRonde4.add(vraag3);
        this.vragenRonde4.add(vraag4);
    }

    public ArrayList<Speler> bepaalFinalisten()
    {
        ArrayList<Speler> spelers = new ArrayList<>();
        Speler finalist1 = new Speler(" ");
        finalist1.setScore(0);
        Speler finalist2 = new Speler(" ");
        finalist2.setScore(0);
        
        for(Speler s : getSpelers())
        {
            if (s.getScore() > finalist2.getScore() && s.getScore() < finalist1.getScore())
                finalist2 = s;
            else if(s.getScore() > finalist1.getScore())
            {
                finalist2 = finalist1;
                finalist1 = s;
            }

        }
        spelers.add(finalist1);
        spelers.add(finalist2);
        return spelers;
    }
    
    public void maakFinaleVragen()
    {
        finaleVragen = new ArrayList<>();
        List<String> antwoorden1 = new ArrayList<>();
        antwoorden1.add("Radiomaker");
        antwoorden1.add("MNM");
        antwoorden1.add("Marathonradio");
        antwoorden1.add("Miguel Wiels");
        antwoorden1.add("Peter Live");
        Vraag vraag1 = new Vraag("Wat weet je over Peter Van de Veire?", antwoorden1);
        List<String> antwoorden2 = new ArrayList<>();
        antwoorden2.add("Burgemeester");
        antwoorden2.add("Schepen");
        antwoorden2.add("Voorzitter");
        antwoorden2.add("Gemeenteraadsleden");
        antwoorden2.add("Oppositie");
        Vraag vraag2 = new Vraag("Welke mensen maken deel uit van een gemeenteraad?", antwoorden2);
        List<String> antwoorden3 = new ArrayList<>();
        antwoorden3.add("2");
        antwoorden3.add("3");
        antwoorden3.add("4");
        antwoorden3.add("5");
        antwoorden3.add("6");
        Vraag vraag3 = new Vraag("Welke vlakken van een dobbelsteen zijn zichtbaar als je 6 gooit?", antwoorden3);
        List<String> antwoorden4 = new ArrayList<>();
        antwoorden4.add("Fabian");
        antwoorden4.add("Zwitser");
        antwoorden4.add("Wielrenner");
        antwoorden4.add("Spartacus");
        antwoorden4.add("Tijdrijder");
        Vraag vraag4 = new Vraag("Wat weet je over de man met de naam Cancellara?", antwoorden4);
        List<String> antwoorden5 = new ArrayList<>();
        antwoorden5.add("Winston");
        antwoorden5.add("Brit");
        antwoorden5.add("Nobelprijs");
        antwoorden5.add("Wereldoorlog 2");
        antwoorden5.add("Sigaar");
        Vraag vraag5 = new Vraag("Wat weet je over Churchill?", antwoorden5);
        List<String> antwoorden6 = new ArrayList<>();
        antwoorden6.add("Thermometer");
        antwoorden6.add("Barometer");
        antwoorden6.add("Anemometer");
        antwoorden6.add("Pluviometer");
        antwoorden6.add("Windzak");
        Vraag vraag6 = new Vraag("Met welke toestellen wordt het weer gemeten?", antwoorden6);
        List<String> antwoorden7 = new ArrayList<>();
        antwoorden7.add("Moeten ");
        antwoorden7.add("Mannen");
        antwoorden7.add("Met");
        antwoorden7.add("Baarden");
        antwoorden7.add("Zijn");
        Vraag vraag7= new Vraag("Vul woord per woord aan. Al die willen te kaap'ren varen, ...", antwoorden7);
        List<String> antwoorden8 = new ArrayList<>();
        antwoorden8.add("Europa");
        antwoorden8.add("Voetbaltoernooi");
        antwoorden8.add("UEFA");
        antwoorden8.add("Real Madrid");
        antwoorden8.add("Atletico Madrid");
        Vraag vraag8 = new Vraag("Wat weet je over de Champions League?", antwoorden8);
        List<String> antwoorden9 = new ArrayList<>();
        antwoorden9.add("Deciliter");
        antwoorden9.add("Liter");
        antwoorden9.add("Decaliter");
        antwoorden9.add("Hectoliter");
        antwoorden9.add("Kiloliter");
        Vraag vraag9 = new Vraag("Wat zijn de vijf volgende inhoudsmaten: milliliter, centiliter, ...", antwoorden9);
        List<String> antwoorden10 = new ArrayList<>();
        antwoorden10.add("USA");
        antwoorden10.add("China");
        antwoorden10.add("Japan");
        antwoorden10.add("Duitsland");
        antwoorden10.add("UK");
        Vraag vraag10 = new Vraag("Welke landen hebben de grootste economieën ter wereld?", antwoorden10);
        List<String> antwoorden11 = new ArrayList<>();
        antwoorden11.add("Merlijn");
        antwoorden11.add("Lancelot");
        antwoorden11.add("Excalibur");
        antwoorden11.add("Camelot");
        antwoorden11.add("Ronde Tafel");
        Vraag vraag11 = new Vraag("Films en boeken, maar wat weet je verder nog over Koning Arthur?", antwoorden11);
        List<String> antwoorden12 = new ArrayList<>();
        antwoorden12.add("Amerikaanse");
        antwoorden12.add("President");
        antwoorden12.add("Baard");
        antwoorden12.add("Vermoord");
        antwoorden12.add("Mount Rushmore");
        Vraag vraag12 = new Vraag("Wat weet je over Abraham Lincoln?", antwoorden12);
        List<String> antwoorden13 = new ArrayList<>();
        antwoorden13.add("Lancia");
        antwoorden13.add("Land Rover");
        antwoorden13.add("Lexus");
        antwoorden13.add("Lotus");
        antwoorden13.add("Lamborghini");
        Vraag vraag13 = new Vraag("Wat zijn de 5 bekendste automerken met de letter 'L'", antwoorden13);
        List<String> antwoorden14 = new ArrayList<>();
        antwoorden14.add("Zwaartekracht");
        antwoorden14.add("Appel");
        antwoorden14.add("Brits");
        antwoorden14.add("Eenheid");
        antwoorden14.add("Natuurkundige");
        Vraag vraag14 = new Vraag("Wat weet je over Sir Isaac Newton?", antwoorden14);
        List<String> antwoorden15 = new ArrayList<>();
        antwoorden15.add("De Panne");
        antwoorden15.add("Studio 100");
        antwoorden15.add("Pretpark");
        antwoorden15.add("Plopsa Coo");
        antwoorden15.add("Meli");
        Vraag vraag15 = new Vraag("Wat weet je over Plopsaland?", antwoorden15);
        
        this.finaleVragen.add(vraag1);
        this.finaleVragen.add(vraag2);
        this.finaleVragen.add(vraag3);
        this.finaleVragen.add(vraag4);
        this.finaleVragen.add(vraag5);
        this.finaleVragen.add(vraag6);
        this.finaleVragen.add(vraag7);
        this.finaleVragen.add(vraag8);
        this.finaleVragen.add(vraag9);
        this.finaleVragen.add(vraag10);
        this.finaleVragen.add(vraag11);
        this.finaleVragen.add(vraag12);
        this.finaleVragen.add(vraag13);
        this.finaleVragen.add(vraag14);
        this.finaleVragen.add(vraag15);
    }
    
}
