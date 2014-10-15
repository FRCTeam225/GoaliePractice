/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.PortMap;

/**
 *
 * @author Driver2
 */
public class Goalie extends Subsystem {
    
    Solenoid goalie1 = new Solenoid(PortMap.GOALIE_1);
    Solenoid goalie2 = new Solenoid(PortMap.GOALIE_2);
    
    public Goalie()
    {
    }
    
    public void setDrop(boolean state)
    {
        goalie1.set(state);
        goalie2.set(!state);
    }

    protected void initDefaultCommand() {
    }
   
}
