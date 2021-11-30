package agents;

import UWB.mqtt.TagMqtt;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;
import org.eclipse.paho.client.mqttv3.MqttException;

public class BadGirl extends Agent {
    int[][] path = new int[][]{{5147, 6019}, {5147, 7019}};
    int path_iterator = 0;
    final TagMqtt tag = new TagMqtt("682E");

    OneShotBehaviour go_forward = new OneShotBehaviour() {
        @Override
        public void action() {

            try {
                // call forward function
                Device.forward();
                System.out.println("I'm going forward");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    OneShotBehaviour go_backward = new OneShotBehaviour() {
        @Override
        public void action() {

            try {
                // call forward function
                Device.backward();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    OneShotBehaviour turn_right = new OneShotBehaviour() {
        @Override
        public void action() {

            try {
                // call forward function
                Device.turnLeft();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    OneShotBehaviour turn_left = new OneShotBehaviour() {
        @Override
        public void action() {

            try {
                // call forward function
                Device.turnRight();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    OneShotBehaviour stop = new OneShotBehaviour() {
        @Override
        public void action() {
            try {
                // call forward function
                Device.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public BadGirl() throws MqttException {
    }

    protected void setup() {

        addBehaviour(new TickerBehaviour(this, 100) {
            @Override
            protected void onTick() {
                removeBehaviour(go_backward);
                removeBehaviour(go_forward);
                removeBehaviour(turn_right);
                removeBehaviour(turn_left);

                if (path_iterator >= path.length) {
                    addBehaviour(stop);
                    stop();
                } else {
                    try {

                        int x = tag.getSmoothenedLocation(10).x;
                        int y = tag.getSmoothenedLocation(10).y;

                        if (x != 0 && y != 0) {

                            int target_x = path[path_iterator][0];
                            int target_y = path[path_iterator][1];
                            float yaw = (float) Math.toDegrees(tag.yaw);

                            float target_angle = (float) Math.toDegrees(Math.atan2(y - target_y, target_x - x));

                            float diff_angle = target_angle - yaw;
                            diff_angle = diff_angle % 360;
                            while (diff_angle < 0) { //pretty sure this comparison is valid for doubles and floats
                                diff_angle += 360.0;
                            }


                            if (diff_angle > 15 && diff_angle <= 180) {
                                addBehaviour(turn_right);
                            } else if (diff_angle < 345 && diff_angle > 180) {
                                addBehaviour(turn_left);
                            } else if (Math.abs(target_x - x) > 250 || Math.abs(target_y - y) > 250) {
                                addBehaviour(go_forward);
                            } else {
                                ++path_iterator;
                            }

                            System.out.println(target_x + ":" + target_y + " - " + tag.getSmoothenedLocation(10));
                            System.out.println(target_angle + " - " + yaw + " = " + diff_angle);
                        }
                    } catch (Exception e) {
                        System.out.println("exception");
                    }
                }

            }
        });



        /*addBehaviour(new Behaviour() {
            @Override
            public void action() {
                addBehaviour(go_forward);

            }

            @Override
            public boolean done() {
                //  if (press)
                //      return true;
                //     else
                return false;
            }
        });*/

    }

 /*   public  void go_forward() {

        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                Device.forward();
            }
        });
    }
   */

}


/*
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {

                try {
                    devRobot.descentForProduct();
                    System.out.println(" Step 2 : Descent for product");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }););

    }

 */

