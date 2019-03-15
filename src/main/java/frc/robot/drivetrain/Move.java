package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Move extends edu.wpi.first.wpilibj.command.Command
{
  DriveBase db;
  double pConstant = 0.1D;
  double iConstant = 5.0E-4D;
  double dConstant = 0.001D;
  
  public Move(DriveBase db)
  {
    requires(db);
    this.db = db;
  }
  
  protected void initialize()
  {
    db.uiEnabled = false;
    db.leftMain.getSensorCollection().setQuadraturePosition(0, 30);
    db.rightMain.getSensorCollection().setQuadraturePosition(0, 30);
    db.leftMain.config_kP(0, 0.001D, 30);
    db.rightMain.config_kP(0, 0.001D, 30);
  }
  
  protected void execute() {
    db.leftMain.set(ControlMode.Position, 5000.0D);
    db.rightMain.set(ControlMode.Position, 5000.0D);
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
