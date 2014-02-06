import actors.GreetingActor;
import actors.GreetingMessage;
import actors.ReceiverActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import scala.collection.JavaConversions;
import scala.collection.mutable.Buffer;

import java.util.Collections;

public class AkkaMain {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("MySystem");
        Buffer<Object> empty = JavaConversions.asScalaBuffer(Collections.emptyList());

        ActorRef greeter = system.actorOf(Props.create(GreetingActor.class, empty), "greeting-actor");
        system.actorOf(Props.create(ReceiverActor.class, empty), "receiver-actor");

        greeter.tell(new GreetingMessage("Mao Chao"), ActorRef.noSender());
    }
}
