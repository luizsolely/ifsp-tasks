package com.example.sha256demo.service;

import com.example.sha256demo.config.RsaKeyConfig;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;

@Service
public class RsaEncryptionService {

    private final RsaKeyConfig keyConfig;

    public RsaEncryptionService(RsaKeyConfig keyConfig) {
        this.keyConfig = keyConfig;
    }

    public byte[] encrypt(String text) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, keyConfig.getKeyPair().getPublic());
            return cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

