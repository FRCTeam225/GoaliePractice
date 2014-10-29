package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.autonomous.Brick;
import edu.wpi.first.wpilibj.templates.autonomous.OnlyDriveForward;
import edu.wpi.first.wpilibj.templates.autonomous.GoalieAuto;
import edu.wpi.first.wpilibj.templates.autonomous.GoalieFlipped;
import edu.wpi.first.wpilibj.templates.autonomous.GoalieStraight;
import edu.wpi.first.wpilibj.templates.autonomous.OneBall;
import edu.wpi.first.wpilibj.templates.autonomous.OneBallHot;
import edu.wpi.first.wpilibj.templates.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.templates.Constants;
import edu.wpi.first.wpilibj.templates.commands.DropGoalie;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class PracticeRobot extends IterativeRobot {
    
    Compressor compressor = new Compressor(1,1);
    DumpAutonomous autoCmd = null;
    
    int selectedAutonomous = 0;
    AutonomousWrapper autonomousOptions[] = {        
        new AutonomousWrapper(Brick.class, "Do nothing"),
        new AutonomousWrapper(OneBall.class, "1B Any Goal"),
        new AutonomousWrapper(OneBallHot.class, "1B Hot Goal (Right)", true, false),
        new AutonomousWrapper(OneBallHot.class, "1B Hot Goal (Left)", true, true),
        
        // Goalie
        new AutonomousWrapper(GoalieAuto.class, "GoalieDrive"),
        new AutonomousWrapper(GoalieFlipped.class, "GoalieFlipped"),
        new AutonomousWrapper(GoalieStraight.class, "GoalieStraight"),
    };
    
    Command autonomousCommand = null;
    
    public void robotInit() {
        CommandBase.init();
        OI.init();
        compressor.start();
        Constants.getConstants();
        System.out.println("ROBOT READY!");
    }

    public void autonomousInit()
    {
        CommandBase.table.putBoolean("isTeleop", false);
        
        CommandBase.drivetrain.resetAngle();
        CommandBase.drivetrain.resetDistance();
        CommandBase.intake.setRoller(0);
        
        autonomousCommand = autonomousOptions[selectedAutonomous].start();
    }
                                
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit()
    {
        CommandBase.table.putBoolean("isTeleop", true);
        if ( autonomousCommand != null )
            autonomousCommand.cancel();
        
        new DropGoalie().start();
    }
    
    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    public void testPeriodic() 
    {
        System.out.println("" + CommandBase.drivetrain.getLeftDistance() + ", " + CommandBase.drivetrain.getRightDistance());
    }
    
    public void disabledInit()
    {
        CommandBase.table.putBoolean("isTeleop", false);
        CommandBase.drivetrain.resetDistance();
        CommandBase.drivetrain.resetAngle();
        
    }
    
    public void disabledPeriodic()
    {   
        DriverStationLCD dsLCD = DriverStationLCD.getInstance();

        if ( OI.driver.getRawButton(2) && selectedAutonomous < autonomousOptions.length-1 )
        {
            dsLCD.clear();
            selectedAutonomous++;
            Timer.delay(0.5);
        }
        else if ( OI.driver.getRawButton(1) && selectedAutonomous > 0  )
        {
            dsLCD.clear();
            selectedAutonomous--;
            Timer.delay(0.5);
        }
        else if ( OI.driver.getRawButton(3) )
        {
            CommandBase.drivetrain.resetDistance();
            CommandBase.drivetrain.resetGyro();
            dsLCD.clear();
        }
        
        
        AutonomousWrapper auto = autonomousOptions[selectedAutonomous];
        
        dsLCD.println(DriverStationLCD.Line.kUser1, 1, "Auto");
        dsLCD.println(DriverStationLCD.Line.kUser2, 1, auto.getDescription());
        dsLCD.println(DriverStationLCD.Line.kUser3, 1, "D: "+CommandBase.drivetrain.getAverageDistance());
        dsLCD.println(DriverStationLCD.Line.kUser4, 1, "A: "+CommandBase.drivetrain.getAngle());
        
        boolean leftHot = CommandBase.table.getBoolean("leftHot", false);
        boolean rightHot = CommandBase.table.getBoolean("rightHot", false);
        String hot = "none";
        if ( leftHot && rightHot )
            hot = "both";
        else if ( leftHot )
            hot = "left";
        else if ( rightHot )
            hot = "right";
        dsLCD.println(DriverStationLCD.Line.kUser5, 1, "Hot: "+hot);
        
        dsLCD.updateLCD();
            
    }
    
}
