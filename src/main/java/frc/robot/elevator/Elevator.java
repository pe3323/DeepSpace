package frc.robot.elevator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class Elevator
  extends Subsystem
{
  WPI_VictorSPX elevatorFollower = new WPI_VictorSPX(6);
  WPI_TalonSRX elevatorMain = new WPI_TalonSRX(7);
  DigitalInput pos0Switch = new DigitalInput(6);
  DigitalInput pos1Switch = new DigitalInput(7);
  DigitalInput pos2Switch = new DigitalInput(1);
  DigitalInput pos3Switch = new DigitalInput(10);
  Encoder elevatorEncoder = new Encoder(4, 5);
  
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
  


  public void initDefaultCommand() {}
  

  public void home()
  {
    elevatorEncoder.reset();
  }
  
  public void manualControl(XboxController x, int axis)
  {
    if ((pos0Switch.get()) && (x.getRawAxis(axis) > 0.0D))
    {

      elevatorMain.set(0.0D);
    }
    else {
      elevatorMain.set(x.getRawAxis(1));
    }
    SmartDashboard.putNumber("Elevator", elevatorMain.get());
  }
}
