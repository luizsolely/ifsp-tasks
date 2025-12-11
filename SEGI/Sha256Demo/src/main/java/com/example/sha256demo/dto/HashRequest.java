package com.example.sha256demo.dto;

public class HashRequest {
    private String text;

    public HashRequest() {}
    public HashRequest(String text) { this.text = text; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}
