package program4;

/*
 * Author: Lizzy Harasymiw
 * This is a fork that will be used and shared by Philosphers to help them
 * eat.
 */
public class Fork 
{            
    volatile boolean InUse = false;
    int ID;
    
    /*
     * Author: Lizzy Harasymiw
     * Default Construtor
     */
    Fork( int IDNum)
    {
        ID = IDNum;
    } 
} 
