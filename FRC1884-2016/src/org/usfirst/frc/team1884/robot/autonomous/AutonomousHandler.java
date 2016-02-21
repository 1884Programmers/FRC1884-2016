package org.usfirst.frc.team1884.robot.autonomous;

import org.usfirst.frc.team1884.robot.subsystems.WestCoastGearbox;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousHandler {

	private Position posCommand;
	private SendableChooser posChooser;

	private Defense defCommand;
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
		defChooser.addDefault("Portcullis", new Defense(Defense.PORTCULLIS));
		defChooser.addObject("Cheval de Frise", new Defense(Defense.CHEVALDEFRISE));
		defChooser.addObject("Moat", new Defense(Defense.MOAT));
		defChooser.addObject("Ramparts", new Defense(Defense.RAMPARTS));
		defChooser.addObject("Drawbridge", new Defense(Defense.DRAWBRIDGE));
		defChooser.addObject("Sally Port", new Defense(Defense.SALLYPORT));
		defChooser.addObject("Rock Wall", new Defense(Defense.ROCKWALL));
		defChooser.addObject("Rough Terrain", new Defense(Defense.ROUGHTERRAIN));
		SmartDashboard.putData("Defense Chooser", defChooser);
	}

	public void autonomousInit() {
		posCommand = (Position) posChooser.getSelected();
		defCommand = (Defense) defChooser.getSelected();
		WestCoastGearbox.INSTANCE.secureGearShift();
		defCommand.start();
		posCommand.start();
	}
}
