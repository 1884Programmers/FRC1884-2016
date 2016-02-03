package org.usfirst.frc.team1884.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;

public class WestCoastGearbox {
	public static WestCoastGearbox instance = new WestCoastGearbox();

	RobotDrive drive;
	VictorSP rightSide, leftSide;
	DoubleSolenoid outputPush, PTOPush;
	Joystick joystick;
	boolean toutput = false;

	boolean tPTO = false;

	long timeOfLastExtensionoutput = Long.MAX_VALUE;
	long timeOfLastExtensionPTO = Long.MAX_VALUE;

	long lastoutputButtonExtend = 0;
	long lastoutputButtonRetract = 0;
	long lastPTOButtonExtend = 0;
	long lastPTOButtonRetract = 0;

	private WestCoastGearbox() {
    	leftSide = new VictorSP(0);
    	rightSide = new VictorSP(1);

    	drive = new RobotDrive(leftSide, rightSide);

    	outputPush = new DoubleSolenoid(0,1);
    	PTOPush = new DoubleSolenoid(2,3);
	}

	public void setJoystick(Joystick joystick) {
		this.joystick = joystick;
	}

	public void teleopPeriodic() {
		drive.arcadeDrive(joystick);


    	if(joystick.getRawButton(1) && outputPush.get() == DoubleSolenoid.Value.kOff && System.currentTimeMillis() - lastoutputButtonExtend > 200) {
    		outputPush.set(DoubleSolenoid.Value.kForward);
    		lastoutputButtonExtend = System.currentTimeMillis();
    		timeOfLastExtensionoutput = System.currentTimeMillis();
    	}
    	if(joystick.getRawButton(2) && PTOPush.get() == DoubleSolenoid.Value.kOff && System.currentTimeMillis() - lastPTOButtonExtend > 200) {
    		PTOPush.set(DoubleSolenoid.Value.kForward);
    		lastPTOButtonExtend = System.currentTimeMillis();
    		timeOfLastExtensionPTO = System.currentTimeMillis();
    	}
    	if(joystick.getRawButton(3) && outputPush.get() == DoubleSolenoid.Value.kOff && System.currentTimeMillis() - lastoutputButtonRetract > 200) {
    		outputPush.set(DoubleSolenoid.Value.kReverse);
    		lastoutputButtonRetract = System.currentTimeMillis();
    		timeOfLastExtensionoutput = System.currentTimeMillis();
    	}
    	if(joystick.getRawButton(4) && PTOPush.get() == DoubleSolenoid.Value.kOff && System.currentTimeMillis() - lastPTOButtonRetract > 200) {
    		tPTO = !tPTO;
    		PTOPush.set(DoubleSolenoid.Value.kReverse);
    		lastPTOButtonRetract = System.currentTimeMillis();
    		timeOfLastExtensionPTO = System.currentTimeMillis();
    	}


    	if (System.currentTimeMillis() - timeOfLastExtensionoutput > 1000) {
    		outputPush.set(DoubleSolenoid.Value.kOff);
    		timeOfLastExtensionoutput = Long.MAX_VALUE;
    	}
    	if (System.currentTimeMillis() - timeOfLastExtensionPTO > 1000) {
    		PTOPush.set(DoubleSolenoid.Value.kOff);
    		timeOfLastExtensionPTO = Long.MAX_VALUE;
    	}
	}
}
