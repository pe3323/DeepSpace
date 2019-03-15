package frc.robot.cargohandler;

public class IntakeCargo extends edu.wpi.first.wpilibj.command.Command
{
  CargoHandler ch;
  
  public IntakeCargo(CargoHandler ch)
  {
    requires(ch);
    this.ch = ch;
  }

  protected void initialize() {}

  protected void execute()
  {
    ch.shooterLeft.set(.3);
  }
  
  protected boolean isFinished()
  {
    if (ch.cargoInShooter.get()) {
      return true;
    }
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
