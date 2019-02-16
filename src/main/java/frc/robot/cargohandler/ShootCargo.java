package frc.robot.cargohandler;

import edu.wpi.first.wpilibj.command.Command;

public class ShootCargo extends Command 
{
  CargoHandler ch;

  public ShootCargo( CargoHandler ch) 
  {
    requires(ch);
    this.ch = ch;
  }

  protected void initialize() 
  {

  }
  
  protected void execute() 
  {
    ch.shooterLeft.set(1);
    ch.shooterRight.set(1);
  }

  
  protected boolean isFinished() 
  {
    return false;
  }

  protected void end() 
  {
    ch.shooterLeft.set(0);
    ch.shooterRight.set(0);
  }

  protected void interrupted() 
  {
    end();
  }
}