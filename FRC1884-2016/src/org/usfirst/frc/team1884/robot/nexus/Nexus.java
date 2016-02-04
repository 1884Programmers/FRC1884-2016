package org.usfirst.frc.team1884.robot.nexus;

import org.usfirst.frc.team1884.robot.sensors.UltrasonicSensor;

import edu.wpi.first.wpilibj.Joystick;

public class Nexus {
  private UltrasonicSensor ultron;
  private Joystick joystick;

  public Nexus(UltrasonicSensor ultron, Joystick joystick) {
    this.ultron = ultron;
    this.joystick = joystick;
  }

  //public double queryJoystick()
  //public double queryUltrosonicSensor()
}
