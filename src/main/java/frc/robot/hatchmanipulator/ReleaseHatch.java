package frc.robot.hatchmanipulator;

import edu.wpi.first.wpilibj.command.Command;

public class ReleaseHatch extends Command 
{
  HatchManipulator hm;

  public ReleaseHatch( HatchManipulator hm) 
  {
    requires(hm);
    this.hm = hm;
  }

  protected void initialize() 
  {

  }

  
  protected void execute() 
  {

  }

  protected boolean isFinished() 
  {
    return false;
  }

  protected void end() 
  {

  }

  protected void interrupted() 
  {
    end();
  }
}