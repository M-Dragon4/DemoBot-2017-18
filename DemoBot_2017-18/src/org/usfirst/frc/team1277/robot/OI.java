package org.usfirst.frc.team1277.robot;

import org.usfirst.frc.team1277.robot.commands.DispenseCommand;
import org.usfirst.frc.team1277.robot.commands.ShootCommand;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
	static Joystick stick = new Joystick(0);
//	Button activateShootH = new JoystickButton(stick, 3);
//	Button activateShootK = new JoystickButton(stick, 4);
	Button shooterButton = new JoystickButton(stick, 1);
	Button dispenseButton = new JoystickButton(stick, 2);
	public static AHRS ahrs;
	
	public OI()
	{	
		try
		{
			/***********************************************************************
			 * navX-MXP:
			 * - Communication via RoboRIO MXP (SPI, I2C, TTL UART) and USB.            
			 * - See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface.
			 * 
			 * navX-Micro:
			 * - Communication via I2C (RoboRIO MXP or Onboard) and USB.
			 * - See http://navx-micro.kauailabs.com/guidance/selecting-an-interface.
			 * 
			 * Multiple navX-model devices on a single robot are supported.
			 ************************************************************************/
            ahrs = new AHRS(SPI.Port.kMXP);
        } catch (RuntimeException re ) {
            DriverStation.reportError("Error instantiating navX MXP:  " + re.getMessage(), true);
        };
		
        shooterButton.whileHeld(new ShootCommand());
		dispenseButton.whenPressed(new DispenseCommand());
	}
	
	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	public static AHRS getAhrs()
	{
		return ahrs;
	}
	
	public static Joystick getJoystick()
	{
		return stick;
	}
}
