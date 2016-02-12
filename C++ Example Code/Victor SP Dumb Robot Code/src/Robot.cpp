#include "WPILib.h"

class Robot: public IterativeRobot
{
	//Number of motor controllers the drive has
		const int numMotors = 2;

		//Ports if the drive has 2 controllers
		const int leftPort = 0;
		const int rightPort = 1;

		//Ports if the drive has 4 controllers
		const int frontLeftPort = 0;
		const int frontRightPort = 1;
		const int backLeftPort = 2;
		const int backRightPort = 3;

		VictorSP frontLeft;
		VictorSP frontRight;
		VictorSP backLeft;
		VictorSP backRight;

		Joystick joystick;
		RobotDrive drive;
public:

	void RobotInit()
	{
		if(numMotors == 2) {
			frontLeft(leftPort),
			frontRight(rightPort),
			drive(frontLeft,frontRight);
		} else {
			frontLeft(frontLeftPort),
			frontRight(frontRightPort),
			backLeft(backLeftPort),
			backRight(backRightPort),
			drive(frontLeft,frontRight,backLeft,backRight);
		}
		joystick(0);
	}


	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the GetString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the if-else structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
	void AutonomousInit()
	{

	}

	void AutonomousPeriodic()
	{
		drive.Drive(0.25,0.0);
	}

	void TeleopInit()
	{

	}

	void TeleopPeriodic()
	{
		drive.ArcadeDrive(joystick);
	}

	void TestPeriodic()
	{

	}
};

START_ROBOT_CLASS(Robot)
