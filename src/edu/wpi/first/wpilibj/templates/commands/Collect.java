/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.CommandBase;

/**
 *
 * @author Andrew
 */
public class Collect extends CommandBase {
    public Collect()
    {
        requires(intake);
    }

    protected void initialize() {
        intake.setArm(true);
        intake.setRoller(-1);
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
       
    }
}
