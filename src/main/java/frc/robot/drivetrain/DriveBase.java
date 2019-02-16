package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro; 
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem; 
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class DriveBase extends Subsystem 
{
   WPI_TalonSRX frontLeft = new  WPI_TalonSRX(RobotMap.frontLeftID); 
   WPI_TalonSRX backLeft = new  WPI_TalonSRX(RobotMap.backLeftID);
   WPI_TalonSRX frontRight = new  WPI_TalonSRX(RobotMap.frontRightID);
   WPI_TalonSRX backRight = new  WPI_TalonSRX(RobotMap.backRightID);

  int f;

  private DifferentialDrive driveTrain = new DifferentialDrive(frontLeft, frontRight);

  private ADXRS450_Gyro gyro = new ADXRS450_Gyro();

  public boolean uiEnabled=true;

  public DriveBase(int toFeet)
  {
    SmartDashboard.putData(getMove());
    this.f= toFeet;
    
    backLeft.follow(frontLeft);
    backRight.follow(frontRight);
    frontLeft.setSensorPhase(true);
    frontRight.setSensorPhase(true);
  }

  public void initDefaultCommand() 
  {

  }

  public Command getMove()
  {
    return new Move(this);
  }

  public ADXRS450_Gyro getGyro()
    {
        return gyro;
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
        frontLeft.set(ControlMode.Position, 10*f);
        frontRight.set(ControlMode.Position, 10*f);
        }
        
	}

    public void log() 
    {
        SmartDashboard.putNumber("Left Distance", (double) frontLeft.getSensorCollection().getQuadraturePosition()/f);
        SmartDashboard.putNumber("Left Velocity", ((double)frontLeft.getSensorCollection().getQuadratureVelocity())/f*10);
        SmartDashboard.putNumber("Right Distance", (double) frontRight.getSensorCollection().getQuadraturePosition()/f);
        SmartDashboard.putNumber("Right Velocity", ((double)frontRight.getSensorCollection().getQuadratureVelocity())/f*10);
	}
}
