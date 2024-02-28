package frc.robot;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LauncherSubsystem;

public class RobotContainer {
        public static final DriveSubsystem m_drive = new DriveSubsystem(
                        Constants.IDs.leftLeader,
                        Constants.IDs.rightLeader,
                        Constants.IDs.leftFollower,
                        Constants.IDs.rightFollower);
        // public static final LauncherSubsystem m_launcher = new LauncherSubsystem(
        // Constants.IDs.launcher,
        // Constants.IDs.feeder);
}
