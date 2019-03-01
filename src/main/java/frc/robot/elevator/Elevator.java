package frc.robot.elevator;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class Elevator extends Subsystem 
{
  WPI_VictorSPX elevatorFollower = new WPI_VictorSPX(RobotMap.elevatorDriveOneID);
  WPI_TalonSRX elevatorMain = new WPI_TalonSRX(RobotMap.elevatorDriveTwoID);
  DigitalInput pos0Switch = new DigitalInput(6);
  DigitalInput pos1Switch = new DigitalInput(RobotMap.pos1ID);
  DigitalInput pos2Switch = new DigitalInput(RobotMap.pos2ID);
  DigitalInput pos3Switch = new DigitalInput(RobotMap.pos3ID);
  Encoder elevatorEncoder = new Encoder(RobotMap.elevatorEncoderBlueID,RobotMap.elevatorEncoderYellowID);

  int pos1RangeUpper = 200;
  int pos1RangeLower = 250;
  int pos2RangeUpper = 400;
  int pos2RangeLower = 450;
  int pos3RangeUpper = 600;
  int pos3RangeLower = 650;
  boolean isAbove = false;

  public Elevator() 
  {
    elevatorFollower.follow(elevatorMain);
    elevatorFollower.setInverted(true);
  }

  public void initDefaultCommand() 
  {

  }

  public void home() 
  {
    elevatorEncoder.reset();
  }

  public void manualControl(XboxController x, int axis) 
  {
    System.out.println(pos0Switch.get());
        if((pos0Switch.get()) && (x.getRawAxis(axis)>0))

        {
          elevatorMain.set(0);
        }
        else
          elevatorMain.set(x.getRawAxis(1));

    SmartDashboard.putNumber("Elevator", elevatorMain.get());
  }
}