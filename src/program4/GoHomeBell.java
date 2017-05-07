package program4;

/*
 * Author: Lizzy Harasymiw
 * This class is a Bell used to tell all Philosophers to 
 * go home at the same time.
 */
public class GoHomeBell 
{
    volatile boolean TimeToLeave;
    
    /*
     * Author: Lizzy Harasymiw
     * Default Construtor
     */
    GoHomeBell()
    {
        TimeToLeave = false;
    }
    
    /*
     * Author: Lizzy Harasymiw
     * Rings the Bells
     */
    void RingBell()
    {
        TimeToLeave = true;
    }
}
