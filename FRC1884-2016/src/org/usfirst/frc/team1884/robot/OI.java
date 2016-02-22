package org.usfirst.frc.team1884.robot;

import org.usfirst.frc.team1884.robot.commands.defense_manipulator.FlipperDown;
import org.usfirst.frc.team1884.robot.commands.defense_manipulator.FlipperSequence;
import org.usfirst.frc.team1884.robot.commands.defense_manipulator.FlipperUp;
import org.usfirst.frc.team1884.robot.triggers.POVDownOp;
import org.usfirst.frc.team1884.robot.triggers.POVUpOp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick driveStick = NEXUS.DRIVESTICK, opStick = NEXUS.OPERATORSTICK;
	JoystickButton button5 = new JoystickButton(opStick, 5), button6 = new JoystickButton(opStick, 6);
	Trigger opPOVUp = new POVUpOp();
	Trigger opPOVDown = new POVDownOp();
	
	public OI() {
//		opPOVUp.whenActive(new FlipperUp());
//		opPOVDown.whenActive(new FlipperDown());
		button5.whenPressed(new FlipperDown());
		button6.whenPressed(new FlipperUp());
	}
}
