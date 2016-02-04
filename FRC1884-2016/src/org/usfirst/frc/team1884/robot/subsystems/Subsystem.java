package org.usfirst.frc.team1884.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;

public interface Subsystem {
  public void autonomousInit();
  public void autonomousPeriodic();
  public void teleopInit();
  public void teleopPeriodic();
}
