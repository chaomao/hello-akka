package actors;

import akka.actor.ActorSelection;
import akka.actor.UntypedActor;

public class GreetingActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof GreetingMessage) {
            System.out.println("Hello from " + ((GreetingMessage)message).who);
            ActorSelection receiverSelection = context().system().actorSelection("/user/receiver-actor");
            receiverSelection.tell(new ReceiveMessage());
        } else {
            unhandled(message);
        }
    }
}

