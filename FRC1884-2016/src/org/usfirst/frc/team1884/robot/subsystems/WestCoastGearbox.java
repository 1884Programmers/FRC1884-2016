package org.usfirst.frc.team1884.robot.subsystems;

import org.usfirst.frc.team1884.robot.nexus.NEXUS;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;

public class WestCoastGearbox implements Subsystem {
	public static final int leftSideChannel = 0;
	public static final int rightSideChannel = 1;


	public static WestCoastGearbox INSTANCE;

	static {
		INSTANCE  = new WestCoastGearbox();
	}

	RobotDrive drive;
	VictorSP rightSide, leftSide;
	DoubleSolenoid outputPush, pTOPush;
	Joystick joystick;
	boolean toutput = false;

	boolean tpTO = false;

	long timeOfLastExtensionoutput = Long.MAX_VALUE;
	long timeOfLastExtensionpTO = Long.MAX_VALUE;

	long lastoutputButtonExtend = 0;
	long lastoutputButtonRetract = 0;
	long lastpTOButtonExtend = 0;
	long lastpTOButtonRetract = 0;

	private WestCoastGearbox() {
    	leftSide = new VictorSP(0);
    	rightSide = new VictorSP(1);

    	drive = new RobotDrive(leftSide, rightSide);

    	outputPush = new DoubleSolenoid(0,1);
    	pTOPush = new DoubleSolenoid(2,3);

		joystick = NEXUS.JOYSTICK;
	}

	public void autonomousInit() {

	}

	public void autonomousPeriodic() {

	}

	public void teleopInit() {

	}

	public void teleopPeriodic() {
		drive.arcadeDrive(joystick);


    	if(joystick.getRawButton(1) && outputPush.get() == DoubleSolenoid.Value.kOff && System.currentTimeMillis() - lastoutputButtonExtend > 200) {
    		outputPush.set(DoubleSolenoid.Value.kForward);
    		lastoutputButtonExtend = System.currentTimeMillis();
    		timeOfLastExtensionoutput = System.currentTimeMillis();
    	}
    	if(joystick.getRawButton(2) && pTOPush.get() == DoubleSolenoid.Value.kOff && System.currentTimeMillis() - lastpTOButtonExtend > 200) {
    		pTOPush.set(DoubleSolenoid.Value.kForward);
    		lastpTOButtonExtend = System.currentTimeMillis();
    		timeOfLastExtensionpTO = System.currentTimeMillis();
    	}
    	if(joystick.getRawButton(3) && outputPush.get() == DoubleSolenoid.Value.kOff && System.currentTimeMillis() - lastoutputButtonRetract > 200) {
    		outputPush.set(DoubleSolenoid.Value.kReverse);
    		lastoutputButtonRetract = System.currentTimeMillis();
    		timeOfLastExtensionoutput = System.currentTimeMillis();
    	}
    	if(joystick.getRawButton(4) && pTOPush.get() == DoubleSolenoid.Value.kOff && System.currentTimeMillis() - lastpTOButtonRetract > 200) {
    		tpTO = !tpTO;
    		pTOPush.set(DoubleSolenoid.Value.kReverse);
    		lastpTOButtonRetract = System.currentTimeMillis();
    		timeOfLastExtensionpTO = System.currentTimeMillis();
    	}


    	if (System.currentTimeMillis() - timeOfLastExtensionoutput > 1000) {
    		outputPush.set(DoubleSolenoid.Value.kOff);
    		timeOfLastExtensionoutput = Long.MAX_VALUE;
    	}
    	if (System.currentTimeMillis() - timeOfLastExtensionpTO > 1000) {
    		pTOPush.set(DoubleSolenoid.Value.kOff);
    		timeOfLastExtensionpTO = Long.MAX_VALUE;
    	}
	}
}
