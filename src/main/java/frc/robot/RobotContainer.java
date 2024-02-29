package frc.robot;

import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {
        public static final DriveSubsystem drive = new DriveSubsystem(
                        Constants.IDs.leftLeader,
                        Constants.IDs.leftFollower,
                        Constants.IDs.rightLeader,
                        Constants.IDs.rightFollower);
        // public static final LauncherSubsystem m_launcher = new LauncherSubsystem(
        // Constants.IDs.launcher,
        // Constants.IDs.feeder);
}
