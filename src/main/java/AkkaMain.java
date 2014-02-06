import actors.GreetingActor;
import actors.GreetingMessage;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import scala.collection.JavaConversions;

import java.util.Collections;

public class AkkaMain {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("MySystem");
        ActorRef greeter = system.actorOf(Props.create(GreetingActor.class,
                JavaConversions.asScalaBuffer(Collections.emptyList())), "greeting-actor");
        greeter.tell(new GreetingMessage("Mao Chao"), ActorRef.noSender());
    }
}
