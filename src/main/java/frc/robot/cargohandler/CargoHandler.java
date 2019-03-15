package frc.robot.cargohandler;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;




public class CargoHandler
  extends Subsystem
{
  WPI_VictorSPX intake = new WPI_VictorSPX(5);
  WPI_VictorSPX shooterLeft = new WPI_VictorSPX(8);
  WPI_VictorSPX shooterRight = new WPI_VictorSPX(9);
  WPI_TalonSRX intakeArm = new WPI_TalonSRX(10);
  DigitalInput cargoInShooter = new DigitalInput(9);
  DigitalInput cargoInFondler = new DigitalInput(0);
  AnalogInput armPot = new AnalogInput(0);
  
  public CargoHandler()
  {
    shooterRight.follow(shooterLeft);
    shooterRight.setInverted(true);
  }

  public void manualControl(XboxController x) 
  {
    intakeArm.set(x.getRawAxis(5));
  }

  public void getPot() 
  {
    System.out.println(armPot.getValue());
  }
  

  public void initDefaultCommand() {}
  
  public IntakeCargo getIntakeCargo() {
    return new IntakeCargo(this);
  }
  
  public PickupCargo getPickupCargo()
  {
    return new PickupCargo(this);
  }
  
  public ShootCargo getShootCargo()
  {
    return new ShootCargo(this);
  }
}
