package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class LauncherSubsystem {

    private final PWMSparkMax launchMotor;
    private final PWMSparkMax feedMotor;

    /**
     * 
     * @param launcher
     * @param feeder
     */
    public LauncherSubsystem(int launcher, int feeder) {
        launchMotor = new PWMSparkMax(launcher);
        feedMotor = new PWMSparkMax(feeder);

        launchMotor.setExpiration(250);
        feedMotor.setExpiration(250);

        launchMotor.setInverted(false);
        feedMotor.setInverted(false);
    }

    /**
     * runs top/launcher motor at decimal amount
     * 
     * @param percent between -1.0 and 1.0
     */
    public void setLaunchPercent(double percent) {
        launchMotor.set(percent);
    }

    /**
     * runs bottom/feeder motor at decimal amount
     * 
     * @param percent between -1.0 and 1.0
     */
    public void setFeedPercent(double percent) {
        feedMotor.set(percent);
    }

    /** coasts both launch and feed motor by setting the volts to 0.0 */
    public void coast() {
        launchMotor.setVoltage(0.0);
        feedMotor.setVoltage(0.0);
    }
}
