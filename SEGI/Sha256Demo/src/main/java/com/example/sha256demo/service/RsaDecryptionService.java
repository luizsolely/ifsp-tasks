package com.example.sha256demo.service;

import com.example.sha256demo.config.RsaKeyConfig;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

@Service
public class RsaDecryptionService {

    private final RsaKeyConfig keyConfig;

    public RsaDecryptionService(RsaKeyConfig keyConfig) {
        this.keyConfig = keyConfig;
    }

    public String decryptWithProvidedPrivateKey(byte[] encryptedData, String privateKeyBase64) {
        try {
            byte[] privateBytes = Base64.getDecoder().decode(privateKeyBase64);

            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedBytes = cipher.doFinal(encryptedData);

            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao descriptografar com chave privada fornecida", e);
        }
    }


    public String decrypt(byte[] encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, keyConfig.getKeyPair().getPrivate());
            byte[] decryptedBytes = cipher.doFinal(encryptedData);
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


