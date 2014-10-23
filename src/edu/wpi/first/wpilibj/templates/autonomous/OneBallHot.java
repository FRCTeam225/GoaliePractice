package edu.wpi.first.wpilibj.templates.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.templates.commands.Spit;
import edu.wpi.first.wpilibj.templates.commands.DriveDistance;
import edu.wpi.first.wpilibj.templates.commands.Stow;
import edu.wpi.first.wpilibj.templates.AutonomousWrapper;

/**
 *
 * @author Andrew
 */
public class OneBallHot extends CommandGroup {
    public OneBallHot()
    {
        if ( !AutonomousWrapper.goalIsHot )
            addSequential(new WaitCommand(4.0));
        addSequential(new Stow());
        addSequential(new DriveDistance(-45000));
        addSequential(new Spit());
        addSequential(new WaitCommand(2.0));
    }
}
