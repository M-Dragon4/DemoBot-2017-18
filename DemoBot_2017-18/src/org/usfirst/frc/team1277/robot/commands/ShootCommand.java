package org.usfirst.frc.team1277.robot.commands;

import org.usfirst.frc.team1277.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ShootCommand extends Command
{
	protected void initialize()
	{
		Robot.shooter.initState();
	}
	
	protected void execute()
	{
		Robot.shooter.shoot();
	}
	
	@Override
	protected boolean isFinished()
	{
		return false;
	}
	
	protected void end()
	{
		Robot.shooter.initState();
	}
	
	protected void interrupted()
	{
		end();
	}
}
