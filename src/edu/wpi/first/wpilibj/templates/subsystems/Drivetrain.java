/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.PortMap;
import edu.wpi.first.wpilibj.templates.commands.CheesyDrive;

/**
 *
 * @author Andrew
 * 
 * 
 */
public class Drivetrain extends Subsystem {

    Talon[] left = {
        new Talon(PortMap.LEFT_DRIVE1),
        new Talon(PortMap.LEFT_DRIVE2),
        new Talon(PortMap.LEFT_DRIVE3),
    };
    
    Talon[] right = {
        new Talon(PortMap.RIGHT_DRIVE1),
        new Talon(PortMap.RIGHT_DRIVE2),
        new Talon(PortMap.RIGHT_DRIVE3),
    };
    
    Encoder leftEncoder;
    Encoder rightEncoder;
    
    Gyro gyro;
    
    Solenoid shift = new Solenoid(PortMap.SHIFT);
    

    public Drivetrain()
    {
        gyro = new Gyro(PortMap.GYRO);
        leftEncoder = new Encoder(PortMap.LEFT_ENCODERA, PortMap.LEFT_ENCODERB);
        rightEncoder = new Encoder(PortMap.RIGHT_ENCODERA, PortMap.RIGHT_ENCODERB, true);

        leftEncoder.start();
        rightEncoder.start();
    }
    
    public void shift(boolean low)
    {
        shift.set(low);
    }
    
    public void setMotors(double leftSpeed, double rightSpeed)
    {
        for ( int i = 0; i < 3; i++ )
        {
            left[i].set(leftSpeed);
            right[i].set(-rightSpeed);
        }
    }
    
    public void resetAngle()
    {
        gyro.reset();
    }
    
    public void resetGyro()
    {
        gyro.free();
        gyro = new Gyro(PortMap.GYRO);
    }
    
    public double getAngle()
    {
        return gyro.getAngle();
    }
    
    public double getLeftDistance()
    {
        return leftEncoder.getDistance();
    }
    
    public double getRightDistance()
    {
        return rightEncoder.getDistance();
    }
    
    public double getAverageDistance()
    {
        return (getLeftDistance()+getRightDistance())/2;
    }
    
    public void resetDistance()
    {
        rightEncoder.reset();
        leftEncoder.reset();
    }
    
    public void setLeftSpeed(double speed)
    {
        for ( int i = 0; i < left.length; i++ )
        {
            left[i].set(speed);
        }
    }
    
    public void setRightSpeed(double speed)
    {
        for ( int i = 0; i < right.length; i++ )
        {
            right[i].set(-speed);
        }
    }
    
    
    protected void initDefaultCommand() {
        setDefaultCommand(new CheesyDrive());
    }
    
}
