package actors;

import akka.actor.ActorSelection;
import akka.actor.UntypedActor;

public class GreetingActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof GreetingMessage) {
            System.out.println("Hello from " + ((GreetingMessage) message).who);
            ActorSelection receiverSelection = context().system().actorSelection("/user/receiver-actor");
            for (int i = 0; i < 10; i++) {
                receiverSelection.tell(new ReceiveMessage(i));
            }
        } else {
            unhandled(message);
        }
    }
}

