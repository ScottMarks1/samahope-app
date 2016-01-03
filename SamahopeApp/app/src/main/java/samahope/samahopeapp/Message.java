package samahope.samahopeapp;

/**
 * Created by smarks on 1/3/16.
 */
public class Message {
    public String str;
    public Person sender;

    public Message(String s, Person p) {
        str = s;
        sender = p;
    }
}
