package raf.dsw.gerumap.gui.swing.message;

import java.time.LocalDateTime;

public class Message {                 //product koji pravimo i njega vraca fabrika

    public String messageContent;
    public EventType eventType;
    private LocalDateTime dateTime;
    private MessageType messageType;


    public Message(String messageContent, MessageType messageType, EventType eventType) {
        this.messageContent = messageContent;
        this.eventType = eventType;
        this.dateTime = LocalDateTime.now();
        this.messageType = messageType;
    }


    public String getMessageContent() {
        return messageContent;
    }


    @Override
    public String toString() {
        return "["+eventType+"]" +"["+LocalDateTime.now()+ "]" +"["+messageContent+"]";
    }
}
