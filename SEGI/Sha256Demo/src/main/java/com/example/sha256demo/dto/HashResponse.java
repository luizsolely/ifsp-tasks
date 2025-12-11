package com.example.sha256demo.dto;

public class HashResponse {
    private String hex;

    public HashResponse(String hex) {
        this.hex = hex;
    }

    public String getHex() { return hex; }
    public void setHex(String hex) { this.hex = hex; }
}

