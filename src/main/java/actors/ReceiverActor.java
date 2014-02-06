package actors;

import akka.actor.UntypedActor;

public class ReceiverActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof ReceiveMessage) {
            System.out.println("Receive message!");
        } else {
            unhandled(message);
        }
    }
}

