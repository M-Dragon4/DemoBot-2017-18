package org.usfirst.frc.team1277.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
	public static Joystick stick = OI.getJoystick();
	public static DifferentialDrive robotDrive;
	
	//Dispenser
	public static Servo dispenser;
	
	//Shoot
	public static Spark loadMotor, shootMotor;
	public static Encoder enc;
	
	//DriveTrain
	public static Talon driveTrainRight, driveTrainLeft;
	
	public static void init()
	{
		dispenser = new Servo(4);
		loadMotor = new Spark(3);
		shootMotor = new Spark(2);
		enc = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
		driveTrainRight = new Talon(1);
		driveTrainLeft = new Talon(0);
		
		robotDrive = new DifferentialDrive(driveTrainRight, driveTrainLeft);
	}
}
