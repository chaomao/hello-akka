package actors;

import akka.actor.UntypedActor;

public class ReceiverActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof ReceiveMessage) {
            System.out.println(String.format("Received message '%s' in actor %s",
                    ((ReceiveMessage)message).number, getSelf().path().name()));
        } else {
            unhandled(message);
        }
    }
}

