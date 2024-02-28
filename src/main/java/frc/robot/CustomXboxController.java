package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;

public class CustomXboxController extends XboxController {

        private final double joystickDeadband = 0.1;
        private final double triggerPressedThreshold = 0.1;

        /**
         * Construct an instance of a controller.
         *
         * @param port The port on Driver Station where the controller is connected.
         */
        public CustomXboxController(int port) {
            super(port);
        }

        /**
         * {@inheritDoc} (Processed with function below).
         *
         * @see #processJoystickValue
         */
        @Override
        public double getLeftX() {
            return this.processJoystickValue(super.getLeftX());
        }

        /**
         * {@inheritDoc} (Processed with function below).
         *
         * @see #processJoystickValue
         */
        @Override
        public double getLeftY() {
            return this.processJoystickValue(super.getLeftY());
        }

        /**
         * {@inheritDoc} (Processed with function below).
         *
         * @see #processJoystickValue
         */
        @Override
        public double getRightX() {
            return this.processJoystickValue(super.getRightX());
        }

        /**
         * {@inheritDoc} (Processed with function below).
         *
         * @see #processJoystickValue
         */
        @Override
        public double getRightY() {
            return this.processJoystickValue(super.getRightY());
        }

        public Boolean getLeftTrigger() {
            return this.getLeftTriggerAxis() > triggerPressedThreshold;
        }

        public Boolean getRightTrigger() {
            return this.getRightTriggerAxis() > triggerPressedThreshold;
        }

        /**
         * Processes joystick value like so: { (deadband(v)^2) * signum(v) }.<br>
         * The squaring is done to improve precision. The signum multiplication is to
         * get the negativeness
         * back (if it was there).
         *
         * @param value Value to process
         * @return Processed value
         */
        private double processJoystickValue(double value) {
            return Math.pow(applyJoystickDeadband(value), 2) * Math.signum(value);
        }

        /**
         * Applies a predefined deadband to a value. Meant for joysticks.
         *
         * @param stickValue Value of a joystick, usually [-1.0, 1.0]
         * @return Joystick's value with a deadband applied
         */
        private double applyJoystickDeadband(double stickValue) {
            return MathUtil.applyDeadband(stickValue, this.joystickDeadband);
        }
    }
