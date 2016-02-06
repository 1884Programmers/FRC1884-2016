package org.usfirst.frc.team1884.robot.subsystems;

import org.usfirst.frc.team1884.robot.nexus.NEXUS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
/**
 *  Max and Axel's Hanger
 */

public class Hanger implements Subsystem {
  public static final Hanger INSTANCE;

  private static final int HANGINGBUTTON = 8;
  private boolean hasHung = false;
  private static final int MOTORCHANNEL = 5;
  private static final int ENCODERCHANNELA = 0;
  private static final int ENCODERCHANNELB = 1;

  private Joystick joystick;
  private CANTalon motor;
  private Encoder encoder;

  static {
    INSTANCE = new Hanger();
  }

  private Hanger() {
    joystick = NEXUS.JOYSTICK;
    motor = new CANTalon(MOTORCHANNEL);
    encoder = new Encoder(ENCODERCHANNELA, ENCODERCHANNELB);
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
  }
}
