import actors.GreetingActor;
import actors.GreetingMessage;
import actors.ReceiverActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.RoundRobinRouter;
import scala.collection.JavaConversions;
import scala.collection.mutable.Buffer;

import java.util.Collections;

public class AkkaMain {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("MySystem");
        Buffer<Object> empty = JavaConversions.asScalaBuffer(Collections.emptyList());

        ActorRef greeter = system.actorOf(Props.create(GreetingActor.class, empty), "greeting-actor");
        int numberOfActors = 3;
        system.actorOf(Props.create(ReceiverActor.class, empty).withRouter(new RoundRobinRouter(numberOfActors)), "receiver-actor");

        greeter.tell(new GreetingMessage("Mao Chao"), ActorRef.noSender());
    }
}
