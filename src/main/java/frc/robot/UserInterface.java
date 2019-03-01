package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class UserInterface 
{
    private XboxController driveController = new XboxController(0);
    private XboxController mechController = new XboxController(1);
    public JoystickButton a = new JoystickButton(driveController, 1);
    private JoystickButton b= new JoystickButton(mechController, 2);
    private JoystickButton x = new JoystickButton(mechController, 3);
    private JoystickButton y = new JoystickButton(mechController, 4);
    private JoystickButton leftBumper = new JoystickButton(mechController, 5);
    private JoystickButton rightBumper = new JoystickButton(mechController, 6);
    private JoystickButton back = new JoystickButton(mechController, 7);
    private JoystickButton start = new JoystickButton(mechController, 8);
    private JoystickButton leftStick = new JoystickButton(mechController, 9);
    private JoystickButton rightStick = new JoystickButton(mechController, 10);


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
