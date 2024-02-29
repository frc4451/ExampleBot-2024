package frc.robot;

import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Launcher;

public class RobotContainer {
        // Creates a static (only one) final (cannot be changed) instance of the Drive and Launcher classes

        public static final Drive drive = new Drive(
                        Constants.IDs.leftLeader,
                        Constants.IDs.leftFollower,
                        Constants.IDs.rightLeader,
                        Constants.IDs.rightFollower);
        public static final Launcher launcher = new Launcher(
        Constants.IDs.launcher,
        Constants.IDs.feeder);
}
