package containers;


import agents.Device;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;


public class ExampleContainer {
    public static void main(String[] args) {
        try {
            Runtime runtime = Runtime.instance();

            Properties properties = new ExtendedProperties();
            properties.setProperty(Profile.GUI, "false");
            Profile profile = new ProfileImpl(properties);
            AgentContainer agentContainer = runtime.createMainContainer(profile);

            ExampleContainer.start();

            AgentController badGirl = agentContainer.createNewAgent("BadGirl", "agents.BadGirl", new Object[]{});
            //AgentController goodBoy = agentContainer.createNewAgent("Good Boy", "Dogs.BadGirl", new Object[]{});

            badGirl.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void start() {
        Device.init();
    }
}
