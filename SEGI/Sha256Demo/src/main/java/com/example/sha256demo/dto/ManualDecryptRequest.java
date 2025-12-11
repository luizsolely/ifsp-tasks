package com.example.sha256demo.dto;

public class ManualDecryptRequest {
    private String encryptedDataBase64;
    private String privateKeyBase64;

    public String getEncryptedDataBase64() {
        return encryptedDataBase64;
    }

    public void setEncryptedDataBase64(String encryptedDataBase64) {
        this.encryptedDataBase64 = encryptedDataBase64;
    }

    public String getPrivateKeyBase64() {
        return privateKeyBase64;
    }

    public void setPrivateKeyBase64(String privateKeyBase64) {
        this.privateKeyBase64 = privateKeyBase64;
    }
}

