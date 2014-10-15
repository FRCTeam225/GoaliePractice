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
public class DriveForTime extends CommandBase {
    double speed = 0;
    public DriveForTime(double time, double speed)
    {
        requires(drivetrain);
        setTimeout(time);
        this.speed = speed;
    }

    protected void initialize() {
        
    }

    protected void execute() {
        drivetrain.setMotors(speed, speed);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        drivetrain.setMotors(0, 0);
    }
}
