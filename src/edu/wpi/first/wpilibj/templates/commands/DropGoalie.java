/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.CommandBase;

/**
 *
 * @author Driver2
 */

public class DropGoalie extends CommandBase {
    public DropGoalie()
    {
        requires(goalie);
    }

    protected void initialize() {
        goalie.setDrop(true);
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
       
    }
}