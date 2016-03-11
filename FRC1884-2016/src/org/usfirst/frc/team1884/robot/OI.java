package org.usfirst.frc.team1884.robot;

import org.usfirst.frc.team1884.robot.autonomous.PortcullisRoutine;
import org.usfirst.frc.team1884.robot.commands.Aim;
import org.usfirst.frc.team1884.robot.commands.AimInterrupt;
import org.usfirst.frc.team1884.robot.commands.defense_manipulator.FlipperDown;
import org.usfirst.frc.team1884.robot.commands.defense_manipulator.FlipperUp;
import org.usfirst.frc.team1884.robot.commands.shooter.ExpellBall;
import org.usfirst.frc.team1884.robot.triggers.ExpellBallAuto;
import org.usfirst.frc.team1884.robot.triggers.LeftTrigger;
import org.usfirst.frc.team1884.robot.triggers.PortcullisChosen;
import org.usfirst.frc.team1884.robot.triggers.RightTrigger;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick driveStick = NEXUS.DRIVESTICK, opStick = NEXUS.OPERATORSTICK;
	JoystickButton opButton1 = new JoystickButton(opStick, 1);
	JoystickButton button5 = new JoystickButton(opStick, 5), button6 = new JoystickButton(opStick, 6);
	Trigger portcullisChosen = new PortcullisChosen();
	Trigger expellBallAuto = new ExpellBallAuto();
	Trigger driveLeftTrigger = new LeftTrigger(0);
	Trigger driveRightTrigger = new RightTrigger(0);

	public OI() {
		button5.whenPressed(new FlipperDown());
		button6.whenPressed(new FlipperUp());
		portcullisChosen.whenActive(new PortcullisRoutine());
		expellBallAuto.whenActive(new ExpellBall());
		driveLeftTrigger.whenActive(new Aim());
		driveRightTrigger.whenActive(new AimInterrupt());
	}
}
