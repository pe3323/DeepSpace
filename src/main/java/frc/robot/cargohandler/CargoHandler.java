package frc.robot.cargohandler;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class CargoHandler extends Subsystem 
{

    WPI_TalonSRX intake = new WPI_TalonSRX(RobotMap.cargoIntakeID);
    WPI_TalonSRX shooterLeft = new WPI_TalonSRX(RobotMap.cargoExhaustLeftID);
    WPI_TalonSRX shooterRight = new WPI_TalonSRX(RobotMap.cargoExhaustRightID);
    // DoubleSolenoid intakeArm = new DoubleSolenoid(RobotMap.cargoArmInID, RobotMap.cargoArmOutID);
    AnalogInput cargoSwitch = new AnalogInput(RobotMap.cargoSwitchID);

  public CargoHandler() 
  {
    shooterRight.follow(shooterLeft);
    shooterRight.setInverted(true);
  }
  public void initDefaultCommand() 
  {

  }

  public void driveShooter(XboxController x) 
  {
    shooterLeft.set(x.getRawAxis(5));
  }
}