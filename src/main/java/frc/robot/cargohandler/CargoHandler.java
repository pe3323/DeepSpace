package frc.robot.cargohandler;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;


public class CargoHandler extends Subsystem 
{

  WPI_VictorSPX intake = new WPI_VictorSPX(RobotMap.cargoIntakeID);
  WPI_VictorSPX shooterLeft = new WPI_VictorSPX(RobotMap.cargoExhaustLeftID);
  WPI_VictorSPX shooterRight = new WPI_VictorSPX(RobotMap.cargoExhaustRightID);
    // DoubleSolenoid intakeArm = new DoubleSolenoid(RobotMap.cargoArmInID, RobotMap.cargoArmOutID);
  DigitalInput cargoSwitch = new DigitalInput(RobotMap.cargoSwitchID);

  public CargoHandler() 
  {
    shooterRight.follow(shooterLeft);
    shooterRight.setInverted(true);
    SmartDashboard.putNumber("Shooter Speed", 0);
  }
  public void initDefaultCommand() 
  {

  }

  public void manualControl(XboxController x, int axis) 
  {
    shooterLeft.set(SmartDashboard.getNumber("Shooter Speed", 0));
  }
}