package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

public final class Main 
{
  private Main() 
  {

  }
  //this is the main method
  public static void main(String... args) 
  {
    RobotBase.startRobot(Robot::new);
  }
}