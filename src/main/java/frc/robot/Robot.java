package frc.robot;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.cargohandler.CargoHandler;
import frc.robot.drivetrain.DriveBase;
import frc.robot.elevator.Elevator;
import frc.robot.hatchmanipulator.HatchManipulator;

public class Robot extends TimedRobot
{
  DriveBase drivetrain = new DriveBase(928);
  CargoHandler cargoHandler = new CargoHandler();
  HatchManipulator hatchManipulator = new HatchManipulator();
  Elevator elevator = new Elevator();
  UserInterface ui = new UserInterface(cargoHandler);

  
  public Robot() {}
  
  public void robotInit() {
    SmartDashboard.putNumber("drive", -0.05D);
    SmartDashboard.putNumber("turn", 0.1D);
  }
  
  public void robotPeriodic()
  {
    Scheduler.getInstance().run();
  }
  


  public void autonomousInit() {}
  


  public void autonomousPeriodic()
  {
    cargoHandler.manualControl(ui.getMechControl());
    cargoHandler.getPot();
  }
  

  public void teleopInit() {}
  

  public void teleopPeriodic()
  {
    boolean semiAuto;
    
    if (ui.a.get())
    {
      autoAlign();
      semiAuto = true;
    }
    else
    {
      drivetrain.drive(ui.getDriveControl().getRawAxis(1), ui.getDriveControl().getRawAxis(0));
      semiAuto = false;
    }
    SmartDashboard.putBoolean("Semi Auto", semiAuto);
    
    drivetrain.log();
    elevator.manualControl(ui.getMechControl(), 1);
    
    cargoHandler.getPot();
  }
  
  public void autoAlign()
  {
    double driveConstant = SmartDashboard.getNumber("drive", 0.0D);
    double turnConstant = SmartDashboard.getNumber("turn", 0.0D);
    double vertOffset = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0.0D);
    double horzOffset = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0.0D);
    
    drivetrain.drive(vertOffset * driveConstant, horzOffset * turnConstant);
  }
}


