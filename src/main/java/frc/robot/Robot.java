package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;

public class Robot extends TimedRobot {
  private final XboxController m_driverController = new XboxController(Constants.IO.driverController);
  private static Timer timer;
  private int autoStep;

  public Robot() {
  }

  @Override
  public void robotInit() {
  }

  @Override
  public void teleopPeriodic() {
    RobotContainer.drive.driveCurve(
        Math.pow(MathUtil.applyDeadband(-m_driverController.getLeftY(), 0.1), 2),
        Math.pow(MathUtil.applyDeadband(m_driverController.getRightX(), 0.1), 2),
        m_driverController.getRightBumper());

    /*
     * Right Trigger: Intake mode when held
     * Left Trigger: Runs launcher motor when held
     * also runs feeder motor when right trigger is held
     * Left Bumper: Runs feeder motor when held
     * 
     * Ramp up feeder before launching.
     */
    if (m_driverController.getRightTriggerAxis() > 0.1) {
      if (m_driverController.getLeftTriggerAxis() > 0.1) {
        RobotContainer.launcher.setLaunchPercent(Constants.intakeSpeedLauncher);
        RobotContainer.launcher.setFeedPercent(Constants.intakeSpeedFeeder);
      }
    } else {
      if (m_driverController.getLeftTriggerAxis() > 1) {
        RobotContainer.launcher.setLaunchPercent(Constants.launchSpeedLauncher);
      }
      if (m_driverController.getLeftBumper()) {
        RobotContainer.launcher.setFeedPercent(Constants.launchSpeedFeeder);
      }
    }
  }

  @Override
  public void autonomousInit() {
    timer = new Timer();
    autoStep = 0;
  }

  @Override
  public void autonomousPeriodic() {

    /*
     * This is a form of switch statement using case A -> {methodCall1(); methodCall2()}.
     * An advantage is that you don't need to write so many breaks.
     * If you are only calling one method it would be as follows:
     * case B -> methodCall();
     * case D -> methodCall();
     */
    switch (autoStep) {
      case 0 -> {
        timer.restart();
        RobotContainer.launcher.setLaunchPercent(1);
        autoStep++;
      }
      case 1 -> {
        if (timer.get() > 1.5) {
          RobotContainer.launcher.setFeedPercent(1);
          autoStep++;
        }
      }
      case 2 -> {
        if (timer.get() > 3.0) {
          RobotContainer.launcher.coast();
          RobotContainer.drive.setPercent(0.4, 0.4); // TODO: Adjust percent output as necessary
          autoStep++;
        }
      }
      case 3 -> {
        if(timer.get() > 3.5) // TODO: Adjust time as necessary
        RobotContainer.drive.setPercent(0.0, 0.0);
      }
      default -> {
        RobotContainer.launcher.coast();
        RobotContainer.drive.setPercent(0, 0);
      }
    }
  }
}
