package samahope.samahopeapp;

/**
 * Created by smarks on 1/3/16.
 */
public class ParseTextHandler implements TextHandler {

    public void recieveText(Message text) {
    //This should probably take a android.provider.Telephony.sms instead, but whatev
        Conversation conv;
        Person sender = text.sender;
        if(hasConversation(sender)) {
            conv = getConversation(sender);
        }
        else {
            conv = new Conversation(sender);
        }
        conv.addMessage(text);
        addConversation(conv);
        return;
    }

    /**
     * adds conversation to the list of Conversations and stores it using Parse
     */
    public void addConversation(Conversation conversation) {
        //TODO
        return;
    }

    //We are going to need to refactor all this if/when we implement group messages

    /**
     * returns true iff the list of Conversations contains a conversation with this person
     */
    public boolean hasConversation(Person person) {
        //TODO
        return false;
    }

    /**
     * returns the conversation with person. requires hasConversation(person) == true.
     */
    public Conversation getConversation(Person person) {
        return new Conversation();
    }
}
