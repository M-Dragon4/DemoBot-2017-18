package org.usfirst.frc.team1277.robot.commands;

import java.util.concurrent.TimeUnit;
import org.usfirst.frc.team1277.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DispenseCommand extends Command
{
	private boolean done = false;
	
	public DispenseCommand()
	{
		requires(Robot.dispense);
	}
	
	protected void initialize()
	{
		Robot.dispense.close();
	}
	
	protected void execute()
	{
		Robot.dispense.open();
		try
		{
			TimeUnit.MILLISECONDS.sleep(225);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		Robot.dispense.close();
		done = true;
	}

	@Override
	protected boolean isFinished()
	{
		if(done == true) { return true; }
		else return false;
	}

	protected void end()
	{
		Robot.dispense.close();
	}

	protected void interrupted()
	{
		end();
	}
}
