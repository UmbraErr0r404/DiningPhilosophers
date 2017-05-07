package program4;
import java.util.*; 

/*
 * Author: Lizzy Harasymiw
 * This program modles the Dinning Philosophers problem up to n.
 */
public class Program4 
{
    public static void main(String[] args) 
    {
        Scanner reader = new Scanner(System.in); 
        System.out.println("Enter how many Philosphers are eating: ");
        int n = reader.nextInt();     
        GoHomeBell MealOverBell = new GoHomeBell();      
        List<Philosopher> TableP = new ArrayList<Philosopher>();
        List<Fork> TableF = new ArrayList<Fork>();
        
        //Create all Forks
        for(int i = 0; i < n; i++)
            TableF.add( new Fork(i) );          
        
        //Create all Philosophers
        for(int i = 0; i < n; i++)
            TableP.add( new Philosopher( i, TableF.get( (i + 1) % n), TableF.get(i), MealOverBell ) );   
        
        //start all Treads
        for(int i = 0; i < n; i++)
            TableP.get(i).start();
        
        //Wait For 15 secs
        try           
        {  
           Thread.sleep(15000);
        }
        catch (InterruptedException  interruptedException)
        {
           System.out.println("Program closed: " + interruptedException);
        }
        
        //Send everyone Home
        MealOverBell.TimeToLeave = true;
        
        //How much did everyone eat?
        for(int i = 0; i < n; i++)
        {
            System.out.println( "Philosopher " + i + " has eaten: " + TableP.get(i).Eaten );
        }
    }  
}
