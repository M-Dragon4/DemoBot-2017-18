package org.usfirst.frc.team1277.robot.subsystems;

import org.usfirst.frc.team1277.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shoot extends Subsystem
{
	private final Spark shootMotor = RobotMap.shootMotor;
	private final Spark loadMotor = RobotMap.loadMotor;
	
	public void initState()
	{
		shootMotor.stopMotor();
		loadMotor.stopMotor();
	}
	
	@Override
	protected void initDefaultCommand()
	{
	}
	
	public void shoot()
	{
		shootMotor.set(0.75);
		loadMotor.set(1.0);
	}

//	public void shootKids() //Lower speed for kids to catch.
//	{
//		shootMotor.set(0.75);
//		loadMotor.set(1.0);
//	}
}
