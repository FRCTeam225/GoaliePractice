package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Andrew
 */
public class AutonomousWrapper {
    Class autonomous = null;
    String description = "";
    boolean caresAboutHotGoal = false;
    boolean startingOnLeft = true;
    public static boolean hasHotGoal = false;
    public static boolean leftIsHot = false;
    
    public AutonomousWrapper(Class autonomous, String description)
    {
        this.autonomous = autonomous;
        
        if ( description == null )
            this.description = autonomous.getName();
        else 
            this.description = description;
        
        this.caresAboutHotGoal = false;       
    }
    
    public AutonomousWrapper(Class autonomous, String description, boolean caresAboutHotGoal, boolean startingOnLeft)
    {
        this(autonomous, description);
        
        this.caresAboutHotGoal = caresAboutHotGoal;
        
        if ( this.caresAboutHotGoal )
            this.startingOnLeft = startingOnLeft;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public Command start()
    {   
        if ( caresAboutHotGoal )
        {
           Timer t = new Timer();
           t.start();
           
           while ( t.get() < 1 ){}
           
           leftIsHot = CommandBase.table.getBoolean("leftHot", false);
           if ( leftIsHot && startingOnLeft || !leftIsHot && !startingOnLeft ) // for clarity
           {}
           else if ( leftIsHot && !startingOnLeft || !leftIsHot && startingOnLeft )
               while ( t.get() < 5){}          
        }
        Command command = null;
        try
        {
            command = (Command) autonomous.newInstance(); 
        } catch (Exception e) {
            System.out.println("Failed to start command, falling back to OneBall");
            e.printStackTrace();
        }
        command.start();
        return command;
    }
}
