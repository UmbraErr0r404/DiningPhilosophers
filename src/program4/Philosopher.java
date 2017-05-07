package program4;
import java.util.Random;

/*
 * Author: Lizzy Harasymiw
 * This class represents a Philosopher that is trying to eat food till
 * told to stop.
 */
public class Philosopher extends Thread 
{ 
    int ID;
    Fork LeftFork, RightFork;
    Random rand;
    int aRandomNumber;
    int Eaten;
    GoHomeBell MyBell;
    
    /*
     * Author: Lizzy Harasymiw
     * Default Construtor
     */
    Philosopher(int id, Fork LFork, Fork RFork, GoHomeBell Bell)
    {
        ID = id;
        Eaten = 0;
        LeftFork = LFork;
        RightFork = RFork;
        rand = new Random();
        aRandomNumber = rand.nextInt(2000) + 1000;
        MyBell = Bell;
    }
    
     /*
     * Author: Lizzy Harasymiw
     * A Random wait time representing the Philosopher Thinking.
     */
    void Think()
    {
        if(! MyBell.TimeToLeave)
        {
            System.out.println ("Philosopher " + ID + " THINKING");

            try           
            {  
               Thread.sleep(aRandomNumber);
            }
            catch (InterruptedException  interruptedException)
            {
               System.out.println("Program closed: " + interruptedException);
            }
        }
    }
    
    /*
     * Author: Lizzy Harasymiw
     * The Philosopher eats for 1 sec and then releases the resources
     * used to do so.
     */
    void Eat()
    {
        if(! MyBell.TimeToLeave)
        {
            try    
            {  
               System.out.println ("Philosopher " + ID + " EATING"); 
               Thread.sleep(1000);
               Eaten++;
               LeftFork.InUse = false;
               RightFork.InUse = false;
            }
            catch (InterruptedException  interruptedException)
            {
              System.out.println("Program closed: " + interruptedException);
            }
        }
    }
    
    /*
     * Author: Lizzy Harasymiw
     * The Philosopher gets the left fork or waits till it can take it
     */
    void GetLeftFork()
    {
        if(! MyBell.TimeToLeave)
        {
            if( LeftFork.InUse == false) 
            {
                LeftFork.InUse = true;
            }
            else
            {
                System.out.println ("Philosopher " + ID + " WAIT_LEFT_FORK");
                boolean waiting = true;
                while(waiting)
                {
                    if( LeftFork.InUse == false) 
                    {
                        LeftFork.InUse = true;
                        waiting = false;
                    }
                }
            }
        }
    }
      
    /*
     * Author: Lizzy Harasymiw
     * The Philosopher gets the right fork or waits till it can take it
     */
    void GetRightFork()
    {
        if(! MyBell.TimeToLeave)
        {
            if( RightFork.InUse == false) 
            {
                RightFork.InUse = true;
            }
            else
            {
                System.out.println ("Philosopher " + ID + " WAIT_RIGHT_FORK");
                boolean waiting = true;
                while(waiting)
                {
                    if( RightFork.InUse == false) 
                    {
                        RightFork.InUse = true;
                        waiting = false;
                    }
                }
            }
        }
    }
           
    /*
     * Author: Lizzy Harasymiw
     * The Philosopher thinks, gets his forks, eats, 
     * repeats till told otherwise.
     */
    public void run()  
    { 
        Think();
        while (! MyBell.TimeToLeave) //time for him to go home
        { 
            Think();
            GetRightFork();
            GetLeftFork();
            Eat();
        }         
    } 
} 
