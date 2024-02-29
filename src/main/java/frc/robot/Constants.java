package frc.robot;

public class Constants {
    public static class IO {
        public static final int driverController = 0;
    }

    public static class IDs {
        public static final int leftLeader = 1;
        public static final int leftFollower = 2;
        public static final int rightLeader = 3;
        public static final int rightFollower = 4;
        public static final int launcher = 10;
        public static final int feeder = 11;
    }

    public static final double launchSpeedLauncher = 1.0;
    public static final double launchSpeedFeeder = launchSpeedLauncher;
    public static final double intakeSpeedLauncher = -0.3;
    public static final double intakeSpeedFeeder = intakeSpeedLauncher;
    public static final double launchDelay = 1.875;
}
