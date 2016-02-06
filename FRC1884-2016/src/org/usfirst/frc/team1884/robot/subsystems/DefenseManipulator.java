public class DefenseManipulator implements Subsystem {
  public static final DefenseManipulator INSTANCE;
  //motor channels in private static final ints
  //encoder channels

  private Joystick joystick;
  //Motor controllers (Talons)
  //Encoders


  static {
    INSTANCE = new DefenseManipulator();
  }

  private DefenseManipulator() {
    joystick = NEXUS.JOYSTICK;
  }

  public void teleopInit() {
    //TODO
  }

  public void teleopPeriodic() {
    //TODO
  }

  public void autonomousInit() {
    //TODO
  }

  public void autonomousPeriodic() {
    //TODO
  }
}
