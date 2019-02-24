package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.UserInterface;
import frc.robot.cargohandler.CargoHandler;
import frc.robot.drivetrain.DriveBase;
import frc.robot.hatchmanipulator.HatchManipulator;



public class Robot extends TimedRobot 
{
  DriveBase drivetrain = new DriveBase(928);
  UserInterface ui = new UserInterface();
  CargoHandler cargoHandler = new CargoHandler();
<<<<<<< HEAD
  // HatchManipulator hatchManipulator = new HatchManipulator();
=======
  HatchManipulator hatchManipulator = new HatchManipulator();
>>>>>>> b58be74610290e890fe278b54d3068f2919ece88
  
  public void robotInit() 
  {
    CameraServer.getInstance().startAutomaticCapture();
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
    drivetrain.drive(ui.getDriveControl().getRawAxis(1), ui.getDriveControl().getRawAxis(0));
    drivetrain.log();
    cargoHandler.driveShooter(ui.getDriveControl());
  }

  public void teleopInit() 
  {
    
  }

  public void teleopPeriodic() 
  {
    drivetrain.drive(ui.getDriveControl().getRawAxis(1), ui.getDriveControl().getRawAxis(0));
    drivetrain.log();
    cargoHandler.driveShooter(ui.getDriveControl());
  }
}
// this page is for the entire robot. teleopPeriodic is for teleop periodiacally in the driverstation. 