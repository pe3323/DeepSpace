package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveBase extends Subsystem
{
  WPI_VictorSPX leftFollower = new WPI_VictorSPX(1);
  WPI_TalonSRX leftMain = new WPI_TalonSRX(2);
  WPI_VictorSPX rightFollower = new WPI_VictorSPX(3);
  WPI_TalonSRX rightMain = new WPI_TalonSRX(4);
  
  int f;
  
  private DifferentialDrive driveTrain = new DifferentialDrive(leftMain, rightMain);
  
  public boolean uiEnabled = true;
  
  public DriveBase(int toFeet)
  {
    SmartDashboard.putData(getMove());
    f = toFeet;
    
    leftFollower.follow(leftMain);
    rightFollower.follow(rightMain);
    leftMain.setSensorPhase(true);
    rightMain.setSensorPhase(true);
  }
  


  public void initDefaultCommand() {}
  

  public Command getMove()
  {
    return new Move(this);
  }
  
  public DifferentialDrive getDriveTrain()
  {
    return driveTrain;
  }
  
  public void startTurn(double speed, boolean cw)
  {
    double rotation = 1.0D;
    if (cw)
      rotation *= -1.0D;
    driveTrain.arcadeDrive(speed, rotation);
  }
  
  public void stop()
  {
    driveTrain.stopMotor();
  }
  
  public void drive(double speed, double rotation)
  {
    if (uiEnabled) {
      driveTrain.arcadeDrive(-speed, rotation);
    }
    else {
      leftMain.set(ControlMode.Position, 10 * f);
      rightMain.set(ControlMode.Position, 10 * f);
    }
  }
  

  public void log()
  {
    SmartDashboard.putNumber("Left Distance", leftMain.getSensorCollection().getQuadraturePosition() / f);
    SmartDashboard.putNumber("Left Velocity", leftMain.getSensorCollection().getQuadratureVelocity() / f * 10.0D);
    SmartDashboard.putNumber("Right Distance", rightMain.getSensorCollection().getQuadraturePosition() / f);
    SmartDashboard.putNumber("Right Velocity", rightMain.getSensorCollection().getQuadratureVelocity() / f * 10.0D);
  }
}
