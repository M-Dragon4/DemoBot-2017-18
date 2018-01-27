package org.usfirst.frc.team1277.robot.commands;

import org.usfirst.frc.team1277.robot.Robot;
import org.usfirst.frc.team1277.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class DriveCommand extends Command
{
	private final Joystick stick = RobotMap.stick;
	
	public DriveCommand()
	{
		requires(Robot.drive);
	}
	
	protected void intialize()
	{
		Robot.drive.initState();
	}
	
	protected void execute()
	{
		if(-0.1 < stick.getY() && stick.getY() < 0.1)
		{
			end();
			if(-0.1 < (stick.getZ() - .64) && (stick.getZ() - .64) < 0.1)
			{
				end();
			}
			else Robot.drive.rotate();
		}
		else Robot.drive.run();
	}
	
	@Override
	protected boolean isFinished()
	{
		return false;
	}
	
	protected void end()
	{
		Robot.drive.initState();
	}
	
	protected void interrupted()
	{
		end();
	}
}
