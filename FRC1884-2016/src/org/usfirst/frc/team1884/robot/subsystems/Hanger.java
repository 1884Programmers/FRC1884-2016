package org.usfirst.frc.team1884.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
/**
 *  Max and Gavin's Hanger
 */

public class Hanger implements Subsystem {
  public static final Hanger INSTANCE;

  private static final int HANGINGBUTTON = 8;
  private boolean hasHung = false;
  //Motor channels
  //Encoder channels

  private Joystick joystick;
  //Motor controllers (Talons)
  //Encoders

  static {
    INSTANCE = new Hanger();
  }

  private Hanger() {
    joystick = NEXUS.JOYSTICK;
    //initializations
  }

  public void teleopInit() {
    //TODO (probably nothing)
  }
  public void teleopPeriodic() {
    if(joystick.getRawButton(HANGINGBUTTON)) {
      hang();
      hasHung = true;
    }
  }
  public void autonomousInit() {
    System.out.println("You numpty! Why are you hanging in autonomous?!");
  }
  public void autonomousPeriodic() {
    System.out.println("You numpty! Why are you hanging in autonomous?!");
  }

  private void hang() {
    //Debug code
    System.out.println("Hanging");

    //TODO
  }
}
