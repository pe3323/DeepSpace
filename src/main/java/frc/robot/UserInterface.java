package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class UserInterface 
{
    private XboxController driveController = new XboxController(0);
    private XboxController mechController = new XboxController(1);
    JoystickButton outButton = new JoystickButton(driveController, 4);
    JoystickButton inButton = new JoystickButton(driveController, 1);

    public UserInterface()
    {
        
    }

    public XboxController getDriveControl()
    {
        return  driveController;
    }

    public XboxController getMechControl()
    {
        return mechController;
    }
}
