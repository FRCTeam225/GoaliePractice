package edu.wpi.first.wpilibj.templates.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.DriveDistance;

/**
 *
 * @author Andrew
 */
public class OnlyDriveForward extends CommandGroup {
    public OnlyDriveForward()
    {
        addSequential(new DriveDistance(10000));
    }
}
