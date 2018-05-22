package sg.edu.rp.c346.c390app1;

/**
 * Created by 16046473 on 7/1/2018.
 */

public class ChatMessage {

    private String messageText;
    private String messageUser;
    private long messageTime;
    private String id;

    public ChatMessage() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public ChatMessage(String messageText, long messageTime, String messageUser) {
        this.messageText = messageText;
        this.messageTime = messageTime;
        this.messageUser = messageUser;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageUser() {
        return messageUser;
    }


    public long getMessageTime() {
        return messageTime;
    }

}
