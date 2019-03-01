package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem; 
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class DriveBase extends Subsystem 
{
   WPI_VictorSPX leftFollower = new  WPI_VictorSPX(RobotMap.leftFollowerID); 
   WPI_TalonSRX leftMain = new  WPI_TalonSRX(RobotMap.leftMainID);
   WPI_VictorSPX rightFollower = new  WPI_VictorSPX(RobotMap.rightFollowerID);
   WPI_TalonSRX rightMain = new  WPI_TalonSRX(RobotMap.rightMainID);

  int f;

  private DifferentialDrive driveTrain = new DifferentialDrive(leftMain, rightMain);

  public boolean uiEnabled=true;

  public DriveBase(int toFeet)
  {
    SmartDashboard.putData(getMove());
    this.f= toFeet;
    
    leftFollower.follow(leftMain);
    rightFollower.follow(rightMain);
    leftMain.setSensorPhase(true);
    rightMain.setSensorPhase(true);
  }

  public void initDefaultCommand() 
  {

  }

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
        double rotation= 1;
        if (cw)
            rotation= rotation*-1;
        driveTrain.arcadeDrive(speed,rotation);
    }

    public void stop()
    {
        driveTrain.stopMotor();
    }

    public void drive(double speed, double rotation) 
    {
        if (uiEnabled)
        driveTrain.arcadeDrive(-speed, rotation);
        else
        {
        leftMain.set(ControlMode.Position, 10*f);
        rightMain.set(ControlMode.Position, 10*f);
        }
        
	}

    public void log() 
    {
        SmartDashboard.putNumber("Left Distance", (double) leftMain.getSensorCollection().getQuadraturePosition()/f);
        SmartDashboard.putNumber("Left Velocity", ((double)leftMain.getSensorCollection().getQuadratureVelocity())/f*10);
        SmartDashboard.putNumber("Right Distance", (double) rightMain.getSensorCollection().getQuadraturePosition()/f);
        SmartDashboard.putNumber("Right Velocity", ((double)rightMain.getSensorCollection().getQuadratureVelocity())/f*10);
	}
}

