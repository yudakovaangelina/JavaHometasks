/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mirea.kt.example;

import java.io.Serializable;

/**
 *
 * 
 */
public class Message implements Serializable{
    private int id;
    private String body;
    private String type;
    private boolean hasAttachments;
    private long timestamp;
    
    private static final long  serialVersionUID = -3380157693869190848L;

   
    
    

    public Message(int id, String body, String type, boolean hasAttachments, long timestamp) {
        this.id = id;
        this.body = body;
        this.type = type;
        this.hasAttachments = hasAttachments;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHasAttachments() {
        return hasAttachments;
    }

    public void setHasAttachments(boolean hasAttachments) {
        this.hasAttachments = hasAttachments;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
     @Override
    public String toString() {
        return "Id is: " + this.id + ", body is " + this.body + ", type is " + this.type + ", attachments " + this.hasAttachments + ", timestampt is " + this.timestamp;
    }
}
