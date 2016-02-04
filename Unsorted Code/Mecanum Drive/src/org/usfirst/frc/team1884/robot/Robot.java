package org.usfirst.frc.team1884.robot;


import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

/**
 * This is a demo program showing how to use Mecanum control with the RobotDrive class.
 */
public class Robot extends IterativeRobot {
	
    CANTalon frontLeft, frontRight, backLeft, backRight;
    Joystick joystick;

    // Channels for the wheels
    final int frontLeftChannel	= 6;
    final int backLeftChannel	= 3;
    final int frontRightChannel	= 4;
    final int backRightChannel	= 5;
    
    // The channel on the driver station that the joystick is connected to
    final int joystickChannel	= 0;

    public Robot() {
        frontLeft = new CANTalon(frontLeftChannel);
        frontRight = new CANTalon(frontRightChannel);
        backLeft = new CANTalon(backLeftChannel);
        backRight = new CANTalon(backRightChannel);
        
        joystick = new Joystick(joystickChannel);
    }
        

    public void teleopPeriodic() {
    	double y_magnitude = joystick.getY();
    	double x_magnitude = joystick.getX();
    	double z_magnitude = joystick.getRawAxis(5);
    	
    	frontLeft.set((-y_magnitude-x_magnitude-z_magnitude)/10);
    	frontRight.set((y_magnitude-x_magnitude-z_magnitude)/10);
    	backLeft.set((-y_magnitude+x_magnitude-z_magnitude)/10);
    	backRight.set((-y_magnitude-x_magnitude+z_magnitude)/10);
    }
    
}
