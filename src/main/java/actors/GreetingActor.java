package actors;

import akka.actor.UntypedActor;

public class GreetingActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof GreetingMessage) {
            System.out.println("Hello from " + ((GreetingMessage)message).who);
        } else {
            unhandled(message);
        }
    }
}

