package agents;


import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.ev3.EV3TouchSensor;
import ev3dev.sensors.ev3.EV3UltrasonicSensor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;


public class Device
{
    static EV3LargeRegulatedMotor motor_left = null;
    static EV3LargeRegulatedMotor motor_right = null;
    static EV3UltrasonicSensor sensor_sonic = null;
    static EV3TouchSensor sensor_touch = null;

    public static void init()
    {
        motor_left = new EV3LargeRegulatedMotor(MotorPort.B);
        motor_right = new EV3LargeRegulatedMotor(MotorPort.C);
        sensor_sonic = new EV3UltrasonicSensor(SensorPort.S3);
        sensor_touch = new EV3TouchSensor(SensorPort.S4);
/*
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.out.println("Emergency Stop");
                motor_left.stop();
                motor_right.stop();
            }
        }));*/


    }

    public  static void  stop()
    {
        System.out.println("Stop");

        motor_left.stop();
        motor_right.stop();

        Delay.msDelay(1000);
    }

    public  static void  backward()
    {
        System.out.println("Backward");

        motor_left.backward();
        motor_right.backward();

        Delay.msDelay(1000);
    }

    public  static void  forward()
    {
        System.out.println("Forward");

        motor_left.forward();
        motor_right.forward();

        Delay.msDelay(1000);
    }

    public  static void  turnLeft()
    {
        System.out.println("Left");

        motor_left.stop();
        motor_right.forward();

        Delay.msDelay(1000);
    }

    public  static void  turnRight()
    {
        System.out.println("Right");

        motor_left.forward();
        motor_right.stop();

        Delay.msDelay(1000);
    }

    public static void setSpeed(int speed)
    {
        motor_left.setSpeed(speed);
        motor_right.setSpeed(speed);

        Delay.msDelay(1000);
    }
}
