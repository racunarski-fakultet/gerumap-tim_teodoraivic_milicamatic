package raf.dsw.gerumap.gui.swing.message;

import java.time.LocalDateTime;

public class Message {                 //product koji pravimo i njega vraca fabrika

    public String messageContent;
    public EventType eventType;
    private LocalDateTime dateTime;


    public Message(String messageContent, EventType eventType) {
        this.messageContent = messageContent;
        this.eventType = eventType;
        this.dateTime = getDate();
    }



    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public LocalDateTime getDate() {
        return dateTime;
    }


}
