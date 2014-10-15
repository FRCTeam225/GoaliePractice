/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.Collect;
import edu.wpi.first.wpilibj.templates.commands.Spit;
import edu.wpi.first.wpilibj.templates.commands.Stow;
import edu.wpi.first.wpilibj.templates.commands.DropGoalie;
import edu.wpi.first.wpilibj.templates.commands.ReturnGoalie;

/**
 *
 * @author Andrew
 */
public class OI {
    public static Joystick driver = new Joystick(1);
    public static void init()
    {
        new JoystickButton(driver, 6).whenPressed(new Stow());
        new JoystickButton(driver, 2).whenPressed(new Spit());
        new JoystickButton(driver, 8).whenPressed(new Collect());
        new JoystickButton(driver, 11).whenPressed(new ReturnGoalie());
        new JoystickButton(driver, 12).whenPressed(new DropGoalie());
    }
}
