package frc.robot.cargohandler;

public class ShootCargo extends edu.wpi.first.wpilibj.command.Command
{
  CargoHandler ch;
  
  public ShootCargo(CargoHandler ch)
  {
    requires(ch);
    this.ch = ch;
  }
  
  protected void initialize() {}
  
  protected void execute()
  {
    ch.shooterLeft.set(-.9);
  }
  
  protected boolean isFinished()
  {
    return false;
  }
  
  protected void end()
  {
    ch.shooterLeft.set(0);
  }
  
  protected void interrupted()
  {
    end();
  }
}
