#include "WPILib.h"

class Robot: public IterativeRobot
{
	VictorSP *frontLeft;
	VictorSP *frontRight;
	VictorSP *backLeft;
	VictorSP *backRight;

	Joystick *joystick;
	RobotDrive *drive;
public:
	Robot() {
		frontLeft = new VictorSP(0);
		frontRight = new VictorSP(1);
		backLeft = new VictorSP(2);
		backRight = new VictorSP(3);
		joystick = new Joystick(0);
		drive = new RobotDrive(frontLeft,frontRight,backLeft,backRight);
	}

	void AutonomousPeriodic()
	{
		drive->Drive(0.25,0.0);
	}

	void TeleopPeriodic()
	{
		drive->ArcadeDrive(joystick);
	}
};

START_ROBOT_CLASS(Robot)
