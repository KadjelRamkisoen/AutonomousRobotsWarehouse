package agents;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.ev3.EV3UltrasonicSensor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.actuators.lego.motors.EV3MediumRegulatedMotor;
import ev3dev.sensors.Battery;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;
import ev3dev.sensors.ev3.EV3TouchSensor;
import ev3dev.sensors.ev3.EV3UltrasonicSensor;
//import jason.asSyntax.Literal;
import lejos.hardware.port.SensorPort;
import ev3dev.sensors.ev3.EV3ColorSensor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.Color;
import lejos.robotics.SampleProvider;

public class Device {
    static EV3LargeRegulatedMotor motor_left = null;
    static EV3LargeRegulatedMotor motor_right = null;
  //  static EV3UltrasonicSensor sensor_sonic = null;

    public static void init() {
        System.out.println("Init starts");
       // Delay.msDelay(6000);
        motor_left = new EV3LargeRegulatedMotor(MotorPort.B);
        motor_right = new EV3LargeRegulatedMotor(MotorPort.C);
       // sensor_sonic = new EV3UltrasonicSensor(SensorPort.S3);
        System.out.println("Init finishes");

    }

    public static void stop() {
        motor_left.stop();
        motor_right.stop();
    }

    public static void backward() {
        motor_left.backward();
        motor_right.backward();
    }

    public static void forward() {
        motor_left.forward();
        motor_right.forward();
    }

    public static void turnLeft() {
        motor_left.stop();
        motor_right.forward();
    }

    public static void turnRight() {
        motor_left.forward();
        motor_right.stop();
    }

    public static void setSpeed(int speed) {
        motor_left.setSpeed(speed);
        motor_right.setSpeed(speed);
    }
}
