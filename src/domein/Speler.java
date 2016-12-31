/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Dylan
 */
public class Speler implements Subject
{
    private String name;
    private int score;
    private static Timer timer;
    private static int interval;
    private boolean stopTimer = false;
    private Set<Observer> observers;

    public Speler(String name)
    {
        this.name = name;
        observers = new HashSet<>();
        setScore(60);
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
        notifyObservers();
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
                setScore(interval);
            }
            
        }, delay, period);
        setScore(interval);
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

    @Override
    public void addObserver(Observer observer)
    {
        observers.add(observer);
        observer.update(score);
    }

    @Override
    public void removeObserver(Observer observer)
    {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers()
    {
        observers.forEach(observer -> observer.update(score));
    }
}
