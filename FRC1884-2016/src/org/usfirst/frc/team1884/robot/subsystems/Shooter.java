package org.usfirst.frc.team1884.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;

public class Shooter implements Subsystem, Operated{
  public static final int shooterChannel = 0;
  public static final int internalIntakeChannel = 1;
  public static final int externalIntakeChannel = 2;

  public static final Shooter instance;

  static {
    instance = new Shooter();
  }

  private Joystick joystick;
  private CANTalon shooter, internalIntake, externalIntake;

  private Shooter() {
    shooter = new CANTalon(shooterChannel);
    internalIntake = new CANTalon(internalIntakeChannel);
    externalIntake = new CANTalon(externalIntakeChannel);

    shooter.enableBrakeMode(true);
    shooter.setControlMode(0);
    shooter.setFeedbackDevice(FeedbackDevice.QuadEncoder);

    internalIntake.enableBrakeMode(true);
    internalIntake.setControlMode(0);
    internalIntake.setFeedbackDevice(FeedbackDevice.QuadEncoder);

    externalIntake.enableBrakeMode(true);
    externalIntake.setControlMode(0);
    externalIntake.setFeedbackDevice(FeedbackDevice.QuadEncoder);
  }

  public void setJoystick(Joystick joystick) {
    this.joystick = joystick;
  }

  public void autonomousInit() {
    //TODO
  }

  public void autonomousPeriodic() {
    //TODO
  }

  public void teleopInit() {
    //TODO
  }

  public void teleopPeriodic() {
    //TODO
  }
}
