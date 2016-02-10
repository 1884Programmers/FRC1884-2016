package org.usfirst.frc.team1884.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousHandler {

	private Command posCommand;
	private SendableChooser posChooser;

	private Command defCommand;
	private SendableChooser defChooser;

	public static AutonomousHandler INSTANCE;

	public void bar() {
	}

	static {
		INSTANCE = new AutonomousHandler();
	}

	private AutonomousHandler() {
		posChooser = new SendableChooser();
		posChooser.addDefault("1", new Position(1));
		posChooser.addObject("2", new Position(2));
		posChooser.addObject("3", new Position(3));
		posChooser.addObject("4", new Position(4));
		SmartDashboard.putData("Position Chooser", posChooser);
		defChooser = new SendableChooser();
		defChooser.addDefault("Portcullis", new Defense(1));
		defChooser.addObject("Cheval de Frise", new Defense(2));
		defChooser.addObject("Moat", new Defense(3));
		defChooser.addObject("Ramparts", new Defense(4));
		defChooser.addObject("Drawbridge", new Defense(5));
		defChooser.addObject("Sally Port", new Defense(6));
		defChooser.addObject("Rock Wall", new Defense(7));
		defChooser.addObject("Rough Terrain", new Defense(8));
		SmartDashboard.putData("Defense Chooser", defChooser);
	}

	public void autonomousPeriodic() {
		posCommand = (Command) posChooser.getSelected();
		posCommand.start();
		defCommand = (Command) defChooser.getSelected();
		defCommand.start();
	}

}
