/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Dylan
 */
public class Puzzel
{
    //4 stukjes - 3 antwoorden
    private HashMap<String, List<String>> antwoordenMap = new HashMap<>();
    private List<String> antwoorden;
    List<String> stukjesVoorEersteAntwoord = new ArrayList();
    List<String> stukjesVoorTweedeAntwoord = new ArrayList();
    List<String> stukjesVoorDerdeAntwoord = new ArrayList();

    public List<String> getStukjesVoorEersteAntwoord()
    {
        return stukjesVoorEersteAntwoord;
    }

    public List<String> getStukjesVoorTweedeAntwoord()
    {
        return stukjesVoorTweedeAntwoord;
    }

    public List<String> getStukjesVoorDerdeAntwoord()
    {
        return stukjesVoorDerdeAntwoord;
    }

    public Puzzel(List<String> antwoorden, List<String> stukjes)
    {
        
        this.antwoorden = antwoorden;
        for(int i = 0; i < 4; i++)
        {
            stukjesVoorEersteAntwoord.add(stukjes.get(i));
        }
        
        for(int i = 4; i < 8; i++)
        {
            stukjesVoorTweedeAntwoord.add(stukjes.get(i));
        }
        
        for(int i = 8; i < 12; i++)
        {
            stukjesVoorDerdeAntwoord.add(stukjes.get(i));
        }
        
        antwoordenMap.put(antwoorden.get(0), stukjesVoorEersteAntwoord);
        antwoordenMap.put(antwoorden.get(1), stukjesVoorTweedeAntwoord);
        antwoordenMap.put(antwoorden.get(2), stukjesVoorDerdeAntwoord);
    }
    
    public List<String> getStukjesRandom()
    {
        List<String> lijst = new ArrayList<>();
        List<String> returnwaarden = new ArrayList<>();
        stukjesVoorEersteAntwoord.stream().forEach((s) ->
        {
            lijst.add(s);
        });
        stukjesVoorTweedeAntwoord.stream().forEach((s) ->
        {
            lijst.add(s);
        });
        stukjesVoorDerdeAntwoord.stream().forEach((s) ->
        {
            lijst.add(s);
        });
        Random random = new Random();
        do
        {
            int index = random.nextInt(lijst.size());
            String waarde = lijst.get(index);
            returnwaarden.add(waarde);
            lijst.remove(index);
        }
        while(!lijst.isEmpty());
        return returnwaarden;
    }
    
    public List<String> getAntwoorden()
    {
        return antwoorden;
    }
}
