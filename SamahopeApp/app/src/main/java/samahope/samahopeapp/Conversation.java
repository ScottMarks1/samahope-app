package samahope.samahopeapp;

import java.util.LinkedList;

/**
 * Created by smarks on 1/3/16.
 */
public class Conversation {
    Person sender;
    LinkedList<Message> messages;

    public Conversation(Person p) {
        sender = p;
        messages = new LinkedList<Message>();
    }

    public void addMessage(Message m) {
        messages.addFirst(m);
    }
}
