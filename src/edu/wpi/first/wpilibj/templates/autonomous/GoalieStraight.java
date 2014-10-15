package edu.wpi.first.wpilibj.templates.autonomous;

import edu.wpi.first.wpilibj.templates.CommandBase;
import edu.wpi.first.wpilibj.templates.Constants;

/*
 *
 * @author Andrew
 */
public class GoalieStraight extends GoalieAuto {    
    protected boolean shouldFlip()
    {
        return false;
    }
    
    protected double getAngleForLocation(double pos)
    {
        return 0;
    }
}
