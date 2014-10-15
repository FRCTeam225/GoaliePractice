/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.templates.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.templates.subsystems.Intake;
import edu.wpi.first.wpilibj.templates.subsystems.Goalie;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
/**
 *
 * @author Andrew
 */
public abstract class CommandBase extends Command {
    public static Drivetrain drivetrain;
    public static Intake intake;
    public static Goalie goalie;
    
    public static ConstantServer constantServer;

    public static NetworkTable table;
    
    public static Timer matchTimer;
    
    public static Constants constants;
    
    
    
    
    public static void init()
    {
        drivetrain = new Drivetrain();
        intake = new Intake();
        goalie = new Goalie();
        
        constantServer = ConstantServer.create(225);
        constants = Constants.getConstants();
        
        table = NetworkTable.getTable("225");
    }
    
    public void interrupted()
    {
        end();
    }
    
}
