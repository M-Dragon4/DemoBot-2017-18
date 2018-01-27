package org.usfirst.frc.team1277.robot.subsystems;

import org.usfirst.frc.team1277.robot.RobotMap;
import org.usfirst.frc.team1277.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem
{
	private final Joystick stick = RobotMap.stick;
	private final Talon driveRight = RobotMap.driveTrainRight;
	private final Talon driveLeft = RobotMap.driveTrainLeft;
	
	@Override
	protected void initDefaultCommand()
	{
		 setDefaultCommand(new DriveCommand());
	}

	public void initState()
	{
		driveRight.stopMotor();
		driveLeft.stopMotor();
	}

	public void run()
	{
		driveRight.set(stick.getY());
		driveLeft.set(-stick.getY());
	}
	
	public void rotate()
	{
		driveRight.set(stick.getZ() - .65);
		driveLeft.set(stick.getZ() - .65);
	}
}
