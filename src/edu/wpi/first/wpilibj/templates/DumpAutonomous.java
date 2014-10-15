/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.DriveForTime;
import edu.wpi.first.wpilibj.templates.commands.Spit;

/**
 *
 * @author Andrew
 */
public class DumpAutonomous extends CommandGroup {
    public DumpAutonomous()
    {
        addSequential(new DriveForTime(3, -0.5));
        addSequential(new Spit());
    }
}
