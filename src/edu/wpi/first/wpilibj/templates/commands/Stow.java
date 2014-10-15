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
public class Stow extends CommandBase {
    public Stow()
    {
        requires(intake);
    }

    protected void initialize() {
        intake.setArm(false);
        intake.setRoller(0);
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
       
    }
}
