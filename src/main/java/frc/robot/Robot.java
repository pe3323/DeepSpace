package frc.robot;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.UserInterface;
import frc.robot.cargohandler.CargoHandler;
import frc.robot.drivetrain.DriveBase;
import frc.robot.elevator.Elevator;
import frc.robot.hatchmanipulator.HatchManipulator;



public class Robot extends TimedRobot 
{
  DriveBase drivetrain = new DriveBase(928);
  UserInterface ui = new UserInterface();
  CargoHandler cargoHandler = new CargoHandler();
  // HatchManipulator hatchManipulator = new HatchManipulator();
  Elevator elevator = new Elevator();
  
  public void robotInit() 
  {
  SmartDashboard.putNumber("drive", 0);
  SmartDashboard.putNumber("turn", 0);
  }

  public void robotPeriodic() 
  {
    Scheduler.getInstance().run();
  }
  
  public void autonomousInit() 
  {

  }

  public void autonomousPeriodic() 
  {
    boolean semiAuto;
    double driveConstant = SmartDashboard.getNumber("drive", 0);
    double turnConstant = SmartDashboard.getNumber("turn", 0);
    double vertOffset = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
    double horzOffset = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
    
    if(ui.a.get())
    {
        drivetrain.drive(vertOffset*driveConstant, horzOffset*turnConstant);
        semiAuto = true;
    }
    else
    {
    drivetrain.drive(ui.getDriveControl().getRawAxis(1), ui.getDriveControl().getRawAxis(0));
    semiAuto = false;
    }
    SmartDashboard.putBoolean("Semi Auto", semiAuto);
  }

  public void teleopInit() 
  {
    
  }

  public void teleopPeriodic() 
  {
    drivetrain.drive(ui.getDriveControl().getRawAxis(1), ui.getDriveControl().getRawAxis(0));
    drivetrain.log();
    cargoHandler.manualControl(ui.getMechControl(), 0);
    elevator.manualControl(ui.getMechControl(), 1);
    
  }
}
// this page is for the entire robot. teleopPeriodic is for teleop periodiacally in the driverstation. 