/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.PortMap;

/**
 *
 * @author Andrew
 */
public class Intake extends Subsystem {
    Solenoid arm = new Solenoid(PortMap.ARM);
    Talon roller = new Talon(PortMap.ROLLER);
    
    public Intake()
    {
        roller.setSafetyEnabled(false); // Disable watchdog on roller
    }
    
    public void setRoller(double speed)
    {
        roller.set(-speed);
    }
    
    public void setArm(boolean state)
    {
        arm.set(state);
    }

    protected void initDefaultCommand() {
    }
}
