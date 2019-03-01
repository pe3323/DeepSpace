package frc.robot.cargohandler;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeCargo extends Command 
{
  CargoHandler ch;

  public IntakeCargo( CargoHandler ch) 
  {
    requires(ch);
    this.ch = ch;
  }

  protected void initialize() 
  {

  }

  
  protected void execute() 
  {
    ch.intake.set(1);
    ch.shooterLeft.set(1);
    ch.shooterRight.set(1);
    // ch.intakeArm.set(Value.kForward);
  }

  
  protected boolean isFinished() 
  {
    if(ch.cargoSwitch.get())
    return true;
    else
    return false;
  }

  protected void end() 
  {
    ch.intake.set(0);
    ch.shooterLeft.set(0);
    ch.shooterRight.set(0);
  }

  protected void interrupted() 
  {
    end();
  }
}
