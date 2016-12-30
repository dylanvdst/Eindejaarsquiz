/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Dylan
 */
public class Speler
{
    private String name;
    private int score;
    private static Timer timer;
    private static int interval;
    private boolean stopTimer = false;

    public Speler(String name)
    {
        this.name = name;
        this.score = 60;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }
    
    public void timer()
    {
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = score;
        timer.schedule(new TimerTask() 
        {

            @Override
            public void run() 
            {
                setInterval();
                score = interval;
            }
            
        }, delay, period);
        this.score = interval;
    }
    
    public void stopTimer()
    {
        timer.cancel();
    }
    
    private static void setInterval() 
    {
    if (interval == 1)
        timer.cancel();
    --interval;
    }
}
