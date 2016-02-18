#include "WPILib.h"

class Robot: public IterativeRobot {
	CANJaguar *frontLeft;
	CANJaguar *frontRight;
	CANJaguar *backLeft;
	CANJaguar *backRight;

	Joystick *joystick;
	RobotDrive *drive;
public:
	Robot() {
		frontLeft = new CANJaguar(0);
		frontRight = new CANJaguar(1);
		backLeft = new CANJaguar(2);
		backRight = new CANJaguar(3);
		joystick = new Joystick(0);
		drive = new RobotDrive(frontLeft,frontRight,backLeft,backRight);
	}

	void AutonomousPeriodic() {
		drive->Drive(0.25, 0.0);
	}

	void TeleopPeriodic() {
		drive->ArcadeDrive(joystick);
	}
};

START_ROBOT_CLASS(Robot)
