package agents;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;

public class BadGirl extends Agent {
    int[] path = new int[]{1, 1, 1, 1, 3, 3, 1, 1, 1, 1, 4, 4, 2, 2, 2, 2};
    int path_iterator = 0;

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

    protected void setup() {

        addBehaviour(new TickerBehaviour(this, 1000) {
            @Override
            protected void onTick() {
                if (path_iterator >= path.length) {
                    addBehaviour(stop);
                    stop();
                } else {

                    if (path[path_iterator] == 1) {
                        addBehaviour(go_forward);
                    } else if (path[path_iterator] == 2) {
                        addBehaviour(go_backward);
                    } else if (path[path_iterator] == 3) {
                        addBehaviour(turn_left);
                    } else if (path[path_iterator] == 4) {
                        addBehaviour(turn_right);
                    }

                    ++path_iterator;

                }

                System.out.println("TICK!!");

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


