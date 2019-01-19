package frc.robot.drivetrain;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX; 


import edu.wpi.first.wpilibj.ADXRS450_Gyro; 
import edu.wpi.first.wpilibj.Encoder; 
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem; 
import edu.wpi.first.wpilibj.drive.DifferentialDrive; 
import frc.robot.RobotMap;

public class DriveBase extends Subsystem 
{
  private WPI_TalonSRX leftFront = new  WPI_TalonSRX(RobotMap.leftFrontID); 
  private WPI_TalonSRX leftBack = new  WPI_TalonSRX(RobotMap.leftBackID);
  private SpeedControllerGroup left = new SpeedControllerGroup(leftFront, leftBack);

  private WPI_TalonSRX rightFront = new  WPI_TalonSRX(RobotMap.rightFrontID);
  private WPI_TalonSRX rightBack = new  WPI_TalonSRX(RobotMap.rightBackID);
  private SpeedControllerGroup right = new SpeedControllerGroup(rightFront, rightBack);

  private DifferentialDrive driveTrain = new DifferentialDrive(left, right);

  private Encoder encoderRight = new Encoder(RobotMap.rightBlueID, RobotMap.rightYellowID);
  private Encoder encoderLeft = new Encoder(RobotMap.leftBlueID, RobotMap.leftYellowID);
  private ADXRS450_Gyro gyro = new ADXRS450_Gyro();

  private int dpp = 3;

  public DriveBase()
  {
    encoderLeft.setDistancePerPulse(dpp);
    encoderRight.setDistancePerPulse(dpp);
  }

  public void initDefaultCommand() 
  {

  }
  public ADXRS450_Gyro getGyro()
    {
        return gyro;
    }

    public Encoder getEncoderLeft()
    {
        return encoderLeft;
    }

    public Encoder getEncoderRight()
    {
        return encoderRight;
    }

    public DifferentialDrive getDriveTrain()
    {
        return driveTrain;
    }

    public void startMove(double speed)
    {
        driveTrain.arcadeDrive(speed,0);
    }


    public void startTurn(double speed, boolean right)
    {
        double rotation= 1;
        if (right)
            rotation= rotation*-1;
        driveTrain.arcadeDrive(speed,rotation);
    }

    public void stop()
    {
        driveTrain.stopMotor();
    }
}
