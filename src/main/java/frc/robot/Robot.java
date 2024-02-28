package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

public class Robot extends TimedRobot {
  private final XboxController m_driverController = new XboxController(Constants.IO.driverController);

  public Robot() {
  }

  @Override
  public void robotInit() {
  }

  @Override
  public void teleopPeriodic() {
    RobotContainer.m_drive.driveCurve(
        MathUtil.applyDeadband(m_driverController.getLeftY(), 0.1),
        MathUtil.applyDeadband(m_driverController.getRightX(), 0.1),
        m_driverController.getAButton());

    // if (m_driverController.getLeftTrigger()) {
    // RobotContainer.m_launcher.setLaunchPercent(Constants.launchSpeedLauncher);
    // }
    // if (m_driverController.getRightBumper()) {
    // RobotContainer.m_launcher.setFeedPercent(Constants.intakeSpeedFeeder);
    // }
    // if (m_driverController.getLeftBumper()) {
    // RobotContainer.m_launcher.setFeedPercent(Constants.intakeSpeedLauncher);
    // }
    // if (m_driverController.getRightTrigger()) {
    // RobotContainer.m_launcher.setLaunchPercent(Constants.launchSpeedFeeder);
    // }
  }
}
