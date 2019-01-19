package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.UserInterface;
import frc.robot.drivetrain.DriveBase;



public class Robot extends TimedRobot 
{

  UserInterface ui = new UserInterface();
  DriveBase drivetrain = new DriveBase();
  DoubleSolenoid  solie = new DoubleSolenoid(1, 2);
 // Shuffleboard shuffie = new Shuffleboard(); For Sean's Favorite Shuffle on the Board
  
  public void robotInit() 
  {

  }

  public void robotPeriodic() 
  {

  }
  
  public void autonomousInit() 
  {

  }

  public void autonomousPeriodic() 
  {
    
  }

  public void teleopInit() 
  {
    drivetrain.getEncoderLeft().reset();
    solie.set(Value.kOff);
  }

  public void teleopPeriodic() 
  {
    drivetrain.getDriveTrain().arcadeDrive(-ui.getDriveControl().getRawAxis(1), ui.getDriveControl().getRawAxis(0));
    drivetrain.getEncoderLeft().getDistance(); 

    if(ui.outButton.get())
    {
    solie.set(Value.kForward);
    }
    if(ui.inButton.get())
    {
    solie.set(Value.kReverse);
    }
    

  }
}
// this page is for the entire robot. teleopPeriodic is for teleop periodiacally in the driverstation. 