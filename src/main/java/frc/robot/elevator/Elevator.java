package frc.robot.elevator;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Elevator extends Subsystem 
{
  WPI_TalonSRX elevatorDriveOne = new WPI_TalonSRX(RobotMap.elevatorDriveOneID);
  WPI_TalonSRX elevatorDriveTwo = new WPI_TalonSRX(RobotMap.elevatorDriveTwoID);
  AnalogInput pos1Switch = new AnalogInput(RobotMap.Pos1ID);
  AnalogInput pos2Switch = new AnalogInput(RobotMap.Pos2ID);
  AnalogInput pos3Switch = new AnalogInput(RobotMap.Pos3ID);
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
    
  }

  public void initDefaultCommand() 
  {

  }

  public void home() 
  {
    elevatorEncoder.reset();
  }
}