package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class Move extends Command 
{
  DriveBase db;
  double pConstant = .1;
  double iConstant = .0005;
  double dConstant = .001;

  public Move(DriveBase db) 
  {
    requires(db);
    this.db = db;
  }

  protected void initialize() 
  {
    db.uiEnabled=false;
    db.leftMain.getSensorCollection().setQuadraturePosition(0, 30);
    db.rightMain.getSensorCollection().setQuadraturePosition(0, 30);
    db.leftMain.config_kP(0, .001,30);
    db.rightMain.config_kP(0, .001,30);
  }
  protected void execute() 
  {
    db.leftMain.set(ControlMode.Position, 5000);
    db.rightMain.set(ControlMode.Position, 5000);
  }

  protected boolean isFinished() 
  {
    return false;
  }

  protected void end() 
  {
    db.uiEnabled = true;
  }

  protected void interrupted() 
  {
    end();
  }
}
