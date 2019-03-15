package frc.robot.cargohandler;

public class PickupCargo extends edu.wpi.first.wpilibj.command.Command
{
  CargoHandler ch;
  int stage = 0;
  
  public PickupCargo(CargoHandler ch)
  {
    requires(ch);
    this.ch = ch;
  }
  
  protected void initialize() {}
  
  protected void execute()
  {
    System.out.println(stage);
    if(stage==0&&ch.armPot.getValue()>800)
      ch.intakeArm.set(0.5);
    if(stage==0&&ch.armPot.getValue()<800)
      {
      ch.intakeArm.set(0);
      stage=1;
      }
    if(stage==1&&!ch.cargoInFondler.get())
      ch.intake.set(.6);
    if(stage==1&&ch.cargoInFondler.get())
    {
      ch.intake.set(0);
      stage = 2;
    }
    if(stage==2&&ch.armPot.getValue()<2000)
      ch.intakeArm.set(-.4);
    if(stage==2&&ch.armPot.getValue()>2000)
      {
      ch.intakeArm.set(0);
      stage=3;
      }
    if(stage==3&&!ch.cargoInShooter.get())
    {
      ch.shooterLeft.set(-.3);
      ch.intake.set(-.4);
    }
    if(stage==3&&ch.cargoInShooter.get())
    {
      ch.shooterLeft.set(0);
      ch.intake.set(0);
      stage=4;
    }
  }

  protected boolean isFinished()
  {
    if(stage==4)
    {
    return true;
    }
    else
    return false;
  }
  
  protected void end()
  {
    stage = 0;
    ch.intakeArm.set(0);
    ch.shooterLeft.set(0);
    ch.intake.set(0);
  }
  
  protected void interrupted()
  {
    if(ch.armPot.getValue()<2000)
    ch.intakeArm.set(-.5);
    end();
  }
}
