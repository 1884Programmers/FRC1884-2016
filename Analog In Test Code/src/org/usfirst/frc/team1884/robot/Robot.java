package org.usfirst.frc.team1884.robot;

<<<<<<< HEAD:Analog In Test Code/src/org/usfirst/frc/team1884/robot/Robot.java
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
=======
import org.usfirst.frc.team1884.robot.autonomous.AutoChooser;
import org.usfirst.frc.team1884.robot.autonomous.EasyAutonomous;
import org.usfirst.frc.team1884.robot.deprecated.AutonomousHandler;
import org.usfirst.frc.team1884.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
>>>>>>> master:FRC1884-2016/src/org/usfirst/frc/team1884/robot/Robot.java

public class Robot extends IterativeRobot {
<<<<<<< HEAD:Analog In Test Code/src/org/usfirst/frc/team1884/robot/Robot.java
	
	AnalogInput lightSensor = new AnalogInput(0);
	
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        System.out.println(lightSensor.getVoltage());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
=======

	public static OI oi;

	CameraServer server;
	Joystick opJoystick;

	JoystickButton opButton1;
	JoystickButton opButton2;
	Command auto;

	public void robotInit() {
		oi = new OI();
		opJoystick = NEXUS.OPERATORSTICK;
		
		server = CameraServer.getInstance();
		server.setQuality(50);
		server.startAutomaticCapture("cam0");
		auto = new EasyAutonomous();
		AutoChooser.setup();
	}

	/**
	 * This function is called once at the beginning of autonomous
	 */
	public void autonomousInit() {
		AutoChooser.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called once at the beginning of operator control
	 */
	public void teleopInit() {
		Elevator.INSTANCE.teleopInit();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
>>>>>>> master:FRC1884-2016/src/org/usfirst/frc/team1884/robot/Robot.java
}
