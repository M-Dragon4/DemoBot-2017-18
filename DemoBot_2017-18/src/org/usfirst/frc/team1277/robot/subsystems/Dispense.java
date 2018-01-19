package org.usfirst.frc.team1277.robot.subsystems;

import org.usfirst.frc.team1277.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Dispense extends Subsystem
{

	private final Servo dispenser = RobotMap.dispenser;

	@Override
	protected void initDefaultCommand()
	{
	}

	public void open()
	{
		dispenser.set(0.70f);
	}

	public void close()
	{
		dispenser.set(0.4f);
	}

}
