package com.example.demo.model;

public class CaptureMessage {
    private String nickname;
    private String options;
    private String color;
    
    public CaptureMessage() {
    	this.color="green";
    	
    }

    public CaptureMessage(String nickname) {
    	this.nickname=nickname;
    	this.options=" ";
    	this.color="green";
    }

    public CaptureMessage(String nickname, String options) {
        this.nickname = nickname;
        this.options = options;
        this.color="green";
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
    	System.out.println("Nickname set");
        this.nickname = nickname;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
    	System.out.println("options set");
        this.options = options;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
    	System.out.println("color set");
        this.color = color;
    }
}
