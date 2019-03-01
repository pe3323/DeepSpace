package frc.robot.elevator;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

public class GoToElev extends Command 
{
  Elevator elev;
  int pos = 0;
  int upperRange = 0;
  int lowerRange = 0;
  DigitalInput posSwitch = null;

  public GoToElev( Elevator elev, int pos) 
  {
    requires(elev);
    this.elev = elev;
    this.pos = pos;
  }

  protected void initialize() 
  {
    switch (pos) 
    {
      case 1:
        upperRange = elev.pos1RangeUpper;
        lowerRange = elev.pos1RangeLower;
        posSwitch = elev.pos1Switch;
        break;
      case 2:
        upperRange = elev.pos2RangeUpper;
        lowerRange = elev.pos2RangeLower;
        posSwitch = elev.pos2Switch;
        break;
      case 3:
      upperRange = elev.pos3RangeUpper;
      lowerRange = elev.pos3RangeLower;
      posSwitch = elev.pos3Switch;
        break;  
      default:
        break;
    }

  }
  
  protected void execute() 
  {
    if (elev.elevatorEncoder.get()>upperRange)
      {
        elev.elevatorMain.set(-1);
      }
    if (elev.elevatorEncoder.get()<lowerRange)
      {
        elev.elevatorMain.set(1);
      }
  }

  protected boolean isFinished() 
  {
    if (posSwitch.get())
    return true;
    else
    return false;
  }

  protected void end() 
  {
    elev.elevatorMain.set(0);
  }

  protected void interrupted() 
  {
    end();
  }
}