package samahope.samahopeapp;

/**
 * Created by smarks on 1/2/16.
 */
public interface TextHandler {

    public void recieveText(Message message);

    public void addConversation(Conversation conversation);

    public boolean hasConversation(Person person);

    public Conversation getConversation(Person person);
}
