
package edu.wpi.first.wpilibj.templates.commands;

//import edu.wpi.first.wpilibj.templates.AutonomousWrapper;
import edu.wpi.first.wpilibj.templates.CommandBase;

/**
 *
 * @author andrew
 */
public class UpdateHotGoal extends CommandBase {

    boolean done = false;
    boolean left = false, right = false;
    
    public UpdateHotGoal()
    {
        setTimeout(0.5);
    }
    
    
    protected void initialize() {
        done = false;
    }

    protected void execute() {
        left = CommandBase.table.getBoolean("leftHot");
        right = CommandBase.table.getBoolean("rightHot");
        if ( (left && !right) || (!left && right) )
            done = true;
    }

    protected boolean isFinished() {
        return done || isTimedOut();
    }

    protected void end() {
    }
    
}
