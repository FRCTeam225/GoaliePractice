package edu.wpi.first.wpilibj.templates.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.templates.commands.Spit;
import edu.wpi.first.wpilibj.templates.commands.DriveDistance;
import edu.wpi.first.wpilibj.templates.commands.Stow;

/**
 *
 * @author Andrew
 */
public class OneBall extends CommandGroup {
    public OneBall()
    {
        addSequential(new Stow());
        addSequential(new DriveDistance(-10000));
        addSequential(new Spit());
        addSequential(new WaitCommand(2.0));
    }
}
