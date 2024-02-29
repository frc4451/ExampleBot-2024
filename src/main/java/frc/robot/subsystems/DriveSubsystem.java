package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

/** Add your docs here. */
public class DriveSubsystem {
    private final Spark leftLeader;
    private final Spark rightLeader;
    private final Spark leftFollower;
    private final Spark rightFollower;
    private final DifferentialDrive drive;

    /**
     * 
     * @param leftLeaderID
     * @param rightLeaderID
     * @param leftFollowerID
     * @param rightFollowerID
     */
    public DriveSubsystem(int leftLeaderID, int leftFollowerID, int rightLeaderID, int rightFollowerID) {
        leftLeader = new Spark(leftLeaderID);
        leftFollower = new Spark(leftFollowerID);
        rightLeader = new Spark(rightLeaderID);
        rightFollower = new Spark(rightFollowerID);
        // drive = new DifferentialDrive(leftLeader::set, rightLeader::set);
        drive = new DifferentialDrive(leftLeader::set, rightLeader::set);

        leftLeader.setExpiration(250);
        rightLeader.setExpiration(250);
        leftFollower.setExpiration(250);
        rightFollower.setExpiration(250);

        leftLeader.setInverted(false);
        leftFollower.setInverted(false);
        rightLeader.setInverted(true);
        rightFollower.setInverted(true);
        leftLeader.addFollower(leftFollower);
        rightLeader.addFollower(rightFollower);
    }

    /**
     * 
     * @param leftVolts  The voltage to output between -12.0 and 12.0.
     * @param rightVolts The voltage to output between -12.0 and 12.0.
     */
    // public void setVoltage(double leftVolts, double rightVolts) {
    // leftLeader.setVoltage(MathUtil.clamp(leftVolts, -12.0, 12.0));
    // rightLeader.setVoltage(MathUtil.clamp(rightVolts, -12.0, 12.0));
    // }

    /**
     * 
     * @param leftPercent  The speed value between -1.0 and 1.0 to set.
     * @param rightPercent The speed value between -1.0 and 1.0 to set.
     */
    // public void setPercent(
    // double leftPercent, double rightPercent) {
    // leftLeader.set(leftPercent);
    // rightLeader.set(rightPercent);
    // }

    public void driveCurve(double speed, double rotation, boolean allowTurnInPlace) {
        drive.curvatureDrive(speed, rotation, allowTurnInPlace);
    }

    public void driveArcade(double speed, double rotation) {
        drive.arcadeDrive(speed, rotation);
    }
}
