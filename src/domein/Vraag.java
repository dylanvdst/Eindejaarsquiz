/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.List;

/**
 *
 * @author Dylan
 */
public class Vraag
{
    private String text;
    private List<String> antwoorden;
    
    public Vraag(String text, List<String> antwoord)
    {
        this.text = text;
        this.antwoorden = antwoord;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public List<String> getAntwoord()
    {
        return antwoorden;
    }

    public void setAntwoord(List<String> antwoord)
    {
        this.antwoorden = antwoord;
    }
    
    
}
