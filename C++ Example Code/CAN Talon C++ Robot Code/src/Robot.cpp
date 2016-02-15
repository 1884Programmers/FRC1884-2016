#include "WPILib.h"

class Robot: public IterativeRobot
{
		CANTalon *frontLeft;
		CANTalon *frontRight;
		CANTalon *backLeft;
		CANTalon *backRight;

		Joystick *joystick;
		RobotDrive *drive;
public:
	Robot() {
		frontLeft = new CANTalon(0);
		frontRight = new CANTalon(1);
		backLeft = new CANTalon(3);
		backRight = new CANTalon(4);
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
